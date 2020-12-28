package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Capacitecogns;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iCapacitecognsDao")
@Transactional
public class CapacitecognsDAOimpl  implements ICapacitecognsDao, Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7416267196280489452L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void ajouterCapacitecogns(Capacitecogns capacitecogns) {
		try{
			   
			em.persist(capacitecogns); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
		
	}

	@Override
	public Capacitecogns getCapacitecognsbyId(Long id) {
		// TODO Auto-generated method stub
		return em.find(Capacitecogns.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Capacitecogns> getAllCapacitecogns() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Capacitecogns.findAll").getResultList();
	}

	@Override
	public Capacitecogns editerCapacitecogns(Capacitecogns capacitecogns) {
		// TODO Auto-generated method stub
		try{
			return em.merge(capacitecogns);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
		}
	

	
	
}
