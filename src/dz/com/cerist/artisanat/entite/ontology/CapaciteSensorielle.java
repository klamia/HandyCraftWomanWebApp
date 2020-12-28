package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class CapaciteSensorielle extends CapacitePhysique implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7143494828830491678L;

	public CapaciteSensorielle() {
		
	}
	
	public CapaciteSensorielle(long id) {
		super(id);
	}
}
