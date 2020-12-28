package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.IOrderDao;
import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.CartItem;
import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Order;

@Service("iOrderService")
@Transactional
public class OrderServiceImpl implements IOrderService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5920079146192762186L;

	@Autowired
	private IOrderDao iOrderDao;
	
	public IOrderDao getiOrderDao() {
		return iOrderDao;
	}

	public void setiOrderDao(IOrderDao iOrderDao) {
		this.iOrderDao = iOrderDao;
	}

	@Override
	public List<Order> getDeliveredOrders(Clients client) {
		// TODO Auto-generated method stub
		return iOrderDao.getDeliveredOrders(client);
	}

	@Override
	public List<Order> getWaitingOrders(Clients client) {
		// TODO Auto-generated method stub
		return iOrderDao.getWaitingOrders(client);
	}

	@Override
	public Order placeAnOrder(List<CartItem> cartItems, Clients client) {
		// TODO Auto-generated method stub
		return iOrderDao.placeAnOrder(cartItems, client);
	}

	@Override
	public void addItemOrder(List<CartItem> cartItems, Order order) {
		// TODO Auto-generated method stub
		iOrderDao.addItemOrder(cartItems, order);
	}
	
	
	@Override
	public List<Order> getAllOrdersClient(Clients client) {
		// TODO Auto-generated method stub
		return iOrderDao.getAllOrdersClient(client);
	}
	
	
	@Override
	public List<Order> getSentOrders(Clients client) {
		// TODO Auto-generated method stub
		return iOrderDao.getSentOrders(client);
	}

	@Override
	public List<Order> getOnTheWayOrders(Clients client) {
		// TODO Auto-generated method stub
		return iOrderDao.getOnTheWayOrders(client);
	}

	@Override
	public List<Order> getAllDeliveredOrders(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iOrderDao.getAllDeliveredOrders(artisane);
	}

	@Override
	public List<Order> getAllWaitingOrders(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iOrderDao.getAllWaitingOrders(artisane);
	}

	@Override
	public List<Order> getAllSentOrders(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iOrderDao.getAllSentOrders(artisane);
	}

	@Override
	public List<Order> getAllOnTheWayOrders(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iOrderDao.getAllOnTheWayOrders(artisane);
	}

	@Override
	public Order editerOrder(Order order) {
		// TODO Auto-generated method stub
		return iOrderDao.editerOrder(order);
	}

	

	

	

}
