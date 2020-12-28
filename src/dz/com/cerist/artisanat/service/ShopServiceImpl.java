package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.tuc.dsrl.m2o.ontology.utility.OntologyUtilityFactory;




import dz.com.cerist.artisanat.dao.IShopDao;
import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.entite.Shop;
import dz.com.cerist.artisanat.entite.ontology.Artisane;
import dz.com.cerist.artisanat.entite.ontology.Shops;
import dz.com.cerist.artisanat.entite.ontology.Wilaya;
import dz.com.cerist.artisanat.entite.repository.ShopsRepository;

@Service("iShopService")
@Transactional
public class ShopServiceImpl implements IShopService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2397483462881490523L;

	
	@Autowired
	private IShopDao iShopDao;
	
	
	public IShopDao getiShopDao() {
		return iShopDao;
	}

	public void setiShopDao(IShopDao iShopDao) {
		this.iShopDao = iShopDao;
	}

	@Override
	public void ajouterShop(Shop shop) {
		// TODO Auto-generated method stub
		iShopDao.ajouterShop(shop);
	}

	@Override
	public Shop getShopbyId(Long id) {
		// TODO Auto-generated method stub
		return iShopDao.getShopbyId(id);
	}

	@Override
	public List<Shop> getAllShopsCategory(Category category) {
		// TODO Auto-generated method stub
		return iShopDao.getAllShopsCategory(category);
	}

	@Override
	public List<Shop> getAllShops() {
		// TODO Auto-generated method stub
		return iShopDao.getAllShops();
	}

	@Override
	public Shop editerShop(Shop shop) {
		// TODO Auto-generated method stub
		return iShopDao.editerShop(shop);
	}

	@Override
	public List<Shop> getFirstPageShops() {
		// TODO Auto-generated method stub
		return iShopDao.getAllShops();
	}

	@Override
	public List<Shop> getAllShopsArtisane(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iShopDao.getAllShopsArtisane(artisane);
	}

	@Override
	public Shop remove(Shop shop) {
		// TODO Auto-generated method stub
		return iShopDao.remove(shop);
	}

	@Override
	public void ajouterShopOntologie(long id_shop, long id_artisane, long id_wilaya) {
		Artisane artisan = new Artisane(id_artisane, null, null);
    	Wilaya w_shop = new Wilaya(id_wilaya);
    	ShopsRepository sRepo = new ShopsRepository();
		Shops shop = new Shops(id_shop, artisan, w_shop);
		sRepo.create(shop);
		OntologyUtilityFactory.getInstance().saveOntology();
	}

	

}
