/**
 * OrderStatusEnum.java
 * Created: 5:28:48 PM Aug 17, 2008
 */
package dz.com.cerist.artisanat.entite;

/**
 * Enum for describing order status.
 * 
 * @author Ignas
 * 
 */
public enum OrderStatusEnum {

    /** Order still under processing. */
    SENT(0),

    /** Order processed and sent. */
    PROCESSING(1),

    /** Order on the way. */
    ON_THE_WAY(2),

    /** Order successfully delivered to client. */
    DELIVERED(3),

    /** Order Canceled. */
    CANCELED(4);

    
    /** Enum id. */
    private Integer id;

    /**
     * Constructor of the enum.
     * 
     * @param id
     */
    OrderStatusEnum(int id) {
        this.id = id;
    }

    /**
     * Enum ID getter.
     * 
     * @return id Enum id.
     */
    public int getId() {
        return id;
    }

}
