package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Informatique extends Competence implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1060736507946780394L;

	public Informatique() {
		
	}
	
	public Informatique(long id) {
		super(id);
	}

}
