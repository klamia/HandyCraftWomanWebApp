package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.commons.utils.PersistenceUtils;
import dz.com.cerist.artisanat.entite.Cart;
import dz.com.cerist.artisanat.entite.CartItem;
import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Item;

@Repository("iCartDao")
@Transactional
public class CartDAOimpl implements ICartDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2275867201984420980L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/** Find current cart by user query constant. */
    private static final String FIND_CURRENT_CART_BY_USER_QUERY = "Cart.findByUser";

    
    
    /** Select cart items query constant. */
   // private static final String SELECT_CARTITEMS_QUERY = "select ci from CartItem ci join fetch ci.item join fetch ci.cart where ci.cart.id = :cartId";

    /** Remove cart item query constant. */
  //  private static final String REMOVE_SINGLE_CARTITEM_QUERY = "delete from CartItem ci where ci.id = :cartItemId";

    /** Remove all cart items query constant. */
   // private static final String REMOVE_CARTITEMS_QUERY = "delete from CartItem ci where ci.cart.id = :cartId";
	
    private HashMap<Long, CartItem > items= new HashMap<Long, CartItem>();
	
    private List<CartItem> cartItemsList =new ArrayList<CartItem>();
    
	
    public List<CartItem> getItems() {
    	
    	return new ArrayList<CartItem >(items.values());
	}
    
	public void setItems(HashMap<Long, CartItem> items) {
		this.items = items;
	}

	
	
	public List<CartItem> getCartItemsList() {
		return cartItemsList;
	}

	public void setCartItemsList(List<CartItem> cartItemsList) {
		this.cartItemsList = cartItemsList;
	}

	@Override
	public Cart createCartByUser(Clients client) {
		Cart cart = new Cart();
        cart.setClient(client);
        em.persist(cart);
        return cart;
        
	}

	@Override
	public void removeCart(Cart cart) {
		em.remove(cart);

	}

	@Override
	public void setCartCurrent(Cart cart) throws Exception {
		throw new OperationNotSupportedException();

	}

	@Override
	public Cart getCurrentCartByUser(Clients client) {
		Query query = em.createNamedQuery(CartDAOimpl.FIND_CURRENT_CART_BY_USER_QUERY);
        query.setParameter("clientId", client.getId());
        Cart cart = (Cart) PersistenceUtils.getSingleResult(query.getResultList());
        if (cart == null) {
            cart = createCartByUser(client);
        }
        return cart;
	}

	@Override
	public List<Cart> getAllCartsByUser(Clients client) throws Exception {
		throw new OperationNotSupportedException();
	}

	
	public void addCartItem(Cart cart, Item item) {
		
		
		if (cart.isTransient()) {
        	em.persist(cart);
        }
		Long itemId = item.getId();
		if (items.containsKey(itemId)) {
			CartItem cartItem = items.get(itemId);	
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			
			
			//em.merge(cartItem);
		} else {
			CartItem cartItem = new CartItem(item, cart);
			cartItem.setQuantity(1);
			//em.persist(cartItem);
			items.put(item.getId(), cartItem);
			cartItemsList.add(cartItem);
			cart.setCartItems(cartItemsList);
			em.merge(cart);
		}
		
		
	    

	}

	@Override
	public CartItem removeCartItem(CartItem cartItem, Cart cart) {
		/*
		Query query = em.createQuery(CartDAOimpl.REMOVE_SINGLE_CARTITEM_QUERY);
        query.setParameter("cartItemId", cartItem.getId());
        query.executeUpdate();*/
		
		
		items.values().remove(cartItem.getItem().getId());
		items.values().remove(cartItem);
		
	
		cartItemsList.remove(cartItem);
		cart.setCartItems(cartItemsList);
		
		em.merge(cart);
		return cartItem;

	}

	
	@Override
	public List<CartItem> getCartItems(Cart cart) {
		/*
		Query query = em.createQuery(CartDAOimpl.SELECT_CARTITEMS_QUERY);
        query.setParameter("cartId", cart.getId());
        
        return query.getResultList();
	*/
	      return cart.getCartItems();
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		/*
		Query query = em.createQuery(CartDAOimpl.REMOVE_CARTITEMS_QUERY);
        query.setParameter("cartId", cart.getId());
        query.executeUpdate();
        */
		items.values().clear();
		cartItemsList.clear();
		cart.setCartItems(cartItemsList);
		em.merge(cart);
	}

	@Override
	public void creerCart(Cart cart) {
		em.persist(cart);
		
	}

	@Override
	public Cart editerCart(Cart cart) {
		// TODO Auto-generated method stub
		cart=em.merge(cart);
		return cart;
	}

}
