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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "artisanes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artisanes.findAll", query = "SELECT a FROM Artisanes a"),
    @NamedQuery(name = "Artisanes.findById", query = "SELECT a FROM Artisanes a WHERE a.id = :id"),
    @NamedQuery(name = "Artisanes.findByNom", query = "SELECT a FROM Artisanes a WHERE a.nom = :nom"),
    @NamedQuery(name = "Artisanes.findByPrenom", query = "SELECT a FROM Artisanes a WHERE a.prenom = :prenom"),
    @NamedQuery(name = "Artisanes.findByDateNaiss", query = "SELECT a FROM Artisanes a WHERE a.dateNaiss = :dateNaiss"),
    @NamedQuery(name = "Artisanes.findByLieuNaiss", query = "SELECT a FROM Artisanes a WHERE a.lieuNaiss = :lieuNaiss"),
    @NamedQuery(name = "Artisanes.findByEmail", query = "SELECT a FROM Artisanes a WHERE a.email = :email"),
    @NamedQuery(name = "Artisanes.findByAdresse", query = "SELECT a FROM Artisanes a WHERE a.adresse = :adresse"),
    @NamedQuery(name = "Artisanes.findByNumTel", query = "SELECT a FROM Artisanes a WHERE a.numTel = :numTel"),
    @NamedQuery(name = "Artisanes.findByStatutMarital", query = "SELECT a FROM Artisanes a WHERE a.statutMarital = :statutMarital"),
    @NamedQuery(name = "Artisanes.findByNbEnfants", query = "SELECT a FROM Artisanes a WHERE a.nbEnfants = :nbEnfants"),
    @NamedQuery(name = "Artisanes.findByInputMode", query = "SELECT a FROM Artisanes a WHERE a.inputMode = :inputMode"),
    @NamedQuery(name = "Artisanes.findByOutputMode", query = "SELECT a FROM Artisanes a WHERE a.outputMode = :outputMode"),
    @NamedQuery(name = "Artisanes.findByOrganisation", query = "SELECT a FROM Artisanes a WHERE a.organisation = :organisation"),
    @NamedQuery(name = "Artisanes.findByCoordination", query = "SELECT a FROM Artisanes a WHERE a.coordination = :coordination"),
    @NamedQuery(name = "Artisanes.findByEducLevel", query = "SELECT a FROM Artisanes a WHERE a.educLevel = :educLevel"),
    @NamedQuery(name = "Artisanes.findByPersonnalite", query = "SELECT a FROM Artisanes a WHERE a.personnalite = :personnalite"),
    @NamedQuery(name = "Artisanes.findByNiveaucompLit", query = "SELECT a FROM Artisanes a WHERE a.niveaucompLit = :niveaucompLit"),
    @NamedQuery(name = "Artisanes.findByNivCapPhys", query = "SELECT a FROM Artisanes a WHERE a.nivCapPhys = :nivCapPhys"),
    @NamedQuery(name = "Artisanes.findByNivCapCogn", query = "SELECT a FROM Artisanes a WHERE a.nivCapCogn = :nivCapCogn")
    
})

public class Artisanes  implements Serializable  {
    private static final long serialVersionUID = 1L;
   
     @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "num_tel")
    private String numTel;
    @Basic(optional = false)
    @Column(name = "statut_marital")
    private String statutMarital;
    @Basic(optional = false)
    @Column(name = "nb_enfants")
    private int nbEnfants;
    @Basic(optional = false)
    @Column(name = "input_mode")
    private String inputMode;
    @Basic(optional = false)
    @Column(name = "output_mode")
    private String outputMode;
    @Basic(optional = false)
    @Column(name = "organisation")
    private String organisation;
    @Basic(optional = false)
    @Column(name = "coordination")
    private String coordination;
    @Basic(optional = false)
    @Column(name = "educ_level")
    private String educLevel;
    @Basic(optional = false)
    @Column(name = "personnalite")
    private String personnalite;
    @Basic(optional = false)
    @Column(name = "niveau_compLit")
    private String niveaucompLit;
    @Basic(optional = false)
    @Column(name = "niv_cap_phys")
    private String nivCapPhys;
    @Basic(optional = false)
    @Column(name = "niv_cap_cogn")
    
    private String nivCapCogn;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artisane")
    private List<Produits> produitsList;
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artisane")
    
    private List<Shop> shopsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artisane")
  
    private List<Item> itemsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artisane")
 
    private List<Order> ordersList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artisane")
   
    private List<Ressources> ressourcesList;
    @JoinColumn(name = "activite_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    
    private Activites activite;
    @JoinColumn(name = "wilaya_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    
    private Wilayas wilaya;
    @JoinColumn(name = "capCogn_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    
    private Capacitecogns capCogn;
    @JoinColumn(name = "compIteracy_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    
    private Computerliteracys compIteracy;
    @JoinColumn(name = "capPhy_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
   
    private Capacitephys capPhy;
    @JoinColumn(name = "diplome_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    
    private Diplomes diplome;
    @JoinColumn(name = "interet_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
 
    private Centresinterets interet;
    @JoinColumn(name = "langage_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    
    private Langages langage;
    
    @OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE}, optional = false)
	@JoinColumn(name="compte_ID", referencedColumnName = "ID", unique=true)
   
    private Comptes compte;
    
    
	
	public Artisanes() {
   
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

    public String getStatutMarital() {
        return statutMarital;
    }

    public void setStatutMarital(String statutMarital) {
        this.statutMarital = statutMarital;
    }

    public int getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(int nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public String getInputMode() {
        return inputMode;
    }

    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }

    public String getOutputMode() {
        return outputMode;
    }

    public void setOutputMode(String outputMode) {
        this.outputMode = outputMode;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getCoordination() {
        return coordination;
    }

    public void setCoordination(String coordination) {
        this.coordination = coordination;
    }

    public String getEducLevel() {
        return educLevel;
    }

    public void setEducLevel(String educLevel) {
        this.educLevel = educLevel;
    }

    public String getPersonnalite() {
        return personnalite;
    }

    public void setPersonnalite(String personnalite) {
        this.personnalite = personnalite;
    }

    public String getNiveaucompLit() {
        return niveaucompLit;
    }

    public void setNiveaucompLit(String niveaucompLit) {
        this.niveaucompLit = niveaucompLit;
    }

    public String getNivCapPhys() {
        return nivCapPhys;
    }

    public void setNivCapPhys(String nivCapPhys) {
        this.nivCapPhys = nivCapPhys;
    }

    public String getNivCapCogn() {
        return nivCapCogn;
    }

    public void setNivCapCogn(String nivCapCogn) {
        this.nivCapCogn = nivCapCogn;
    }

    /*
    @XmlTransient
    public List<Produits> getProduitsList() {
        return produitsList;
    }

    public void setProduitsList(List<Produits> produitsList) {
        this.produitsList = produitsList;
    }

    */
   
    
    
    
    @XmlTransient
    public List<Ressources> getRessourcesList() {
        return ressourcesList;
    }

    public List<Shop> getShopsList() {
		return shopsList;
	}

	public void setShopsList(List<Shop> shopsList) {
		this.shopsList = shopsList;
	}

	public void setRessourcesList(List<Ressources> ressourcesList) {
        this.ressourcesList = ressourcesList;
    }

    public Activites getActivite() {
        return activite;
    }

    public void setActivite(Activites activite) {
        this.activite = activite;
    }

    public Wilayas getWilaya() {
        return wilaya;
    }

    public void setWilaya(Wilayas wilaya) {
        this.wilaya = wilaya;
    }

    public Capacitecogns getCapCogn() {
        return capCogn;
    }

    public void setCapCogn(Capacitecogns capCogn) {
        this.capCogn = capCogn;
    }

    public Computerliteracys getCompIteracy() {
        return compIteracy;
    }

    public void setCompIteracy(Computerliteracys compIteracy) {
        this.compIteracy = compIteracy;
    }

    public Capacitephys getCapPhy() {
        return capPhy;
    }

    public void setCapPhy(Capacitephys capPhy) {
        this.capPhy = capPhy;
    }

    public Diplomes getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplomes diplome) {
        this.diplome = diplome;
    }

    public Centresinterets getInteret() {
        return interet;
    }

    public void setInteret(Centresinterets interet) {
        this.interet = interet;
    }

    public Langages getLangage() {
        return langage;
    }

    public void setLangage(Langages langage) {
        this.langage = langage;
    }

    
    
    public Comptes getCompte() {
		return compte;
	}

	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
	public List<Item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}

	
	public List<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}

	@Override
    public String toString() {
    	return String.format("Artisanes[%s]", getNom());
    }
    
}
