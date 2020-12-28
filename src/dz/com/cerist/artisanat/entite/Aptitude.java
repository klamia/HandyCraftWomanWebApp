package dz.com.cerist.artisanat.entite;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Aptitude {

	@InstanceIdentifier
	private Long id;
	
	public Aptitude () {
		
	}
	
	public Aptitude(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
