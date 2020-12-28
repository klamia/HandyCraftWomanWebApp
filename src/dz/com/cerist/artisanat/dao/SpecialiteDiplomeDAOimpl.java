package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.entite.SpecialiteDiplome;
import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iSpecialiteDiplomeDao")
@Transactional
public class SpecialiteDiplomeDAOimpl implements ISpecialiteDiplomeDao,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1515226944355302906L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	
	@Override
	public void ajouterSpecialiteDiplome(SpecialiteDiplome specialiteDiplome) {
		// TODO Auto-generated method stub
		try{
			  
			em.persist(specialiteDiplome); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
	
		
	}

	@Override
	public SpecialiteDiplome getSpecialitebyId(Long id) {
		// TODO Auto-generated method stub
		return em.find(SpecialiteDiplome.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SpecialiteDiplome> getAllSpecialite() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("SpecialiteDiplome.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public SpecialiteDiplome editerSpecialiteDiplome(
			SpecialiteDiplome specialiteDiplome) {
		// TODO Auto-generated method stub
		try{
			return em.merge(specialiteDiplome);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
