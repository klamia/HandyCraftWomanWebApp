package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class CentreInteret implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7568532761936985736L;
	@InstanceIdentifier
	private long id;
	
	public CentreInteret() {
		
	}
	
	public CentreInteret(long id) {
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
