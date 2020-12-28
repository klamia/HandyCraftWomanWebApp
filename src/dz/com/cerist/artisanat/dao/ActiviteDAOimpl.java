package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Activites;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iActiviteDao")
@Transactional
public class ActiviteDAOimpl implements IActiviteDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4967846718399518055L;

	
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	
	@Override
	public void ajouterActivite(Activites activite) {
		// TODO Auto-generated method stub
		try{
			  
			em.persist(activite); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
	}

	@Override
	public Activites getActivitebyId(Long id) {
		// TODO Auto-generated method stub
		try{
			return em.find(Activites.class, id);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,12);
			 }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Activites> getAllActivites() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Activites.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Activites editerActivite(Activites activite) {
		// TODO Auto-generated method stub
		try{
			return em.merge(activite);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
