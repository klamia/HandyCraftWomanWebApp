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

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "produits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produits.findAll", query = "SELECT p FROM Produits p"),
    @NamedQuery(name = "Produits.findById", query = "SELECT p FROM Produits p WHERE p.id = :id"),
    @NamedQuery(name = "Produits.findByNomProduit", query = "SELECT p FROM Produits p WHERE p.nomProduit = :nomProduit"),
    @NamedQuery(name = "Produits.findByDescProduit", query = "SELECT p FROM Produits p WHERE p.descProduit = :descProduit"),
    @NamedQuery(name = "Produits.findByPrixProduit", query = "SELECT p FROM Produits p WHERE p.prixProduit = :prixProduit"),
    @NamedQuery(name = "Produits.findProduitsArtisane", query = "select p FROM Produits p join p.artisane ar where ar.id=:artisane_ID")
    })
public class Produits implements Serializable {
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
    @Column(name = "nomProduit")
    private String nomProduit;
    @Basic(optional = false)
    @Column(name = "descProduit")
    private String descProduit;
    @Basic(optional = false)
    @Column(name = "prixProduit", columnDefinition = "INT UNSIGNED")
    private Integer prixProduit;
    
    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "imageProduit")
    private byte[] imageProduit;
    
    @Basic(optional = false)
	@Column(name="etat")
	private String etat="NonPublie";
    
    @Basic(optional = false)
	@Column(name = "categorie")
	private String categorie;
    
    /*
    @JoinColumn(name = "categorie_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categorieproduit categorie;
    */
    
    @JoinColumn(name = "artisane_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Artisanes artisane;

   
    public Produits() {
    
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescProduit() {
        return descProduit;
    }

    public void setDescProduit(String descProduit) {
        this.descProduit = descProduit;
    }

    public Integer getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(Integer prixProduit) {
        this.prixProduit = prixProduit;
    }

    public byte[] getImageProduit() {
        return imageProduit;
    }

    public void setImageProduit(byte[] imageProduit) {
        this.imageProduit = imageProduit;
    }


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
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

	/*
	public Categorieproduit getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorieproduit categorie) {
		this.categorie = categorie;
	}
  */
	
	public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
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
        if (!(object instanceof Produits)) {
            return false;
        }
        Produits other = (Produits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return String.format("Produits[%s,%s]", getNomProduit(), getArtisane()); 
    }
    
}
