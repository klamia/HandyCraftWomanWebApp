package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Preference implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8286057677251436267L;
	@InstanceIdentifier
	private long id;
	
	public Preference() {
		
	}
	
	public Preference(long id) {
		super();
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
