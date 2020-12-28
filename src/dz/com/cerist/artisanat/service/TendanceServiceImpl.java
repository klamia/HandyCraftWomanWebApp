package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.dao.ITendanceDao;
import dz.com.cerist.artisanat.entite.Tendances;

@Service("iTendanceService")
@Transactional
public class TendanceServiceImpl implements Serializable, ITendanceService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1220388658763149245L;

	
	@Autowired
	private ITendanceDao iTendanceDao;
	
	public ITendanceDao getiTendanceDao() {
		return iTendanceDao;
	}

	public void setiTendanceDao(ITendanceDao iTendanceDao) {
		this.iTendanceDao = iTendanceDao;
	}

	@Override
	public void ajouterTendance(Tendances tendance) {
		// TODO Auto-generated method stub
		iTendanceDao.ajouterTendance(tendance);
	}

	@Override
	public Tendances getTendancebyId(Long id) {
		// TODO Auto-generated method stub
		return iTendanceDao.getTendancebyId(id);
	}

	@Override
	public List<Tendances> getAllTendances() {
		// TODO Auto-generated method stub
		return iTendanceDao.getAllTendances();
	}

	@Override
	public Tendances editerTendance(Tendances tendance) {
		// TODO Auto-generated method stub
		return iTendanceDao.editerTendance(tendance);
	}

}
