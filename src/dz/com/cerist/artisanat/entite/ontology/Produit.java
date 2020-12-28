package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.ObjectProperty;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3773798257508032593L;

	@InstanceIdentifier
	private long id;
	
	@ObjectProperty(value = "acheterPar", range = Client.class)
    private Client client;
	@ObjectProperty(value = "appartientADomaine", range = Activite.class)
    private Activite domaine;
	@ObjectProperty(value = "appartientAShop", range = Shops.class)
    private Shops shop;
	@ObjectProperty(value = "aRecommandeProd", range = Client.class)
    private List<Client> clients;
	@ObjectProperty(value = "aCouleur", range = Couleur.class)
    //private List<Couleur> couleur;
	private Couleur couleur;
	@ObjectProperty(value = "aTendance", range = Tendance.class)
    private Tendance tendance;
	@ObjectProperty(value = "aRecommandeProdCoul", range = Client.class)
    private List<Client> cl_coul;
	@ObjectProperty(value = "aRecommandeProdTend", range = Client.class)
    private List<Client> cl_tend;
	
	public Produit() {
	}
	
	public Produit(long id) {
		super();
		this.id = id;
	}
	
	public Produit(long id, Activite domaine, Shops shop, Tendance tendance) {
		super();
		this.id = id;
		this.domaine = domaine;
		this.shop = shop;
		this.tendance = tendance;
		//this.couleur = new ArrayList<Couleur>();
		this.clients = new ArrayList<Client>();
		this.cl_coul = new ArrayList<Client>();
		this.cl_tend = new ArrayList<Client>();
	}
	
	public Produit(long id, Shops shop, Tendance tendance, Couleur couleur) {
		super();
		this.id = id;
		this.shop = shop;
		this.tendance = tendance;
		//this.couleur = new ArrayList<Couleur>();
		this.couleur = couleur;
		this.clients = new ArrayList<Client>();
		this.cl_coul = new ArrayList<Client>();
		this.cl_tend = new ArrayList<Client>();
	}
	public Client getClient() {
	    return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	public Activite getDomaine() {
	    return domaine;
	}

	public void setDomaine(Activite domaine) {
		this.domaine = domaine;
	}
	public Shops getShop() {
	    return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}
	public List<Client> getClients() {
	    return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	/*public List<Couleur> getCouleur() {
	    return couleur;
	}

	public void setCouleur(List<Couleur> couleur) {
		this.couleur = couleur;
	}*/
	
	public Couleur getCouleur() {
	    return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Tendance getTendance() {
	    return tendance;
	}

	public void setTendance(Tendance tendance) {
		this.tendance = tendance;
	}
	
	public List<Client> getCl_coul() {
	    return cl_coul;
	}

	public void setCl_coul(List<Client> cl_coul) {
		this.cl_coul = cl_coul;
	}
	
	public List<Client> getCl_tend() {
	    return cl_tend;
	}

	public void setCl_tend(List<Client> cl_tend) {
		this.cl_tend = cl_tend;
	}
	
	
}
