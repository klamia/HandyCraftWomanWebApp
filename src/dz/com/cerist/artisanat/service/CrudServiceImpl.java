package dz.com.cerist.artisanat.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.CrudDao;


@Service("crudService")
@Transactional
public class CrudServiceImpl implements CrudService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897373331742674072L;

	@Autowired
	private CrudDao crudDao;
	

	public CrudDao getCrudDao() {
		return crudDao;
	}


	public void setCrudDao(CrudDao crudDao) {
		this.crudDao = crudDao;
	}




	@Override
	public void ajouterClient(long id_client, long id_wilaya) {
		// TODO Auto-generated method stub
        
		crudDao.ajouterClient(id_client, id_wilaya);
	
	}

}
