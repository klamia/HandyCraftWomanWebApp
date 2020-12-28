package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.dao.IProduitDao;
import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Produits;

@Service("iProduitService")
@Transactional
public class ProduitServiceImpl implements Serializable, IProduitService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -11886338875611799L;

	@Autowired
	private IProduitDao iProduitDao;
	
	
	public IProduitDao getiProduitDao() {
		return iProduitDao;
	}

	public void setiProduitDao(IProduitDao iProduitDao) {
		this.iProduitDao = iProduitDao;
	}

	@Override
	public void ajouterProduit(Produits produit) {
		// TODO Auto-generated method stub
		iProduitDao.ajouterProduit(produit);
	}

	@Override
	public Produits getProduitbyId(Long id) {
		// TODO Auto-generated method stub
		return iProduitDao.getProduitbyId(id);
	}

	@Override
	public Produits getProduitByName(String nomProduit) {
		// TODO Auto-generated method stub
		return iProduitDao.getProduitByName(nomProduit);
	}

	@Override
	public List<Produits> getAllProduits() {
		// TODO Auto-generated method stub
		return iProduitDao.getAllProduits();
	}

	@Override
	public Produits editerProduit(Produits produit) {
		// TODO Auto-generated method stub
		return iProduitDao.editerProduit(produit);
	}

	@Override
	public Produits remove(Produits produit) {
		// TODO Auto-generated method stub
		return iProduitDao.remove(produit);
	}

	@Override
	public List<Produits> getAllProduitsArtisane(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iProduitDao.getAllProduitsArtisane(artisane);
	}

	

}
