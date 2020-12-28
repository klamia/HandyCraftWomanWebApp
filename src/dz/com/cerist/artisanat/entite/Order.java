/**
 * Order.java
 * Created: 4:09:09 PM Aug 17, 2008
 */
package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dz.com.cerist.artisanat.entite.base.BaseEntity;



/**
 * Order domain object.
 * 
 * @author Ignas
 * 
 */
@Entity
@Table(name = "ORDERS")
@NamedQueries({
    
    @NamedQuery(name = "Orders.findAllDeliveredOrders", query = "SELECT o FROM Order o join o.artisane ar where ar.id=:artisane_ID and o.status =:statusDelivered "),
    @NamedQuery(name = "Orders.findAllSentOrders", query = "SELECT o FROM Order o join o.artisane ar where ar.id=:artisane_ID and o.status =:statusSent "),
    @NamedQuery(name = "Orders.findAllProcessingOrders", query = "SELECT o FROM Order o join o.artisane ar where ar.id=:artisane_ID and o.status =:statusProcessing "),
    @NamedQuery(name = "Orders.findAllWaitingOrders", query = "SELECT o FROM Order o join o.artisane ar where ar.id=:artisane_ID and o.status =:statusOnTheWay ")   
})
public class Order extends BaseEntity implements Serializable {

    /** Generated serialVersionUID. */
    private static final long serialVersionUID = 466275624553410517L;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDERED_ON")
    private Date orderedOn;

    @Column(name = "STATUS")
    private OrderStatusEnum status;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_ID", nullable = false)
    private Clients client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artisane_ID", nullable = false)
    private Artisanes artisane;
    
    /*
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ORDER_ITEMS", joinColumns = { @JoinColumn(name = "ORDER_ID") }, inverseJoinColumns = @JoinColumn(name = "CART_ITEM_ID"))
    private List<CartItem> orderedItems;
    */
   
    @Column(name = "ORDER_PRICE")
    private BigDecimal orderPrice;

    @Temporal(TemporalType.DATE)
    @Column(name = "DELIVERED_ON")
    private Date deliveredOn;

    @Temporal(TemporalType.DATE)
    @Column(name = "ACCEPTED_ON")
    private Date acceptedOn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderedItems;
    
    
    
    /**
     * @return deliveredOn.
     */
    public Date getDeliveredOn() {
        return deliveredOn;
    }

    /**
     * @param deliveredOn
     *            deliveredOn to set.
     */
    public void setDeliveredOn(Date deliveredOn) {
        this.deliveredOn = deliveredOn;
    }

    

    /**
     * @return orderPrice.
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * @param orderPrice
     *            orderPrice to set.
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * @return status.
     */
    public OrderStatusEnum getStatus() {
        return status;
    }

    /**
     * @param status
     *            status to set.
     */
    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

   
    public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	
	public Artisanes getArtisane() {
		return artisane;
	}

	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}

	
    
    /**
     * @return orderedOn.
     */
    public Date getOrderedOn() {
        return orderedOn;
    }

    /**
     * @param orderedOn
     *            orderedOn to set.
     */
    public void setOrderedOn(Date orderedOn) {
        this.orderedOn = orderedOn;
    }

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getAcceptedOn() {
		return acceptedOn;
	}

	public void setAcceptedOn(Date acceptedOn) {
		this.acceptedOn = acceptedOn;
	}

	public List<OrderItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<OrderItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

    

}
