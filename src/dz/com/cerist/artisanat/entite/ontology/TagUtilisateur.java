package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class TagUtilisateur extends Tag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1661656023325332700L;

	public TagUtilisateur() {
		
	}
	
	public TagUtilisateur(long id) {
		super(id);
	}
}
