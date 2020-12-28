package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class CapaciteMotrice extends CapacitePhysique implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7192058048026924265L;

	public CapaciteMotrice() {
		
	}
	
	public CapaciteMotrice(long id) {
		super(id);
	}
}
