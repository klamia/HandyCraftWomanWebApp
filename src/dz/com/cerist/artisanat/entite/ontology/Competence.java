package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Competence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7640284081240032688L;
	@InstanceIdentifier
	private long id;
	
	public Competence() {
		
	}
	
	public Competence(long id) {
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
