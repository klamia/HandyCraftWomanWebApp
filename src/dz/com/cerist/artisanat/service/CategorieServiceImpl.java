package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.ICategorieDao;

import dz.com.cerist.artisanat.entite.Category;

@Service("iCategorieService")
@Transactional
public class CategorieServiceImpl implements ICategorieService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3823220762212703208L;

	@Autowired
	private ICategorieDao iCategorieDao;
	
	public ICategorieDao getiCategorieDao() {
		return iCategorieDao;
	}

	public void setiCategorieDao(ICategorieDao iCategorieDao) {
		this.iCategorieDao = iCategorieDao;
	}

	@Override
	public Category getCategoriebyId(Long id) {
		// TODO Auto-generated method stub
		return iCategorieDao.getCategoriebyId(id);
	}

	

	@Override
	public void ajouterCategorie(Category categorie) {
		// TODO Auto-generated method stub
		iCategorieDao.ajouterCategorie(categorie);
	}

	@Override
	public Category editerCategorie(Category categorie) {
		// TODO Auto-generated method stub
		return iCategorieDao.editerCategorie(categorie);
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return iCategorieDao.getCategories();
	}

	@Override
	public List<Category> getShopsCategories() {
		// TODO Auto-generated method stub
		return iCategorieDao.getShopsCategories();
	}

}
