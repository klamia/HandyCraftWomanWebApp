package dz.com.cerist.artisanat.entite.ontology;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Tendance {
	@InstanceIdentifier
	private long id;
	
	public Tendance() {
		
	}
	
	public Tendance(long id) {
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
