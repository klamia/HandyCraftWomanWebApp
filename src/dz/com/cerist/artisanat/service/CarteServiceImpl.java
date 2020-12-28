package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dz.com.cerist.artisanat.dao.ICartDao;
import dz.com.cerist.artisanat.entite.Cart;
import dz.com.cerist.artisanat.entite.CartItem;
import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Item;

@Service("iCarteService")
@Transactional
public class CarteServiceImpl implements ICarteService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2688790033592763344L;

	@Autowired
	private ICartDao iCartDao;
	
	
	
	@Override
	public Cart createCartByUser(Clients client) {
		// TODO Auto-generated method stub
		return iCartDao.createCartByUser(client);
	}

	@Override
	public void removeCart(Cart cart) {
		iCartDao.removeCart(cart);

	}

	@Override
	public void setCartCurrent(Cart cart) throws Exception {
		iCartDao.setCartCurrent(cart);

	}

	@Override
	public Cart getCurrentCartByUser(Clients client) {
		// TODO Auto-generated method stub
		return iCartDao.getCurrentCartByUser(client);
	}

	@Override
	public List<Cart> getAllCartsByUser(Clients client) throws Exception {
		// TODO Auto-generated method stub
		return iCartDao.getAllCartsByUser(client);
	}

	@Override
	public void addCartItem(Cart cart, Item item) {
		iCartDao.addCartItem(cart, item);

	}

	@Override
	public CartItem removeCartItem(CartItem cartItem, Cart cart) {
		return iCartDao.removeCartItem(cartItem, cart);

	}

	@Override
	public List<CartItem> getCartItems(Cart cart) {
		// TODO Auto-generated method stub
	
		return iCartDao.getCartItems(cart);
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		iCartDao.removeAllCartItems(cart);

	}

	public ICartDao getiCartDao() {
		return iCartDao;
	}

	public void setiCartDao(ICartDao iCartDao) {
		this.iCartDao = iCartDao;
	}

	@Override
	public void creerCart(Cart cart) {
		
		iCartDao.creerCart(cart);
	}

	@Override
	public Cart editerCart(Cart cart) {
		// TODO Auto-generated method stub
		cart=iCartDao.editerCart(cart);
		return cart;
	}




}
