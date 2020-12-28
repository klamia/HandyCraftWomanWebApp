package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Category;

import dz.com.cerist.artisanat.entite.Shop;

import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iShopDao")
@Transactional
public class ShopDAOimpl implements IShopDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 640272482676344220L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void ajouterShop(Shop shop) {
		try{
			   
				em.persist(shop); 
			
			}
			catch (Throwable th){
				 throw new MyProfilException(th,11);
				 }

	}

	@Override
	public Shop getShopbyId(Long id) {
		/*
		try{
			return em.find(Shop.class, id);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,12);
				 }
	      */
		try{
			
			 Query query = em.createNamedQuery("Shop.getShopByID");
				query.setParameter("id", id);
				return (Shop) query.getSingleResult();
			
			 
			 
		 
		 }
		 catch (Throwable th){
			 throw new MyProfilException(th,15);
			 }
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAllShopsCategory(Category category) {
		try {
		      return em.createNamedQuery("Shop.getAllShopsCategory").getResultList();
		    } catch (Throwable th) {
		      throw new MyProfilException(th,15);
		    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAllShops() {
		try {
			
			
			 return em.createNamedQuery("Shop.getAllShops").getResultList();
		}
		catch (Throwable th){
			 throw new MyProfilException(th,13);
			 }
	}

	@Override
	public Shop editerShop(Shop shop) {
		try{
			return em.merge(shop);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getFirstPageShops() {
		
		Query query = null;
		 query = em.createNamedQuery("Shop.getAllShops");
		/*
		if (selectedCategory == null) {
            query = em.createNamedQuery("Shop.getAllShops");
        } else  {
            query = em.createNamedQuery("Shop.getAllShopsCategory");
            query.setParameter("categoryId", selectedCategory.getId());
        } 
             */
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAllShopsArtisane(Artisanes artisane) {
		// TODO Auto-generated method stub
		
		try {
		      return em.createNamedQuery("Shop.findShopsArtisane").setParameter("artisane_ID", artisane.getId()).getResultList();
		    } catch (Throwable th) {
		      throw new MyProfilException(th,15);
		    }
	}

	@Override
	public Shop remove(Shop shop) {
		try{
			em.remove(em.merge(shop));
			return shop;
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

}
