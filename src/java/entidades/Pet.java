/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fa_do
 */
@Entity
@Table(name = "pet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p")
    , @NamedQuery(name = "Pet.findByIdPet", query = "SELECT p FROM Pet p WHERE p.idPet = :idPet")
    , @NamedQuery(name = "Pet.findByCaracteristicas", query = "SELECT p FROM Pet p WHERE p.caracteristicas = :caracteristicas")
    , @NamedQuery(name = "Pet.findByEspecie", query = "SELECT p FROM Pet p WHERE p.especie = :especie")
    , @NamedQuery(name = "Pet.findByNome", query = "SELECT p FROM Pet p WHERE p.nome = :nome")
    , @NamedQuery(name = "Pet.findByRaca", query = "SELECT p FROM Pet p WHERE p.raca = :raca")
    , @NamedQuery(name = "Pet.findByIdDono", query = "SELECT p FROM Pet p WHERE p.idDono = :idDono")})
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPet")
    private Integer idPet;
    @Column(name = "caracteristicas")
    private String caracteristicas;
    @Column(name = "especie")
    private String especie;
    @Column(name = "nome")
    private String nome;
    @Column(name = "raca")
    private String raca;
    @Column(name = "idDono")
    private Integer idDono;

    public Pet() {
    }

    public Pet(Integer idPet) {
        this.idPet = idPet;
    }

    public Integer getIdPet() {
        return idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdDono() {
        return idDono;
    }

    public void setIdDono(Integer idDono) {
        this.idDono = idDono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPet != null ? idPet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) object;
        if ((this.idPet == null && other.idPet != null) || (this.idPet != null && !this.idPet.equals(other.idPet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pet[ idPet=" + idPet + " ]";
    }
    
}
