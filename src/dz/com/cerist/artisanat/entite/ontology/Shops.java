	package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.ObjectProperty;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Shops implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7238049921417287886L;

	@InstanceIdentifier
	private long id;
	
	@ObjectProperty(value = "aRecommandeLocal", range = Client.class)
    private List<Client> cl_local;
	@ObjectProperty(value = "aRecommandeLocalProche", range = Client.class)
    private List<Client> cl_localProche;
	@ObjectProperty(value = "aRecommandeShop", range = Client.class)
    private List<Client> cl_interet;
	@ObjectProperty(value = "aRecommandeWilaya", range = Client.class)
    private List<Client> cl_wilaya;
	@ObjectProperty(value = "seLocaliseA", range = Wilaya.class)
    private Wilaya wilaya;
	@ObjectProperty(value = "shopAppartient", range = Artisane.class)
    private Artisane artisan;
	@ObjectProperty(value = "contientProd", range = Produit.class)
    private List<Produit> produits;
	
	
	public Shops() {
	}
	
	public Shops(long id, Artisane artisan, Wilaya wilaya) {
		super();
		this.id = id;
		this.artisan = artisan;
		this.wilaya = wilaya;
		this.produits = new ArrayList<Produit>();
		this.cl_local = new ArrayList<Client>();
		this.cl_localProche = new ArrayList<Client>();
		this.cl_wilaya = new ArrayList<Client>();
		this.cl_interet = new ArrayList<Client>();
	}
	
	public Shops(long id, Artisane artisan, Wilaya wilaya, List<Produit> produits) {
		super();
		this.id = id;
		this.artisan = artisan;
		this.wilaya = wilaya;
		this.produits = produits;
		this.cl_local = new ArrayList<Client>();
		this.cl_localProche = new ArrayList<Client>();
		this.cl_wilaya = new ArrayList<Client>();
		this.cl_interet = new ArrayList<Client>();
	}
	
	public Shops(long id, Artisane artisan, Wilaya wilaya, List<Produit> produits, List<Client> cl_local, List<Client> cl_localProche, List<Client> cl_wilaya, List<Client> cl_interet) {
		super();
		this.id = id;
		this.artisan = artisan;
		this.wilaya = wilaya;
		this.produits = produits;
		this.cl_local = cl_local;
		this.cl_localProche = cl_localProche;
		this.cl_wilaya = cl_wilaya;
		this.cl_interet = cl_interet;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Artisane getArtisan() {
	    return artisan;
	}

	public void setArtisan(Artisane artisan) {
		this.artisan = artisan;
	}
	public List<Produit> getProduits() {
	    return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public List<Client> getClientsLocal() {
	    return cl_local;
	}

	public void setClientsLocal(List<Client> clients) {
		this.cl_local = clients;
	}
	public List<Client> getClientsLocalProche() {
	    return cl_localProche;
	}

	public void setClientsLocalProche(List<Client> clients) {
		this.cl_localProche = clients;
	}
	public List<Client> getClientsWilaya() {
	    return cl_wilaya;
	}

	public void setClientsWilaya(List<Client> clients) {
		this.cl_wilaya = clients;
	}
	public List<Client> getClientsInterets() {
	    return cl_interet;
	}

	public void setClientsInterets(List<Client> clients) {
		this.cl_interet = clients;
	}

	public List<Client> getCl_local() {
		return cl_local;
	}

	public void setCl_local(List<Client> cl_local) {
		this.cl_local = cl_local;
	}

	public List<Client> getCl_localProche() {
		return cl_localProche;
	}

	public void setCl_localProche(List<Client> cl_localProche) {
		this.cl_localProche = cl_localProche;
	}

	public List<Client> getCl_interet() {
		return cl_interet;
	}

	public void setCl_interet(List<Client> cl_interet) {
		this.cl_interet = cl_interet;
	}

	public List<Client> getCl_wilaya() {
		return cl_wilaya;
	}

	public void setCl_wilaya(List<Client> cl_wilaya) {
		this.cl_wilaya = cl_wilaya;
	}

	public Wilaya getWilaya() {
		return wilaya;
	}

	public void setWilaya(Wilaya wilaya) {
		this.wilaya = wilaya;
	}


}
