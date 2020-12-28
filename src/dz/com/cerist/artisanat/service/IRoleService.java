package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Role;



public interface IRoleService {

	public void persist(Role role);

	public Role merge(Role role);

	public Role findroleById(Integer coderole);
		
	public Role findroleByName(String intitulerole);
	
	public List<Role> findAllroles () ;
	
	public Role remove(Role role);
}
