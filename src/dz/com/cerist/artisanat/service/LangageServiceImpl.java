package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.ILangageDao;
import dz.com.cerist.artisanat.entite.Langages;

@Service("iLangageService")
@Transactional
public class LangageServiceImpl implements ILangageService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8030153184928755284L;

	@Autowired
	private ILangageDao iLangageDao;
	
	
	public ILangageDao getiLangageDao() {
		return iLangageDao;
	}

	public void setiLangageDao(ILangageDao iLangageDao) {
		this.iLangageDao = iLangageDao;
	}

	@Override
	public void ajouterLangage(Langages langage) {
		// TODO Auto-generated method stub
		iLangageDao.ajouterLangage(langage);
	}

	@Override
	public Langages getLangagebyId(Long id) {
		// TODO Auto-generated method stub
		return iLangageDao.getLangagebyId(id);
	}

	@Override
	public List<Langages> getAllLangages() {
		// TODO Auto-generated method stub
		return iLangageDao.getAllLangages();
	}

	@Override
	public Langages editerLangage(Langages langage) {
		// TODO Auto-generated method stub
		return iLangageDao.editerLangage(langage);
	}

}
