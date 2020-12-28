package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dz.com.cerist.artisanat.entite.base.BaseEntity;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7093715958892667414L;

	/** Item added in the cart. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;

    /** Cart in which item was added. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_ID", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;
    
    /** Date item added on. */
    @Temporal(TemporalType.DATE)
    @Column(name = "ADDED_ON", nullable = false)
    private Date addedOn;

    /** Quantity of this same item in cart. */
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

  
    
    /**
     * Pure constructor.
     */
    public OrderItem() {
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
   /*
    public OrderItem(Item item, Cart cart, Order order) {
        super();
        this.item = item;
        this.cart = cart;
        this.order= order;
        this.quantity = 1;
        this.addedOn = new Date();
        
    }
*/
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

    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
        result = prime * result + ((order == null) ? 0 : order.hashCode());
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
        final OrderItem other = (OrderItem) obj;
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
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        
        return true;
    }


    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.OrderItem[ cart=" + cart.getId() + ", item=" + item.getId() + ", order=" + order.getId() + " ]";
    }


}
