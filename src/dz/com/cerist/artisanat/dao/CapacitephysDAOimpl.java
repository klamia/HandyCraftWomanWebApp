package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Capacitephys;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iCapacitephysDao")
@Transactional
public class CapacitephysDAOimpl implements ICapacitephysDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2256956342836327953L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
	
	@Override
	public void ajouterCapacitephys(Capacitephys capacitephys) {
		try{
			   
				em.persist(capacitephys); 
			
			}
			catch (Throwable th){
				 throw new MyProfilException(th,11);
				 }

	}

	@Override
	public Capacitephys getCapacitephysbyId(Long id) {
		// TODO Auto-generated method stub
		return em.find(Capacitephys.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Capacitephys> getAllCapacitephys() {
		try {
			
			// return em.createNamedQuery("Compte.findAll").setHint("org.hibernate.cacheable", true).getResultList();
			 return em.createNamedQuery("Capacitephys.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Capacitephys editerCapacitephys(Capacitephys capacitephys) {
		// TODO Auto-generated method stub
		
		try{
		return em.merge(capacitephys);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,14);
			 }
	}

}
