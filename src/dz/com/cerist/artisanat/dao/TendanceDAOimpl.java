package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.entite.Tendances;
import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iTendanceDao")
@Transactional
public class TendanceDAOimpl implements Serializable, ITendanceDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5784639037892093220L;

	
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void ajouterTendance(Tendances tendance) {
		// TODO Auto-generated method stub
		try{
			  
			em.persist(tendance); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 } 
	}

	@Override
	public Tendances getTendancebyId(Long id) {
		// TODO Auto-generated method stub
		try{
			return em.find(Tendances.class, id);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,12);
			 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tendances> getAllTendances() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Tendances.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Tendances editerTendance(Tendances tendance) {
		// TODO Auto-generated method stub
		try{
			return em.merge(tendance);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
