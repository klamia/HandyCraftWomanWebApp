package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Langue extends Competence implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9055320613914733685L;

	public Langue() {
		
	}
	
	public Langue(long id) {
		super(id);
	}
}
