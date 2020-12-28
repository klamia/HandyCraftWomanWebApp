package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.entite.Diplomes;
import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iDiplomeDao")
@Transactional
public class DiplomeDAOimpl implements IDiplomeDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5217018432919089493L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void ajouterDiplome(Diplomes diplome) {
		// TODO Auto-generated method stub
		try{
			  
			em.persist(diplome); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
	
	}

	@Override
	public Diplomes getDiplomebyId(Long id) {
		// TODO Auto-generated method stub
		return em.find(Diplomes.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Diplomes> getAllDiplomes() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Diplomes.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Diplomes editerDiplome(Diplomes diplome) {
		// TODO Auto-generated method stub
		try{
			return em.merge(diplome);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}
	

}
