package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.dao.IWilayaDao;
import dz.com.cerist.artisanat.entite.Wilayas;

@Service("iWilayaService")
@Transactional
public class WilayaServiceImpl implements IWilayaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6776271049085569358L;

	
	@Autowired
	private IWilayaDao iWilayaDao;
	

	public IWilayaDao getiWilayaDao() {
		return iWilayaDao;
	}

	public void setiWilayaDao(IWilayaDao iWilayaDao) {
		this.iWilayaDao = iWilayaDao;
	}

	@Override
	public void ajouterWilaya(Wilayas wilaya) {
		// TODO Auto-generated method stub
 
		iWilayaDao.ajouterWilaya(wilaya);
	}

	@Override
	public Wilayas getWilayabyId(Long id) {
		// TODO Auto-generated method stub
		return iWilayaDao.getWilayabyId(id);
	}

	@Override
	public List<Wilayas> getAllWilaya() {
		// TODO Auto-generated method stub
		return iWilayaDao.getAllWilaya();
	}

	@Override
	public Wilayas editerWilaya(Wilayas wilaya) {
		// TODO Auto-generated method stub
		return iWilayaDao.editerWilaya(wilaya);
	}

}
