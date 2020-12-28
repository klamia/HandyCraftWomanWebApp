package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.IComputerliteracysDao;
import dz.com.cerist.artisanat.entite.Computerliteracys;


@Service("iComputerliteracysService")
@Transactional
public class ComputerliteracysServiceImpl implements IComputerliteracysService,
		Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1179930965488469350L;

	@Autowired
	private IComputerliteracysDao iComputerliteracysDao;
	
	
	public IComputerliteracysDao getiComputerliteracysDao() {
		return iComputerliteracysDao;
	}

	public void setiComputerliteracysDao(IComputerliteracysDao iComputerliteracysDao) {
		this.iComputerliteracysDao = iComputerliteracysDao;
	}

	@Override
	public void ajouterComputerliteracys(Computerliteracys computerliteracys) {
		// TODO Auto-generated method stub
        
		iComputerliteracysDao.ajouterComputerliteracys(computerliteracys);
	
	}

	@Override
	public Computerliteracys getComputerliteracysbyId(Long id) {
		// TODO Auto-generated method stub
		return iComputerliteracysDao.getComputerliteracysbyId(id);
	}

	@Override
	public List<Computerliteracys> getAllComputerliteracys() {
		// TODO Auto-generated method stub
		return iComputerliteracysDao.getAllComputerliteracys();
	}

	@Override
	public Computerliteracys editerComputerliteracys(
			Computerliteracys computerliteracys) {
		// TODO Auto-generated method stub
		return iComputerliteracysDao.editerComputerliteracys(computerliteracys);
	}

}
