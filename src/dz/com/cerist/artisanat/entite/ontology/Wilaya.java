package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;
import java.util.List;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.ObjectProperty;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Wilaya implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5815479619574056409L;

	@InstanceIdentifier
	private long id;
	
	@ObjectProperty(value = "voisin", range = Wilaya.class)
    private List<Wilaya> wilayas;
	
	public Wilaya() {
		
	}
	public Wilaya(long id) {
		super();
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public List<Wilaya> getWilayas() {
		return wilayas;
	}
	public void setWilayas(List<Wilaya> wilayas) {
		this.wilayas = wilayas;
	}


}
