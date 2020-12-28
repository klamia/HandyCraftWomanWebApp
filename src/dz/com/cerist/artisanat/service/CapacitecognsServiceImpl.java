package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.ICapacitecognsDao;

import dz.com.cerist.artisanat.entite.Capacitecogns;

@Service("iCapacitecognsService")
@Transactional
public class CapacitecognsServiceImpl implements ICapacitecognsService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2243852009596223951L;

	@Autowired
	private ICapacitecognsDao iCapacitecognsDao;
	
	
	
	public ICapacitecognsDao getiCapacitecognsDao() {
		return iCapacitecognsDao;
	}

	public void setiCapacitecognsDao(ICapacitecognsDao iCapacitecognsDao) {
		this.iCapacitecognsDao = iCapacitecognsDao;
	}

	@Override
	public void ajouterCapacitecogns(Capacitecogns capacitecogns) {
		// TODO Auto-generated method stub
		iCapacitecognsDao.ajouterCapacitecogns(capacitecogns);
	}

	@Override
	public Capacitecogns getCapacitecognsbyId(Long id) {
		// TODO Auto-generated method stub
		return iCapacitecognsDao.getCapacitecognsbyId(id);
	}

	@Override
	public List<Capacitecogns> getAllCapacitecogns() {
		// TODO Auto-generated method stub
		return iCapacitecognsDao.getAllCapacitecogns();
	}

	@Override
	public Capacitecogns editerCapacitecogns(Capacitecogns capacitecogns) {
		// TODO Auto-generated method stub
		return iCapacitecognsDao.editerCapacitecogns(capacitecogns);
	}

}
