/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author fa_do
 */
public class PetJpaController implements Serializable {

    public PetJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PetJpaController(){
        this.emf = Persistence.createEntityManagerFactory("PetShop2.0PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pet pet) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pet pet) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pet = em.merge(pet);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pet.getIdPet();
                if (findPet(id) == null) {
                    throw new NonexistentEntityException("The pet with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pet pet;
            try {
                pet = em.getReference(Pet.class, id);
                pet.getIdPet();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pet with id " + id + " no longer exists.", enfe);
            }
            em.remove(pet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pet> findPetEntities() {
        return findPetEntities(true, -1, -1);
    }

    public List<Pet> findPetEntities(int maxResults, int firstResult) {
        return findPetEntities(false, maxResults, firstResult);
    }

    private List<Pet> findPetEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pet.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pet findPet(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pet.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Pet> findPetByDonoId(Integer id) {
        EntityManager em = getEntityManager();
        try {
            //CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            //cq.select(cq.from(Pet.class));
            //Query query1 = em.createQuery(cq);
            Query query = em.createQuery("Select p from Pet p where p.idDono=:arg1");
            query.setParameter("arg1", id);
            return query.getResultList();
             
        } finally {
            em.close();
        }
    }

    public int getPetCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pet> rt = cq.from(Pet.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
