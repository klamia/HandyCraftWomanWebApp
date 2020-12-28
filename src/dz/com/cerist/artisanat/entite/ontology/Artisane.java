package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ro.tuc.dsrl.m2o.annotations.ObjectProperty;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Artisane extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2273815348174832194L;
	@ObjectProperty(value = "aDomaine", range = Activite.class)
    private Activite domaine;
	@ObjectProperty(value = "aPersonalite", range = Personalite.class)
    private List<Personalite> personalites;
	@ObjectProperty(value = "aShop", range = Shops.class)
    private List<Shops> shops;
	

	public Artisane() {
		
	}
	
	public Artisane(long id, Activite domaine, Wilaya wilaya) {
		super(id, wilaya);
		this.domaine =domaine;
		this.personalites = new ArrayList<Personalite>();
		this.shops = new ArrayList<Shops>();
	}
	
	public Artisane(long id, Activite domaine, Wilaya wilaya, List<Personalite> personalites, List<Shops> shops) {
		super(id, wilaya);
		this.domaine =domaine;
		this.personalites = personalites;
		this.shops = shops;
	}
	
	
	
	public Activite getDomaine() {
	    return domaine;
	}

	public void setDomaine(Activite domaine) {
		this.domaine = domaine;
	}
	public List<Personalite> getPersonalites() {
	    return personalites;
	}

	public void setPersonalites(List<Personalite> personalites) {
		this.personalites = personalites;
	}
	public List<Shops> getShops() {
	    return shops;
	}

	public void setShops(List<Shops> shops) {
		this.shops = shops;
	}

}
