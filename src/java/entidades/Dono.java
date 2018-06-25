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
@Table(name = "dono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dono.findAll", query = "SELECT d FROM Dono d")
    , @NamedQuery(name = "Dono.findByIdDono", query = "SELECT d FROM Dono d WHERE d.idDono = :idDono")
    , @NamedQuery(name = "Dono.findByEmail", query = "SELECT d FROM Dono d WHERE d.email = :email")
    , @NamedQuery(name = "Dono.findByNome", query = "SELECT d FROM Dono d WHERE d.nome = :nome")
    , @NamedQuery(name = "Dono.findByTelefone", query = "SELECT d FROM Dono d WHERE d.telefone = :telefone")})
public class Dono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDono")
    private Integer idDono;
    @Column(name = "email")
    private String email;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;

    public Dono() {
    }

    public Dono(Integer idDono) {
        this.idDono = idDono;
    }

    public Integer getIdDono() {
        return idDono;
    }

    public void setIdDono(Integer idDono) {
        this.idDono = idDono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDono != null ? idDono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dono)) {
            return false;
        }
        Dono other = (Dono) object;
        if ((this.idDono == null && other.idDono != null) || (this.idDono != null && !this.idDono.equals(other.idDono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Dono[ idDono=" + idDono + " ]";
    }
    
}
