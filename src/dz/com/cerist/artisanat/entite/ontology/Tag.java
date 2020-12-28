package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.ObjectProperty;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;

@OntologyEntity
public class Tag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2825107356296283313L;

	@InstanceIdentifier
	private long id;
	
	@ObjectProperty(value = "utilisePar", range = User.class)
    private List<User> users;
	
	public Tag() {
		
	}
	
	public Tag(long id) {
		super();
		this.id = id;
		this.users = new ArrayList<User>();
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setUser(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUser(){
		return this.users;
	}
}
