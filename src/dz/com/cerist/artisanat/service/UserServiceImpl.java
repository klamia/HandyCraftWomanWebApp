package dz.com.cerist.artisanat.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.IUserDao;

import dz.com.cerist.artisanat.entite.Users;
import dz.com.cerist.artisanat.entite.UserConfirmation;

@Transactional
@Service("iUserService")
public class UserServiceImpl implements IUserService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1047044662511949506L;

	@Autowired
	private IUserDao iUserDao ;
	
	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	@Override
	public Users saveUser(Users users) {
		// TODO Auto-generated method stub
		return iUserDao.saveUser(users);
	}

	@Override
	public Users updateUser(Users users) {
		// TODO Auto-generated method stub
		return iUserDao.updateUser(users);
	}

	@Override
	public Users findUserByUniqueId(String uniqueId) {
		// TODO Auto-generated method stub
		return iUserDao.findUserByUniqueId(uniqueId);
	}

	@Override
	public Users findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return iUserDao.findUserByEmail(email);
	}

	@Override
	public void saveUserConfirmation(UserConfirmation confirmation) {
		// TODO Auto-generated method stub
		iUserDao.saveUserConfirmation(confirmation);
	}

	@Override
	public UserConfirmation findConfirmationByUser(Users users) {
		// TODO Auto-generated method stub
		return iUserDao.findConfirmationByUser(users);
	}
/*
	@Override
	public void saveUserAddress(User user, Address address) {
		// TODO Auto-generated method stub
		iUserDao.saveUserAddress(user, address);
	}
*/
}
