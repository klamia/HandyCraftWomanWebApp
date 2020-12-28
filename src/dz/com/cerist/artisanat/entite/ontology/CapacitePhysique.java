package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class CapacitePhysique extends Aptitude implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1891462734278209823L;

	/**
	 * 
	 */
	

	public CapacitePhysique() {
		
	}
	
	public CapacitePhysique(long id) {
		super(id);
	}

}
