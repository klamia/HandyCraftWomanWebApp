package dz.com.cerist.artisanat.entite;

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
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Lamia
 */
@Entity
@Table(name = "categorieproduit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorieproduit.findAll", query = "SELECT cp FROM Categorieproduit cp"),
    @NamedQuery(name = "Categorieproduit.findById", query = "SELECT cp FROM Categorieproduit cp WHERE cp.id = :id"),
    @NamedQuery(name = "Categorieproduit.findByNom", query = "SELECT cp FROM Categorieproduit cp WHERE cp.nom = :nom")
    })
public class Categorieproduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "version")
    @Version
    private int version;
   
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<Produits> produits;

    public Categorieproduit() {
    }

    */

    

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

   /*
    @XmlTransient
    public List<Produits> getProduits() {
        return produits;
    }

    public void setProduits(List<Produits> produits) {
        this.produits = produits;
    }

    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorieproduit)) {
            return false;
        }
        Categorieproduit other = (Categorieproduit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.Categorieproduit[ id=" + id + " ]";
    }
    
}
