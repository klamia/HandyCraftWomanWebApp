/**
 * PaymentMethodEnum.java
 * Created: 10:24:10 PM Aug 26, 2008
 */
package dz.com.cerist.artisanat.entite;

/**
 * Enum for describing payment method.
 * 
 * @author Ignas
 * 
 */
public enum PaymentMethodEnum {

    /** Pay with credit card through paypal. */
    CREDIT_CARD_PAYPAL(0),

    /** Seb banklink method. */
    BANKLINK_SEB(1),

    /** Hansa banklink method. */
    BANKLINK_HANSA(2);

    /** Enum id. */
    private Integer id;

    /**
     * Constructor of the enum.
     * 
     * @param id
     */
    PaymentMethodEnum(Integer id) {
        this.id = id;
    }

    /**
     * Enum ID getter.
     * 
     * @return id Enum id.
     */
    public Integer getId() {
        return id;
    }

}
