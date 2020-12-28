package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import ro.tuc.dsrl.m2o.annotations.ObjectProperty;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Client extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6462315564313408706L;
	@ObjectProperty(value = "achete", range = Produit.class)
    private List<Produit> produits;
	@ObjectProperty(value = "consulteShop", range = Shops.class)
    private List<Shops> shops;
	public Client() {
		
	}
	
	public Client(long id, Wilaya wilaya) {
		super(id, wilaya);
		this.produits = new ArrayList<Produit>();
		this.shops = new ArrayList<Shops>();
	}
	
	public Client(long id, Wilaya wilaya, List<Produit> produits, List<Shops> shops) {
		super(id, wilaya);
		this.produits = produits;
		this.shops = shops;
	}
	
	public List<Produit> getProduits() {
	    return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	public List<Shops> getShops() {
	    return shops;
	}

	public void setShops(List<Shops> shops) {
		this.shops = shops;
	}
	
	
}
