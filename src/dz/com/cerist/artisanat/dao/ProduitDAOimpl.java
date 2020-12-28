package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Produits;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iProduitDao")
@Transactional
public class ProduitDAOimpl implements Serializable, IProduitDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2961661698890285564L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void ajouterProduit(Produits produit) {
		try{
			  
				em.persist(produit); 
			
			}
			catch (Throwable th){
				 throw new MyProfilException(th,11);
				 }

	}

	@Override
	public Produits getProduitbyId(Long id) {
		try{
			return em.find(Produits.class, id);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,12);
				 }
	}

	@Override
	public Produits getProduitByName(String nomProduit) {
		try{
			
			 Query query = em.createNamedQuery("Produits.findByNomProduit");
				query.setParameter("nomProduit", nomProduit);
				return (Produits) query.getSingleResult();
			
			 
			 
		 
		 }
		 catch (Throwable th){
			 throw new MyProfilException(th,15);
			 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produits> getAllProduits() {
		try {
			
			
			 return em.createNamedQuery("Produits.findAll").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Produits editerProduit(Produits produit) {
		try{
			return em.merge(produit);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Produits> getAllProduitsArtisane(Artisanes artisane) {
		try {
		      return em.createNamedQuery("Produits.findProduitsArtisane").setParameter("artisane_ID", artisane.getId()).getResultList();
		    } catch (Throwable th) {
		      throw new MyProfilException(th,15);
		    }
	}

	
	@Override
	public Produits remove(Produits produit) {
		try{
			em.remove(em.merge(produit));
			return produit;
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}
		
	

	

}
