package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.IAdvertismentDao;
import dz.com.cerist.artisanat.entite.Advertisment;
import dz.com.cerist.artisanat.entite.Category;

@Service("iAdvertisementService")
@Transactional
public class AdvertisementServiceImpl implements IAdvertisementService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -434970121087902326L;

	@Autowired
	private IAdvertismentDao iAdvertisementDao;
	
	public IAdvertismentDao getiAdvertisementDao() {
		return iAdvertisementDao;
	}

	public void setiAdvertisementDao(IAdvertismentDao iAdvertisementDao) {
		this.iAdvertisementDao = iAdvertisementDao;
	}


	@Override
	public List<Advertisment> getAdvertisments(Category selectedCategory) {
		// TODO Auto-generated method stub
		return iAdvertisementDao.getAdvertisments(selectedCategory);
	}

}
