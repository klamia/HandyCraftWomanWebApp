package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.IActiviteDao;

import dz.com.cerist.artisanat.entite.Activites;

@Service("iActiviteService")
@Transactional
public class ActiviteServiceImpl implements IActiviteService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2280950532621510986L;

	
	@Autowired
	private IActiviteDao iActiviteDao;
	
	
	public IActiviteDao getiActiviteDao() {
		return iActiviteDao;
	}

	public void setiActiviteDao(IActiviteDao iActiviteDao) {
		this.iActiviteDao = iActiviteDao;
	}

	
	@Override
	public void ajouterActivite(Activites activite) {
		// TODO Auto-generated method stub
		iActiviteDao.ajouterActivite(activite);
	}

	@Override
	public Activites getActivitebyId(Long id) {
		// TODO Auto-generated method stub
		return iActiviteDao.getActivitebyId(id);
	}

	@Override
	public List<Activites> getAllActivites() {
		// TODO Auto-generated method stub
		return iActiviteDao.getAllActivites();
	}

	@Override
	public Activites editerActivite(Activites activite) {
		// TODO Auto-generated method stub
		return iActiviteDao.editerActivite(activite);
	}



}
