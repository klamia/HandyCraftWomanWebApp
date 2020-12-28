package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;

import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Fournisseur extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -776322794524131367L;

	public Fournisseur() {
		
	}
	
	public Fournisseur(long id, Wilaya wilaya) {
		super(id, wilaya);
	}

}
