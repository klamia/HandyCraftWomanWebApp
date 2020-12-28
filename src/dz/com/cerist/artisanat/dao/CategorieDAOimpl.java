package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iCategorieDao")
@Transactional
public class CategorieDAOimpl implements ICategorieDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2531926532889006085L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Category getCategoriebyId(Long id) {
		// TODO Auto-generated method stub
		try{
			return em.find(Category.class, id);
		}
		catch (Throwable th){
			 throw new MyProfilException(th,12);
			 }
	}

	

	@Override
	public void ajouterCategorie(Category categorie) {
		// TODO Auto-generated method stub
		
		try{
			  
			em.persist(categorie); 
		
		}
		catch (Throwable th){
			 throw new MyProfilException(th,11);
			 }
	
	}

	@Override
	public Category editerCategorie(Category categorie) {
		// TODO Auto-generated method stub
		try{
			return em.merge(categorie);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		Query query = em
                .createQuery("select c from Category c left join fetch c.parentCategory");
        return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getShopsCategories() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Category.findCategoryShops").getResultList();
	}
	


}
