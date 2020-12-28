package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Diplome extends Competence implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6997846276806921719L;

	public Diplome() {
		
	}
	
	public Diplome(long id) {
		super(id);
	}
}
