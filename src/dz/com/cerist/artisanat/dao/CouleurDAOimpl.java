package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Couleurs;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iCouleurDao")
@Transactional
public class CouleurDAOimpl implements Serializable, ICouleurDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5860256224231925888L;

	
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void ajouterCouleur(Couleurs couleur) {
		// TODO Auto-generated method stub
		try{
			  
			em.persist(couleur); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 } 
	}

	@Override
	public Couleurs getCouleurbyId(Long id) {
		// TODO Auto-generated method stub
		try{
			return em.find(Couleurs.class, id);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,12);
			 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Couleurs> getAllCouleurs() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Couleurs.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Couleurs editerCouleur(Couleurs couleur) {
		// TODO Auto-generated method stub
		try{
			return em.merge(couleur);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
