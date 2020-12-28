package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.CartItem;
import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Order;

public interface IOrderService {

	 
	public List<Order> getAllOrdersClient(Clients client);
	
	
	/**
     * Gets orders which is already delivered. Useful for orders history.
     * 
     * @param user
     *            User whose orders history to return
     * @return List of delivered orders.
     */
    public List<Order> getDeliveredOrders(Clients client);

    /**
     * Gets orders which are going to be delivered to user. Useful for tracking
     * orders by looking at current order status.
     * 
     * @param user
     *            User whose orders history to return
     * @return List of orders not delivered yet.
     */
    public List<Order> getWaitingOrders(Clients client);

    public List<Order> getSentOrders(Clients client);
    
    
    public List<Order> getOnTheWayOrders(Clients client);
    
   
   /*************************************** Artisane methods ************************************/ 
    
    
    public List<Order> getAllDeliveredOrders(Artisanes artisane);
    public List<Order> getAllWaitingOrders(Artisanes artisane);
    public List<Order> getAllSentOrders(Artisanes artisane);
    public List<Order> getAllOnTheWayOrders(Artisanes artisane);
   
    
    
    
    
    
    /**
     * Place an order for cart items.
     * 
     * @param cartItems
     *            Cart items that will form an order.
     */
    public Order placeAnOrder(List<CartItem> cartItems, Clients client);	
    public Order editerOrder(Order order);
    public void addItemOrder(List<CartItem> cartItems, Order order);
}
