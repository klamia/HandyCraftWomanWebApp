package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Advertisment;
import dz.com.cerist.artisanat.entite.Category;

@Repository("iAdvertismentDao")
@Transactional
public class AdvertisementDAOimpl implements IAdvertismentDao, Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4994698689440661155L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
    public List<Advertisment> getAdvertisments(Category selectedCategory) {
        return em.createQuery("select a from Advertisment a").getResultList();
    }

}
