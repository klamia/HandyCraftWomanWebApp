/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



/**
 *
 * @author Lamia
 */
@Entity
@Table(name = "wilayas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wilayas.findAll", query = "SELECT w FROM Wilayas w"),
    @NamedQuery(name = "Wilayas.findById", query = "SELECT w FROM Wilayas w WHERE w.id = :id"),
    @NamedQuery(name = "Wilayas.findByNom", query = "SELECT w FROM Wilayas w WHERE w.nom = :nom")})

public class Wilayas implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wilaya")
    
    private List<Artisanes> artisanesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wilaya")
    
    private List<Clients> clientsList;
    
  
    
    public Wilayas() {
    }

    public Wilayas(Long id) {
		super();
		this.id = id;
	}

    public Wilayas(Long id, String nom) {
        this.id = id;
        this.nom = nom;
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

    @XmlTransient
    public List<Artisanes> getArtisanesList() {
        return artisanesList;
    }

    public void setArtisanesList(List<Artisanes> artisanesList) {
        this.artisanesList = artisanesList;
    }


    public List<Clients> getClientsList() {
		return clientsList;
	}

	public void setClientsList(List<Clients> clientsList) {
		this.clientsList = clientsList;
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
        if (!(object instanceof Wilayas)) {
            return false;
        }
        Wilayas other = (Wilayas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.Wilayas[ id=" + id + " ]";
    }
    
}
