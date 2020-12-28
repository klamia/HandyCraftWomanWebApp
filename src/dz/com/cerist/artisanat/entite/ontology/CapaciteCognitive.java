package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class CapaciteCognitive extends Aptitude implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8712107473374414566L;

	public CapaciteCognitive() {
		
	}
	
	public CapaciteCognitive(long id) {
		super(id);
	}
}
