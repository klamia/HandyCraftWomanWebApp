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




/**
 *
 * @author Lamia
 */

@Entity
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
    @NamedQuery(name = "Clients.findByNom", query = "SELECT c FROM Clients c WHERE c.nom = :nom"),
    @NamedQuery(name = "Clients.findByPrenom", query = "SELECT c FROM Clients c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Clients.findByDateNaiss", query = "SELECT c FROM Clients c WHERE c.dateNaiss = :dateNaiss"),
    @NamedQuery(name = "Clients.findByLieuNaiss", query = "SELECT c FROM Clients c WHERE c.lieuNaiss = :lieuNaiss"),
    @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email"),
  //  @NamedQuery(name = "Clients.findByWilaya", query = "SELECT c FROM Clients c WHERE c.wilaya = :wilaya"),
    @NamedQuery(name = "Clients.findByAdresse", query = "SELECT c FROM Clients c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Clients.findByNumTel", query = "SELECT c FROM Clients c WHERE c.numTel = :numTel"),
    @NamedQuery(name = "Clients.findBySexe", query = "SELECT c FROM Clients c WHERE c.sexe = :sexe")})

public class Clients implements Serializable {
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
    @ManyToOne(optional = false)
    @JoinColumn(name = "wilaya_ID", referencedColumnName = "ID")
   
    private Wilayas wilaya;
    @Basic(optional = false)
    @Column(name = "adresse")
   
    private String adresse;
    @Basic(optional = false)
    @Column(name = "num_tel")
    
    private String numTel;
    @Basic(optional = false)
    @Column(name = "sexe")
    
    private String sexe;
   
    /*
    @Column(name = "mode_paiement", nullable = true)
    
    private PaymentMethodEnum paymentMethod;
    */
    @OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE}, optional = false)
	@JoinColumn(name="compte_ID", referencedColumnName = "ID", unique=true)
    
    private Comptes compte;
    
    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
  
    private Cart cart;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
   
    private List<Order> listOrders;
   
    
    
    public Clients() {
    }

    
    public Clients(Long id) {
        this.id = id;
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

    

    public Wilayas getWilaya() {
		return wilaya;
	}

	public void setWilaya(Wilayas wilaya) {
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

    /*
    public PaymentMethodEnum getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
*/
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
	public Comptes getCompte() {
		return compte;
	}

	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	
	
	
	public Cart getCart() {
		
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Order> listOrders) {
		this.listOrders = listOrders;
	}

	

	


    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.Clients[ IdClient=" + id + " ]";
    }
    
}
