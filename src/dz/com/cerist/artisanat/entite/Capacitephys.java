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
@Table(name = "capacitephys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitephys.findAll", query = "SELECT c FROM Capacitephys c"),
    @NamedQuery(name = "Capacitephys.findById", query = "SELECT c FROM Capacitephys c WHERE c.id = :id"),
    @NamedQuery(name = "Capacitephys.findByNom", query = "SELECT c FROM Capacitephys c WHERE c.nom = :nom"),
    @NamedQuery(name = "Capacitephys.findByDescription", query = "SELECT c FROM Capacitephys c WHERE c.description = :description")})
public class Capacitephys implements Serializable {
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
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capPhy")
    private List<Artisanes> artisanesList;

    public Capacitephys() {
    }

    public Capacitephys(Long id) {
        this.id = id;
    }

    public Capacitephys(Long id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Artisanes> getArtisanesList() {
        return artisanesList;
    }

    public void setArtisanesList(List<Artisanes> artisanesList) {
        this.artisanesList = artisanesList;
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
        if (!(object instanceof Capacitephys)) {
            return false;
        }
        Capacitephys other = (Capacitephys) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.Capacitephys[ id=" + id + " ]";
    }
    
}