package dz.com.cerist.artisanat.dao;

import java.io.Serializable;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Artisanes;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iArtisaneDao")
@Transactional
public class ArtisaneDAOimpl implements IArtisaneDao, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6262222385970597039L;
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void ajouterProfil(Artisanes artisane) {
		// TODO Auto-generated method stub

		try{
			  
				em.persist(artisane); 
			
			}
			catch (Throwable th){
				 throw new MyProfilException(th,11);
				 }
		
	}

	@Override
	public Artisanes getArtisanebyId(Long id) {
		// TODO Auto-generated method stub
		try{
		return em.find(Artisanes.class, id);
	}
	catch (Throwable th){
		 throw new MyProfilException(th,12);
		 }
	}

	/*
	@SuppressWarnings("unchecked")
	@Override
	public List<Artisanes> getAllArtisanes() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Artisanes.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}
    */
	
	@Override
	public Artisanes editerProfil(Artisanes artisane) {
		// TODO Auto-generated method stub
		try{
			return em.merge(artisane);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
