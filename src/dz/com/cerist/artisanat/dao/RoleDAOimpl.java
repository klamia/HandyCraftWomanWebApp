package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Role;
import dz.com.cerist.artisanat.exception.MyProfilException;




@Repository("iRoleDao")
@Transactional
public class RoleDAOimpl implements IRoleDao, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6819274723116200692L;
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void persist(Role role) {
		em.persist(role);
	}

	@Override
	public Role merge(Role role) {
		
		return em.merge(role);
	}

	@Override
	public Role findroleById(Integer coderole) {
		
		return em.find(Role.class, coderole );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllroles() {
		
		return em.createNamedQuery("Role.findAll").getResultList();
	}

	@Override
	public Role remove(Role role) {
		em.remove(em.merge(role));
		 return role;
	}

	

	@Override
	public Role findroleByName(String intitulerole) {
		try{
			
			 Query query = em.createNamedQuery("Role.findByName");
				query.setParameter("intitulerole", intitulerole);
				return (Role) query.getSingleResult(); 
		 
		 }
		 catch (Throwable th){
			 throw new MyProfilException(th,15);
			 }
	}

	

}
