/**
 * CartBean.java
 * Created: 10:45:12 PM Feb 10, 2008
 */
package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import dz.com.cerist.artisanat.commons.helpers.CartHelper;
import dz.com.cerist.artisanat.entite.Cart;
import dz.com.cerist.artisanat.entite.CartItem;
import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Comptes;
import dz.com.cerist.artisanat.entite.Item;

import dz.com.cerist.artisanat.service.ICarteService;
import dz.com.cerist.artisanat.service.IClientService;
import dz.com.cerist.artisanat.service.ICompteService;
import dz.com.cerist.artisanat.service.IShopService;




/**
 * Cart related services component.
 * 
 * @author Ignas
 * 
 */
@ManagedBean(name = "cartBean")
@SessionScoped
public class CartBean implements Serializable{

	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2471161875797352924L;

	/** Cart service remote ejb. */
	@ManagedProperty(value="#{iCarteService}")
    private ICarteService iCarteService;

    /** Injected user bean. */
    
	/*
	@ManagedProperty(value="#{clientBean}")
    private ClientBean clientBean;
    */

    @ManagedProperty(name="iCompteService", value="#{iCompteService}")
	private ICompteService iCompteService;
	
	@ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;
    
	@ManagedProperty(name="iClientService", value="#{iClientService}")
	private IClientService iClientService;
	
	@ManagedProperty(name="iShopService", value="#{iShopService}")
    private IShopService iShopService;
	
	private Clients client;
    private Comptes compte;
    
	
    /** Current user's cart. */
    private Cart cart;

    int index =0;
    private CartItem deletedItem;
    
    private List<CartItem> cartItems; 
    
    /** Total price of items in the cart. */
    private BigDecimal totalPrice;

    /** Total quantity of items in the cart. */
    private Long totalQuantity;

    private int count=0;
    
	public ICarteService getiCarteService() {
		return iCarteService;
	}

	public void setiCarteService(ICarteService iCarteService) {
		this.iCarteService = iCarteService;
	}

   
	

	public CartItem getDeletedItem() {
		return deletedItem;
	}

	public void setDeletedItem(CartItem deletedItem) {
		this.deletedItem = deletedItem;
	}

	public IShopService getiShopService() {
		return iShopService;
	}

	public void setiShopService(IShopService iShopService) {
		this.iShopService = iShopService;
	}

	
	
	
	
	/*
	public ClientBean getClientBean() {
		return clientBean;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}
     */
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	@PostConstruct
    public void init() {
        
		
		String username=compteEnCoursBean.getUsername();
      
        compte = iCompteService.getCompteByLogin(username);
        System.out.println(compte);        
         client=compte.getClient();
        System.out.println(client);
        cart = client.getCart();
       

        
        if (cart == null) {
        	cart = new Cart();
            cart.setClient(client);
            
            iCarteService.creerCart(cart);
            client.setCart(cart);
            iClientService.editerClient(client);
            cart = client.getCart();
        }
        System.out.println(cart);
        getCartItems();
	}
	
	
	
	
	/**
     * Is invoked on creation of this component. Loads cart by current user.
     */
   
	   /*
	@PostConstruct
    public void create() {
        
    	
    	
    	cart = iCarteService.getCurrentCartByUser(client);
    	 System.out.println("cart est"+ cart); 
	
	}
       */
   
    /**
     * Gets all cart items of current cart, and calculates total price and total
     * quantity.
     */
    public List<CartItem> getCartItems() {
        cartItems = iCarteService.getCartItems(cart);

        if (cartItems == null || cartItems.size() == 0) {
        	cartItems = new ArrayList<CartItem>();
        	cart.setCartItems(cartItems);
        	iCarteService.editerCart(cart);
        	cartItems = iCarteService.getCartItems(cart);
        }
        
        
        totalPrice = CartHelper.calculateTotalPrice(cartItems);
        totalQuantity = CartHelper.calculateTotalQuantity(cartItems);

        return cartItems;
    }

    
    
    
    public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
     * Add new item to current cart.
     */
    
    public String addCartItem(Item itemToAdd) {
    	System.out.println("Cart is :"+cart.getId());
    	iCarteService.addCartItem(cart, itemToAdd);
    	System.out.println("Produit ajouté au panier avec succés");
    	FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Produit ajouté au panier avec succés"));
        count++;
        setCount(count);
       return "/pages/cart/cart.xhtml?faces-redirect=true";
    
    }

    /**
     * Remove all items from current cart.
     */
    public void removeAllCartItems() {
    	iCarteService.removeAllCartItems(cart);
        count=0;
        setCount(count);
    }

    /**
     * Remove concrete item from current cart.
     * 
     * @param selectedItem
     *            Cart item to remove.
     */
    
    public void deleteCartItem(CartItem deleteItem) {
  		System.out.println(" Produit a supprimé");
  		index = cartItems.indexOf(deleteItem);
  		System.out.println(" index is" +index);
  		deletedItem = deleteItem;
  		
    }  
    
    public void removeCartItem() {
 		
   	 try{
			System.out.println("EEEEEEEEEEEEEEEEEE");
			iCarteService.removeCartItem(deletedItem,cart);
			
			count=count-deletedItem.getQuantity();
			//setImagePhoto(null);
			//cartItems.set(index, deletedItem);
		    FacesContext context1 = FacesContext.getCurrentInstance();
	        context1.addMessage(null, new FacesMessage("Produit supprimé avec succés"));
	    //RequestContext.getCurrentInstance().reset("editD:display");
	    	   }catch(Exception e ){e.printStackTrace();}
		
	    
	}
   
    
    
    /*
    public void removeCartItem(CartItem selectedItem) {
    	int index = cartItems.indexOf(selectedItem);
    	CartItem deletedItem=selectedItem;
    	deletedItem=iCarteService.removeCartItem(deletedItem,cart);
    	count=count-selectedItem.getQuantity();
    	cartItems.set(index, deletedItem);
    	
    	
    }
*/
    /**
     * Total price getter.
     * 
     * @return Total price.
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Total quantity getter.
     * 
     * @return Total quantity.
     */
    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public ICompteService getiCompteService() {
		return iCompteService;
	}

	public void setiCompteService(ICompteService iCompteService) {
		this.iCompteService = iCompteService;
	}

	public CompteEnCoursBean getCompteEnCoursBean() {
		return compteEnCoursBean;
	}

	public void setCompteEnCoursBean(CompteEnCoursBean compteEnCoursBean) {
		this.compteEnCoursBean = compteEnCoursBean;
	}

	
	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Comptes getCompte() {
		return compte;
	}

	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	

	public IClientService getiClientService() {
		return iClientService;
	}

	public void setiClientService(IClientService iClientService) {
		this.iClientService = iClientService;
	}

	/**
     * Checkout current cart.
     * 
     * @return Ceckout view.
     */
    public String checkout() {
        return "/pages/cart/checkout.xhtml?faces-redirect=true";
    }

    public String continuerAchat(){
    	
    	return "/client/prodRecommande.xhtml?faces-redirect=true";
    }

}
