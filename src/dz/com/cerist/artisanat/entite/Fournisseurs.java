/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lamia
 */
@Entity
@Table(name = "fournisseurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseurs.findAll", query = "SELECT f FROM Fournisseurs f"),
    @NamedQuery(name = "Fournisseurs.findById", query = "SELECT f FROM Fournisseurs f WHERE f.id = :id"),
    @NamedQuery(name = "Fournisseurs.findByNom", query = "SELECT f FROM Fournisseurs f WHERE f.nom = :nom"),
    @NamedQuery(name = "Fournisseurs.findByPrenom", query = "SELECT f FROM Fournisseurs f WHERE f.prenom = :prenom"),
    @NamedQuery(name = "Fournisseurs.findByDateNaiss", query = "SELECT f FROM Fournisseurs f WHERE f.dateNaiss = :dateNaiss"),
    @NamedQuery(name = "Fournisseurs.findByLieuNaiss", query = "SELECT f FROM Fournisseurs f WHERE f.lieuNaiss = :lieuNaiss"),
    @NamedQuery(name = "Fournisseurs.findByEmail", query = "SELECT f FROM Fournisseurs f WHERE f.email = :email"),
    @NamedQuery(name = "Fournisseurs.findByWilaya", query = "SELECT f FROM Fournisseurs f WHERE f.wilaya = :wilaya"),
    @NamedQuery(name = "Fournisseurs.findByAdresse", query = "SELECT f FROM Fournisseurs f WHERE f.adresse = :adresse"),
    @NamedQuery(name = "Fournisseurs.findByNumTel", query = "SELECT f FROM Fournisseurs f WHERE f.numTel = :numTel"),
    @NamedQuery(name = "Fournisseurs.findBySexe", query = "SELECT f FROM Fournisseurs f WHERE f.sexe = :sexe")})
public class Fournisseurs implements Serializable {
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
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "date_naiss")
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    @Basic(optional = false)
    @Column(name = "lieu_naiss")
    private String lieuNaiss;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "wilaya")
    private String wilaya;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "num_tel")
    private String numTel;
    @Basic(optional = false)
    @Column(name = "sexe")
    private String sexe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseurID")
    private List<Ressources> ressourcesList;

    public Fournisseurs() {
    }

    public Fournisseurs(Long id) {
        this.id = id;
    }

    public Fournisseurs(Long id, String nom, String prenom, Date dateNaiss, String lieuNaiss, String email, String wilaya, String adresse, String numTel, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.lieuNaiss = lieuNaiss;
        this.email = email;
        this.wilaya = wilaya;
        this.adresse = adresse;
        this.numTel = numTel;
        this.sexe = sexe;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getLieuNaiss() {
        return lieuNaiss;
    }

    public void setLieuNaiss(String lieuNaiss) {
        this.lieuNaiss = lieuNaiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @XmlTransient
    public List<Ressources> getRessourcesList() {
        return ressourcesList;
    }

    public void setRessourcesList(List<Ressources> ressourcesList) {
        this.ressourcesList = ressourcesList;
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
        if (!(object instanceof Fournisseurs)) {
            return false;
        }
        Fournisseurs other = (Fournisseurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.Fournisseurs[ id=" + id + " ]";
    }
    
}
