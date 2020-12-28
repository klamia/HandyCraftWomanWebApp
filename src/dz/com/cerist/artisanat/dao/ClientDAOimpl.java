package dz.com.cerist.artisanat.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iClientDao")
@Transactional
public class ClientDAOimpl implements IClientDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627520111744823540L;

	
	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void ajouterProfil(Clients client) {
		try{
			  
			em.persist(client); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
	

	}

	@Override
	public Clients getClientbyId(Long id) {
		try{
			return em.find(Clients.class, id);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,12);
			 }
	}

	@Override
	public Clients editerClient(Clients client) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try{
					return em.merge(client);
					}
					catch (Throwable th){
						 throw new MyProfilException(th,14);
						 }
	}
}
