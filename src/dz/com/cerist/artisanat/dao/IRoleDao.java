package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Role;





public interface IRoleDao {

	public void persist(Role role);

	public Role merge(Role role);

	public Role findroleById(Integer coderole);
		
	public Role findroleByName(String intitulerole);
	
	public List<Role> findAllroles () ;
	
	public Role remove(Role role);
}
