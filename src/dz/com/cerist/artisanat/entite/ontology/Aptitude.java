package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Aptitude implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5602958494253945891L;
	@InstanceIdentifier
	private long id;
	
	public Aptitude () {
		
	}
	
	public Aptitude(long id) {
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
