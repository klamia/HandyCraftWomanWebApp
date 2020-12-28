package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Centresinterets;
import dz.com.cerist.artisanat.exception.MyProfilException;


@Repository("iCentresinteretsDao")
@Transactional
public class CentresinteretsDAOimpl implements ICentresinteretsDao,
		Serializable {

	
	
    private static final long serialVersionUID = 5432393800130495024L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void ajouterInteret(Centresinterets interet) {
		try{
			  
			em.persist(interet); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }

	}

	@Override
	public Centresinterets getInteretbyId(Long id) {
		// TODO Auto-generated method stub
		return em.find(Centresinterets.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Centresinterets> getAllInterets() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Centresinterets.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Centresinterets editerInteret(Centresinterets interet) {
		// TODO Auto-generated method stub
		try{
			return em.merge(interet);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
