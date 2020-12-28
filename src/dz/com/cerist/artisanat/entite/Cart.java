/**
 * Cart.java
 * Created: Sep 4, 2007 11:24:04 PM
 */
package dz.com.cerist.artisanat.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dz.com.cerist.artisanat.entite.base.BaseEntity;



/**
 * Shopping cart domain object.
 * 
 * @author Donatas
 * 
 */
@Entity
@Table(name = "CARTS")
@NamedQueries( { @NamedQuery(name = "Cart.findByUser", query = "select c from Cart c where c.client.id = :clientId") })
public class Cart extends BaseEntity {

    /** Generated UID for serializable classes. */
    private static final long serialVersionUID = 5922802610511121510L;

    /** Cart's user */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_ID", nullable = false)
    private Clients client;

    @Transient
    private List<CartItem> cartItems;

    public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((client == null) ? 0 : client.hashCode());
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
        final Cart other = (Cart) obj;
        if (client == null) {
            if (other.client != null)
                return false;
        } else if (!client.equals(other.client))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cart[ idCart=" + client.getCart().getId() + " ]";
    }

}
