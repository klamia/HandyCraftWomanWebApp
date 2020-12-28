package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.commons.exceptions.NoItemsForOrderException;
import dz.com.cerist.artisanat.commons.helpers.CartHelper;
import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.CartItem;
import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Order;
import dz.com.cerist.artisanat.entite.OrderItem;
import dz.com.cerist.artisanat.entite.OrderStatusEnum;

@Repository("iOrderDao")
@Transactional
public class OrderDAOimpl implements IOrderDao, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7797120228396878150L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	private List<OrderItem > orderedItems= new ArrayList<OrderItem>();
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	public List<OrderItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<OrderItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getDeliveredOrders(Clients client) {
		Query query = em.createQuery("select o from Order o "
                + "where o.client.id = :clientId and o.status = :statusDelivered");
        query.setParameter("statusDelivered", OrderStatusEnum.DELIVERED);
        query.setParameter("clientId", client.getId());
        return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getWaitingOrders(Clients client) {
		Query query = em.createQuery("select o from Order o "
                + "where o.client.id = :clientId and o.status = :statusProcessing");
        query.setParameter("statusProcessing", OrderStatusEnum.PROCESSING);
        query.setParameter("clientId", client.getId());
        return query.getResultList();
	}

	@Override
	public Order placeAnOrder(List<CartItem> cartItems, Clients client) {
		if (cartItems == null || cartItems.size() == 0) {
            throw new NoItemsForOrderException();
        }
        Order order = new Order();
        order.setClient(cartItems.get(0).getCart().getClient());
        order.setArtisane(cartItems.get(0).getItem().getArtisane());
       // order.setOrderedItems(cartItems);
        order.setOrderPrice(CartHelper.calculateTotalPrice(cartItems));
        order.setShippingAddress(client.getAdresse());
        order.setStatus(OrderStatusEnum.SENT);
        order.setOrderedOn(new Date());
        em.persist(order);
        addItemOrder(cartItems, order);
        return order;
	}

	
	@Override
	public void addItemOrder(List<CartItem> cartItems, Order order) {
		// TODO Auto-generated method stub
		
		if (cartItems == null || cartItems.size() == 0) {
            throw new NoItemsForOrderException();
        }
		

        for(CartItem cartItem: cartItems){
        	OrderItem oi = new OrderItem();     	
        	oi.setAddedOn(cartItem.getAddedOn());         
        	oi.setQuantity(cartItem.getQuantity());
        	oi.setCart(cartItem.getCart());
        	oi.setItem(cartItem.getItem());
        	oi.setOrder(order);
        	em.persist(oi);
        	orderedItems.add(oi);
        	
        }   
  
        order.setOrderedItems(orderedItems);
	    em.merge(order);
	
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrdersClient(Clients client) {
		Query query = em.createQuery("select o from Order o "
                + "where o.client.id = :clientId ");
        query.setParameter("clientId", client.getId());
        return query.getResultList();
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getSentOrders(Clients client) {
		Query query = em.createQuery("select o from Order o "
                + "where o.client.id = :clientId and o.status = :statusSent");
        query.setParameter("statusSent", OrderStatusEnum.SENT);
        query.setParameter("clientId", client.getId());
        return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOnTheWayOrders(Clients client) {
		Query query = em.createQuery("select o from Order o "
                + "where o.client.id = :clientId and o.status = :statusOnTheWay");
        query.setParameter("statusOnTheWay", OrderStatusEnum.ON_THE_WAY);
        query.setParameter("clientId", client.getId());
        return query.getResultList();
	}

	
/****************************************Artisane methods ****************************************/
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllDeliveredOrders(Artisanes artisane) {
		Query query = em.createNamedQuery("Orders.findAllDeliveredOrders");
		query.setParameter("artisane_ID", artisane.getId());
		query.setParameter("statusDelivered", OrderStatusEnum.DELIVERED);	
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllWaitingOrders(Artisanes artisane) {
		Query query = em.createNamedQuery("Orders.findAllProcessingOrders");
		query.setParameter("artisane_ID", artisane.getId());
		query.setParameter("statusProcessing", OrderStatusEnum.PROCESSING);	
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllSentOrders(Artisanes artisane) {
		Query query = em.createNamedQuery("Orders.findAllSentOrders");
		query.setParameter("artisane_ID", artisane.getId());
		query.setParameter("statusSent", OrderStatusEnum.SENT);	
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOnTheWayOrders(Artisanes artisane) {
		Query query = em.createNamedQuery("Orders.findAllWaitingOrders");
		query.setParameter("artisane_ID", artisane.getId());
		query.setParameter("statusOnTheWay", OrderStatusEnum.ON_THE_WAY);	
		return query.getResultList();
	}

	@Override
	public Order editerOrder(Order order) {
		// TODO Auto-generated method stub
		return em.merge(order);
	}

	
	

	
	





}
