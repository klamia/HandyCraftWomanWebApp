package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.ICapacitephysDao;

import dz.com.cerist.artisanat.entite.Capacitephys;

@Service("iCapacitephysService")
@Transactional
public class CapacitephysServiceImpl implements ICapacitephysService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -807471993860644224L;

	@Autowired
	private ICapacitephysDao iCapacitephysDao;
	
	
	public ICapacitephysDao getiCapacitephysDao() {
		return iCapacitephysDao;
	}

	public void setiCapacitephysDao(ICapacitephysDao iCapacitephysDao) {
		this.iCapacitephysDao = iCapacitephysDao;
	}

	@Override
	public void ajouterCapacitephys(Capacitephys capacitephys) {
		// TODO Auto-generated method stub
		iCapacitephysDao.ajouterCapacitephys(capacitephys);
	}

	@Override
	public Capacitephys getCapacitephysbyId(Long id) {
		// TODO Auto-generated method stub
		return iCapacitephysDao.getCapacitephysbyId(id);
	}

	@Override
	public List<Capacitephys> getAllCapacitephys() {
		// TODO Auto-generated method stub
		return iCapacitephysDao.getAllCapacitephys();
	}

	@Override
	public Capacitephys editerCapacitephys(Capacitephys capacitephys) {
		// TODO Auto-generated method stub
		return iCapacitephysDao.editerCapacitephys(capacitephys);
	}

}
