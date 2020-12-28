package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Langages;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iLangageDao")
@Transactional
public class LangageDAOimpl implements ILangageDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5395090467649004021L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void ajouterLangage(Langages langage) {
		// TODO Auto-generated method stub
		try{
			  
			em.persist(langage); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
	}

	@Override
	public Langages getLangagebyId(Long id) {
		// TODO Auto-generated method stub
		try{
			return em.find(Langages.class, id);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,12);
			 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Langages> getAllLangages() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Langages.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Langages editerLangage(Langages langage) {
		try{
			return em.merge(langage);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}
	
	
	

}
