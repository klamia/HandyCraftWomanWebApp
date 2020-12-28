/**
 * CartItem.java
 * Created: Nov 15, 2007 9:06:21 PM
 */
package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import java.util.Date;





import dz.com.cerist.artisanat.entite.base.BaseEntity;



/**
 * Cart item domain object.
 * 
 * @author Ignas
 * 
 */

public class CartItem extends BaseEntity implements Serializable {

    /** Generated UID for serializable classes. */
    private static final long serialVersionUID = -2945254511029547918L;


    private Item item;
    private Cart cart;
    private Date addedOn;
    private Integer quantity;

  
    
    /**
     * Pure constructor.
     */
    public CartItem() {
        super();
    }

    /**
     * Constructor.
     * 
     * @param item
     *            Item.
     * @param cart
     *            Cart to which item added.
     */
    public CartItem(Item item, Cart cart) {
        super();
        this.item = item;
        this.cart = cart;
        this.quantity = 0;
        this.addedOn = new Date();
    }

    /**
     * Item getter.
     * 
     * @return Item.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Item setter.
     * 
     * @param item
     *            Item to set.
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Cart getter.
     * 
     * @return Cart.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Cart setter.
     * 
     * @param cart
     *            Cart to set.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Added date getter.
     * 
     * @return Date item was added.
     */
    public Date getAddedOn() {
        return addedOn;
    }

    /**
     * Added date setter.
     * 
     * @param addedOn
     *            Set date the item added on.
     */
    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    /**
     * Quantity getter.
     * 
     * @return Quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Quantity setter.
     * 
     * @param quantity
     *            Quantity to set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

   
	/**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cart == null) ? 0 : cart.getId().hashCode());
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CartItem other = (CartItem) obj;
        if (cart == null) {
            if (other.cart != null)
                return false;
        } else if (!cart.getId().equals(other.cart.getId()))
            return false;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.CartItem[ cart=" + cart.getId() + ", item=" + item.getId() + " ]";
    }

}
