package dz.com.cerist.artisanat.dao;





import java.io.Serializable;
import java.util.List;





import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Comptes;

import dz.com.cerist.artisanat.exception.MyProfilException;



@Repository("iCompteDao")
@Transactional
public class CompteDAOimpl implements ICompteDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7098655403992689400L;
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

//	private Configuration config;
	
	
	@Override
	public void ajouterCompte(Comptes compte) {
		
		try{
		   // compte.setdCreationCompte(null);
			// Create a user actionToken which is needed for activation
	    //    compte.setActionToken(UUID.randomUUID().toString());
			em.persist(compte); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
	
        
	/*
		if(!em.contains(compte))
			System.out.println("Entity is not persisted yet, will persist now!");
		    em.persist(compte); 
		    if(em.contains(compte))
				System.out.println("persisted entity is - " + compte);
			else
				System.out.println("Entitiy is still not persisted after call to persist()");
	*/
	}

	@Override
	public Comptes getComptebyId(Long id) {
		try{
		return em.find(Comptes.class, id);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,12);
			 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comptes> getAllCompte() {
		try {
		
			// return em.createNamedQuery("Compte.findAll").setHint("org.hibernate.cacheable", true).getResultList();
			 return em.createNamedQuery("Comptes.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Comptes editerCompte(Comptes compte) {
		// TODO Auto-generated method stub
		try{
		return em.merge(compte);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,14);
			 }
	}
	
	@Override
	public Comptes getCompteByLogin(String username) {
		// TODO Auto-generated method stub
		 try{
		
			 Query query = em.createNamedQuery("Comptes.findByUsername");
				query.setParameter("username", username);
				return (Comptes) query.getSingleResult();
			
			 
			 //return (Compte) em.createNamedQuery("Compte.findByLogin").getSingleResult();
		 
		 }
		 catch (Throwable th){
			 throw new MyProfilException(th,15);
			 }
	}

	

	
}
