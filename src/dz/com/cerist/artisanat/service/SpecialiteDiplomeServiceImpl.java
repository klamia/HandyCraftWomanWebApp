package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.dao.ISpecialiteDiplomeDao;
import dz.com.cerist.artisanat.entite.SpecialiteDiplome;

@Service("iSpecialiteDiplomeService")
@Transactional
public class SpecialiteDiplomeServiceImpl implements ISpecialiteDiplomeService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2487385379162709488L;

	
	@Autowired
	private ISpecialiteDiplomeDao iSpecialiteDiplomeDao;
	
	
	public ISpecialiteDiplomeDao getiSpecialiteDiplomeDao() {
		return iSpecialiteDiplomeDao;
	}

	public void setiSpecialiteDiplomeDao(ISpecialiteDiplomeDao iSpecialiteDiplomeDao) {
		this.iSpecialiteDiplomeDao = iSpecialiteDiplomeDao;
	}

	@Override
	public void ajouterSpecialiteDiplome(SpecialiteDiplome specialiteDiplome) {
		// TODO Auto-generated method stub
		iSpecialiteDiplomeDao.ajouterSpecialiteDiplome(specialiteDiplome);
	}

	@Override
	public SpecialiteDiplome getSpecialitebyId(Long id) {
		// TODO Auto-generated method stub
		return iSpecialiteDiplomeDao.getSpecialitebyId(id);
	}

	@Override
	public List<SpecialiteDiplome> getAllSpecialite() {
		// TODO Auto-generated method stub
		return iSpecialiteDiplomeDao.getAllSpecialite();
	}

	@Override
	public SpecialiteDiplome editerSpecialiteDiplome(
			SpecialiteDiplome specialiteDiplome) {
		// TODO Auto-generated method stub
		return iSpecialiteDiplomeDao.editerSpecialiteDiplome(specialiteDiplome);
	}

}
