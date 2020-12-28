package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.tuc.dsrl.m2o.ontology.utility.OntologyUtilityFactory;


import dz.com.cerist.artisanat.dao.IItemDao;
import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Attribute;
import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.entite.Item;
import dz.com.cerist.artisanat.entite.Shop;
import dz.com.cerist.artisanat.entite.ontology.Couleur;
import dz.com.cerist.artisanat.entite.ontology.Produit;
import dz.com.cerist.artisanat.entite.ontology.Shops;
import dz.com.cerist.artisanat.entite.ontology.Tendance;
import dz.com.cerist.artisanat.entite.repository.ProduitRepository;

@Service("iItemService")
@Transactional
public class ItemServiceImpl implements IItemService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8433000360204153185L;

	
	@Autowired
	private IItemDao iItemDao;
	
	public IItemDao getiItemDao() {
		return iItemDao;
	}

	public void setiItemDao(IItemDao iItemDao) {
		this.iItemDao = iItemDao;
	}

	@Override
	public Item getItemById(Long id) {
		// TODO Auto-generated method stub
		return iItemDao.getItemById(id) ;
	}

	@Override
	public Item saveItem(Item item) {
		// TODO Auto-generated method stub
		return iItemDao.saveItem(item);
	}

	@Override
	public List<Attribute> getAttributes(Category selectedCategory) {
		// TODO Auto-generated method stub
		return iItemDao.getAttributes(selectedCategory);
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return iItemDao.getItems();
	}

	@Override
	public List<Item> getFirstPageItems(Category selectedCategory,
			Long attributeId) {
		// TODO Auto-generated method stub
		return iItemDao.getFirstPageItems(selectedCategory, attributeId);
	}

	@Override
	public List<Item> getTopItems(Category selectedCategory, Long attributeId) {
		// TODO Auto-generated method stub
		return iItemDao.getTopItems(selectedCategory, attributeId);
	}

	@Override
	public List<Item> getAllItemsArtisane(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iItemDao.getAllItemsArtisane(artisane);
	}

	@Override
	public Item getItemByName(String name) {
		// TODO Auto-generated method stub
		return iItemDao.getItemByName(name);
	}

	@Override
	public Item editerItem(Item item) {
		// TODO Auto-generated method stub
		return iItemDao.editerItem(item);
	}

	
	@Override
	public void activerItem(Item item) {
		iItemDao.activerItem(item);
		
	}

	@Override
	public void desactiverItem(Item item) {
		iItemDao.desactiverItem(item);
		
	}

	

	@Override
	public Item remove(Item item) {
		return iItemDao.remove(item);
		
	}

	@Override
	public List<Item> getAllItemsShop(Shop shop) {
		// TODO Auto-generated method stub
		return iItemDao.getAllItemsShop(shop);
	}

	@Override
	public List<Item> getAllItemsPublies(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iItemDao.getAllItemsPublies(artisane);
	}

	@Override
	public List<Item> getAllItemsNonPublies(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iItemDao.getAllItemsNonPublies(artisane);
	}

	@Override
	public void ajouterItemOntologie(long id_prod, long id_shop, long id_tendance, long id_couleur) {
		// TODO Auto-generated method stub
		
		Shops shop = new Shops(id_shop, null, null);
		Tendance tendance = new Tendance(id_tendance);
    	Couleur couleur = new Couleur(id_couleur);
		ProduitRepository pRepo = new ProduitRepository();
		Produit prod = new Produit(id_prod,shop, tendance, couleur);
		pRepo.create(prod);
		//pRepo.delete(id_prod);
		OntologyUtilityFactory.getInstance().saveOntology();
	
	}

	@Override
	public void supprimerItemOntologie(long id_prod) {
		// TODO Auto-generated method stub
		
		ProduitRepository pRepo = new ProduitRepository();
		pRepo.delete(id_prod);
		OntologyUtilityFactory.getInstance().saveOntology();
	
	}

	

}
