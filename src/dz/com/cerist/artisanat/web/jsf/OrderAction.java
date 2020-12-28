/**
 * OrderAction.java
 * Created: 9:36:27 PM Aug 25, 2008
 */
package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import dz.com.cerist.artisanat.commons.helpers.CartHelper;
import dz.com.cerist.artisanat.commons.utils.FacesUtils;

import dz.com.cerist.artisanat.entite.CartItem;
import dz.com.cerist.artisanat.entite.Order;
import dz.com.cerist.artisanat.service.ICarteService;
import dz.com.cerist.artisanat.service.IOrderService;



/**
 * Component for order items to buy.
 * 
 * @author Ignas
 * 
 */
@ManagedBean(name = "orderAction")
@SessionScoped
public class OrderAction implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7256669149448847106L;

	/**
     * Cart bean user for looking what user has in cart and other cart related
     * stuff.
     */
	
	
	@ManagedProperty(value="#{cartBean}")
    private CartBean cartBean;

	@ManagedProperty(value="#{artisaneBean}")
    private ArtisaneBean artisaneBean;

    /** Item service remote ejb. */
	@ManagedProperty(value="#{iOrderService}")
    private IOrderService iOrderService;

	@ManagedProperty(value="#{iCarteService}")
    private ICarteService iCarteService;
	
    
	int index;
	
	/** */
    private List<CartItem> cartItems;

    private Order orderToShow;
    private Order commandeEnCours;
    
    private List<Order> allOrdersClient;
    private List<Order> currentOrders;
    private List<Order> deliveredOrders;
    private List<Order> sentOrders;
    
 List<Order> onTheWayOrders;
  
    
    
    
    private BigDecimal orderTotalPrice= BigDecimal.ZERO ;
    
    
    
    public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}

	
    
	public ArtisaneBean getArtisaneBean() {
		return artisaneBean;
	}


	public void setArtisaneBean(ArtisaneBean artisaneBean) {
		this.artisaneBean = artisaneBean;
	}






	public IOrderService getiOrderService() {
		return iOrderService;
	}



	public void setiOrderService(IOrderService iOrderService) {
		this.iOrderService = iOrderService;
	}



	public CartBean getCartBean() {
		return cartBean;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}



	public void setOrderToShow(Order orderToShow) {
		this.orderToShow = orderToShow;
	}


	/**
     * @return cartItems.
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    
    public ICarteService getiCarteService() {
		return iCarteService;
	}


	public void setiCarteService(ICarteService iCarteService) {
		this.iCarteService = iCarteService;
	}



	






	/**
     * Is invoked on creation of this component.
     */
    @PostConstruct
    public void create() {
        cartItems = cartBean.getCartItems();
       System.out.println(cartItems);
    }

   
    
    
    public List<Order> getAllOrdersClient() {
    	allOrdersClient = iOrderService.getAllOrdersClient(cartBean.getClient());
    	return allOrdersClient;
	}



	public void setAllOrdersClient(List<Order> allOrdersClient) {
		this.allOrdersClient = allOrdersClient;
	}
    
    
    
    /**
     * Gets current orders waiting for deliver.
     * 
     * @return List of orders not delivered yet.
     */
    public List<Order> getCurrentOrders() {
    	currentOrders = iOrderService.getWaitingOrders(cartBean.getClient());
    	return currentOrders;
    }

    



	/**
     * Gets delivered orders.
     * 
     * @return List of orders already delivered.
     */
    public List<Order> getDeliveredOrders() {
    	deliveredOrders= iOrderService.getDeliveredOrders(cartBean.getClient());
    	return deliveredOrders;
    }

    
   
    
    
    
    public void setCurrentOrders(List<Order> currentOrders) {
		this.currentOrders = currentOrders;
	}






	public void setDeliveredOrders(List<Order> deliveredOrders) {
		this.deliveredOrders = deliveredOrders;
	}




	public List<Order> getSentOrders() {
		
		sentOrders = iOrderService.getSentOrders(cartBean.getClient());
		return sentOrders;
	}






	public void setSentOrders(List<Order> sentOrders) {
		this.sentOrders = sentOrders;
	}






	public List<Order> getOnTheWayOrders() {
		onTheWayOrders = iOrderService.getOnTheWayOrders(cartBean.getClient());
		return onTheWayOrders;
	}






	public void setOnTheWayOrders(List<Order> onTheWayOrders) {
		this.onTheWayOrders = onTheWayOrders;
	}






	public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}


    



	

	/**
     * @return Total price for an order.
     */
    public BigDecimal getOrderTotalPrice() {
        
    	orderTotalPrice = CartHelper.calculateTotalPrice(cartItems);
    	return orderTotalPrice;
    
    
    }

    public String showOrder(Order order) {
        this.orderToShow = order;
        return "/pages/user/preferences/orderView.xhtml?faces-redirect=true";
    }

    /**
     * @return orderToShow.
     */
    public Order getOrderToShow() {
        return orderToShow;
    }

    
    
    public void checkOrder(Order order) {
   		System.out.println(" Commande a voir");
   		index = allOrdersClient.indexOf(order);
   		commandeEnCours = order;
   	}
    
    
    
    
    /**
     * Orders items in users current cart.
     */
    public String order() {
        if (cartItems == null || cartItems.size() == 0) {
            FacesUtils.error("order.noItems");
        }
        Order order = iOrderService.placeAnOrder(cartItems, cartBean.getClient());   
        cartItems.clear();

        
        if (order != null) {
        	FacesUtils.info("order.placed");
        	return showOrder(order);
        } else {
        	FacesUtils.error("order.notPlaced");
        	return null;
        }
		
    }



	public Order getCommandeEnCours() {
		return commandeEnCours;
	}



	public void setCommandeEnCours(Order commandeEnCours) {
		this.commandeEnCours = commandeEnCours;
	}

}
