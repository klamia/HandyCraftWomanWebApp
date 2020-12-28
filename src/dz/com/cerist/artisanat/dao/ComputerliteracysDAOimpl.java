package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Computerliteracys;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iComputerliteracysDao")
@Transactional
public class ComputerliteracysDAOimpl implements IComputerliteracysDao,
		Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7387842951117290545L;
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void ajouterComputerliteracys(Computerliteracys computerliteracys) {
		try{
			  
			em.persist(computerliteracys); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }

	}

	@Override
	public Computerliteracys getComputerliteracysbyId(Long id) {
		// TODO Auto-generated method stub
		return em.find(Computerliteracys.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Computerliteracys> getAllComputerliteracys() {
		// TODO Auto-generated method stub
		try {
			
			
			 return em.createNamedQuery("Computerliteracys.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Computerliteracys editerComputerliteracys(
			Computerliteracys computerliteracys) {
		// TODO Auto-generated method stub
		try{
			return em.merge(computerliteracys);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
