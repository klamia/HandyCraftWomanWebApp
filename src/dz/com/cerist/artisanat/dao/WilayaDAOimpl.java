package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.entite.Wilayas;
import dz.com.cerist.artisanat.exception.MyProfilException;


@Repository("iWilayaDao")
@Transactional
public class WilayaDAOimpl implements IWilayaDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6065331618009427143L;

	
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void ajouterWilaya(Wilayas wilaya) {
		// TODO Auto-generated method stub
		try{
			  
			em.persist(wilaya); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
		
		
	}

	@Override
	public Wilayas getWilayabyId(Long id) {
		// TODO Auto-generated method stub
		try{
			return em.find(Wilayas.class, id);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,12);
			 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wilayas> getAllWilaya() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Wilayas.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Wilayas editerWilaya(Wilayas wilaya) {
		// TODO Auto-generated method stub
		try{
			return em.merge(wilaya);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
