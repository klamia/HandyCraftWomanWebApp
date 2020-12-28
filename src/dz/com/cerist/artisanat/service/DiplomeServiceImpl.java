package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.dao.IDiplomeDao;
import dz.com.cerist.artisanat.entite.Diplomes;

@Service("iDiplomeService")
@Transactional
public class DiplomeServiceImpl implements IDiplomeService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5431965765823560455L;

	@Autowired
	private IDiplomeDao iDiplomeDao;
	

	public IDiplomeDao getiDiplomeDao() {
		return iDiplomeDao;
	}

	public void setiDiplomeDao(IDiplomeDao iDiplomeDao) {
		this.iDiplomeDao = iDiplomeDao;
	}

	@Override
	public void ajouterDiplome(Diplomes diplome) {
		// TODO Auto-generated method stub
		iDiplomeDao.ajouterDiplome(diplome);
	}

	@Override
	public Diplomes getDiplomebyId(Long id) {
		// TODO Auto-generated method stub
		return iDiplomeDao.getDiplomebyId(id);
	}

	@Override
	public List<Diplomes> getAllDiplomes() {
		// TODO Auto-generated method stub
		return iDiplomeDao.getAllDiplomes();
	}

	@Override
	public Diplomes editerDiplome(Diplomes diplome) {
		// TODO Auto-generated method stub
		return iDiplomeDao.editerDiplome(diplome);
	}


}
