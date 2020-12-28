package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.ICentresinteretsDao;

import dz.com.cerist.artisanat.entite.Centresinterets;

@Service("iCentresinteretsService")
@Transactional
public class CentresinteretsServiceImpl implements ICentresinteretsService,
		Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7772904455560810199L;

	@Autowired
	private ICentresinteretsDao iCentresinteretsDao;
	
	public ICentresinteretsDao getiCentresinteretsDao() {
		return iCentresinteretsDao;
	}

	public void setiCentresinteretsDao(ICentresinteretsDao iCentresinteretsDao) {
		this.iCentresinteretsDao = iCentresinteretsDao;
	}

	
	@Override
	public void ajouterInteret(Centresinterets interet) {
		// TODO Auto-generated method stub
		iCentresinteretsDao.ajouterInteret(interet);
	}

	@Override
	public Centresinterets getInteretbyId(Long id) {
		// TODO Auto-generated method stub
		return iCentresinteretsDao.getInteretbyId(id);
	}

	@Override
	public List<Centresinterets> getAllInterets() {
		// TODO Auto-generated method stub
		return iCentresinteretsDao.getAllInterets();
	}

	@Override
	public Centresinterets editerInteret(Centresinterets interet) {
		// TODO Auto-generated method stub
		return iCentresinteretsDao.editerInteret(interet);
	}

}
