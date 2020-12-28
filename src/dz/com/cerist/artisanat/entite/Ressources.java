/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lamia
 */
@Entity
@Table(name = "ressources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ressources.findAll", query = "SELECT r FROM Ressources r"),
    @NamedQuery(name = "Ressources.findById", query = "SELECT r FROM Ressources r WHERE r.id = :id"),
    @NamedQuery(name = "Ressources.findByNom", query = "SELECT r FROM Ressources r WHERE r.nom = :nom"),
    @NamedQuery(name = "Ressources.findByDesc", query = "SELECT r FROM Ressources r WHERE r.desc = :desc"),
    @NamedQuery(name = "Ressources.findByPrix", query = "SELECT r FROM Ressources r WHERE r.prix = :prix")})
public class Ressources implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "version")
    @Version
    private Integer version;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "description")
    private String desc;
    @Basic(optional = false)
    @Column(name = "prix")
    private float prix;
    @JoinColumn(name = "fournisseur_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Fournisseurs fournisseurID;
    @JoinColumn(name = "artisane_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Artisanes artisane;

    public Ressources() {
    }

    public Ressources(Long id) {
        this.id = id;
    }

    public Ressources(Long id, String nom, String desc, float prix) {
        this.id = id;
        this.nom = nom;
        this.desc = desc;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Fournisseurs getFournisseurID() {
        return fournisseurID;
    }

    public void setFournisseurID(Fournisseurs fournisseurID) {
        this.fournisseurID = fournisseurID;
    }

    public Artisanes getArtisane() {
        return artisane;
    }

    public void setArtisane(Artisanes artisane) {
        this.artisane = artisane;
    }

    
    
    public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ressources)) {
            return false;
        }
        Ressources other = (Ressources) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.Ressources[ id=" + id + " ]";
    }
    
}
