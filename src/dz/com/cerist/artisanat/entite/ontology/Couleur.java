package dz.com.cerist.artisanat.entite.ontology;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Couleur {
	
	@InstanceIdentifier
	private long id;
	
	public Couleur() {
		
	}
	
	public Couleur(long id) {
		super();
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
