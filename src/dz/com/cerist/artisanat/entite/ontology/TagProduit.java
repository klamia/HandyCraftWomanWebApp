package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class TagProduit extends Tag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2182216588071623639L;

	public TagProduit() {
		
	}
	
	public TagProduit(long id) {
		super(id);
	}
}
