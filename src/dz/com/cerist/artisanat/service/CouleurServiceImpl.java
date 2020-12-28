package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.ICouleurDao;

import dz.com.cerist.artisanat.entite.Couleurs;

@Service("iCouleurService")
@Transactional
public class CouleurServiceImpl implements Serializable, ICouleurService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8245290949988916911L;

	
	@Autowired
	private ICouleurDao iCouleurDao;
	
	
	public ICouleurDao getiCouleurDao() {
		return iCouleurDao;
	}

	public void setiCouleurDao(ICouleurDao iCouleurDao) {
		this.iCouleurDao = iCouleurDao;
	}

	@Override
	public void ajouterCouleur(Couleurs couleur) {
		// TODO Auto-generated method stub
		iCouleurDao.ajouterCouleur(couleur);
	}

	@Override
	public Couleurs getCouleurbyId(Long id) {
		// TODO Auto-generated method stub
		return iCouleurDao.getCouleurbyId(id);
	}

	@Override
	public List<Couleurs> getAllCouleurs() {
		// TODO Auto-generated method stub
		return iCouleurDao.getAllCouleurs();
	}

	@Override
	public Couleurs editerCouleur(Couleurs couleur) {
		// TODO Auto-generated method stub
		return iCouleurDao.editerCouleur(couleur);
	}

}
