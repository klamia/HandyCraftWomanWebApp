package dz.com.cerist.artisanat.dao;

import java.util.List;


import dz.com.cerist.artisanat.entite.Cart;
import dz.com.cerist.artisanat.entite.CartItem;
import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Item;

public interface ICartDao {

	/**
     * Creates new cart for user.
     * 
     * @param user
     *            User to create cart for.
     */
	public  void creerCart(Cart cart);
	
	
	
	public Cart createCartByUser(Clients client);

    /**
     * Remove cart.
     * 
     * @param cart
     *            Cart to remove.
     */
	public void removeCart(Cart cart);

    /**
     * Set a cart as current cart.
     * 
     * @param cart
     *            Cart which need to be set as current.
     */
	public void setCartCurrent(Cart cart) throws Exception;

    /**
     * Gets users current cart.
     * 
     * @param user
     *            User whose current cart we want to get.
     * @return Current user cart.
     */
	public Cart getCurrentCartByUser(Clients client);

    /**
     * Gets users all carts.
     * 
     * @param user
     *            User whose carts we want to get.
     * @return List of carts.
     */
	public List<Cart> getAllCartsByUser(Clients client) throws Exception;

    /**
     * Adds item to cart.
     * 
     * @param cart
     *            Cart to add item to.
     * @param item
     *            Item to add.
     */
	public void addCartItem(Cart cart, Item item);

    /**
     * Removes cart item from cart.
     * 
     * @param cartItem
     *            CartItem to remove.
     */
	public CartItem removeCartItem(CartItem cartItem, Cart cart);

	
	
	/**
     * Gets all cart items.
     * 
     * @param cart
     *            Cart to get cart items from.
     * @return List of cart items.
     */
	public List<CartItem> getCartItems(Cart cart);

    /**
     * Removes all cart items.
     * 
     * @param cart
     *          remove cart items from cart
     */
	public void removeAllCartItems(Cart cart);

    public Cart editerCart(Cart cart);

}
