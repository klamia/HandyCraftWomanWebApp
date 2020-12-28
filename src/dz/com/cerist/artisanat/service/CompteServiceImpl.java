package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.ICompteDao;
import dz.com.cerist.artisanat.entite.Comptes;


@Service("iCompteService")
@Transactional
public class CompteServiceImpl implements ICompteService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4342933538258264185L;

	@Autowired
	private ICompteDao iCompteDao;
	
	public ICompteDao getiCompteDao() {
		return iCompteDao;
	}

	public void setiCompteDao(ICompteDao iCompteDao) {
		this.iCompteDao = iCompteDao;
	}
	
	
	
	@Override
	public void ajouterCompte(Comptes compte) {
		// TODO Auto-generated method stub
		iCompteDao.ajouterCompte(compte);    
	}

	@Override
	public Comptes getComptebyId(Long id) {
		// TODO Auto-generated method stub
		return iCompteDao.getComptebyId(id);
	}

	@Override
	public Comptes getCompteByLogin(String username) {
		// TODO Auto-generated method stub
		return iCompteDao.getCompteByLogin(username) ;
	}

	@Override
	public List<Comptes> getAllCompte() {
		// TODO Auto-generated method stub
		return iCompteDao.getAllCompte();
	}

	@Override
	public Comptes editerCompte(Comptes compte) {
		// TODO Auto-generated method stub
		return iCompteDao.editerCompte(compte);
	}

}
