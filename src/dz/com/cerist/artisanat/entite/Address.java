/**
 * Address.java
 * Created: Dec 19, 2007 7:15:11 PM
 */
package dz.com.cerist.artisanat.entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;






/**
 * Address class.
 * 
 * @author Ignas
 * 
 */
@Embeddable
public class Address  implements Serializable {

    /** Generated UID for serializable classes. */
    private static final long serialVersionUID = -9134841794533072417L;

    /** House or appartament number. */
    @Column(name = "ADDRESS_NUMBER")
    private String addressNumber;

    /** City. */
    @Column(name = "CITY")
    private String city;
    
    /** Country. */
    @Column(name = "COUNTRY")
    private String country;

   

   
    /**
     * Country getter.
     * 
     * @return Country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Country setter.
     * 
     * @param country
     *            Country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * City getter.
     * 
     * @return City
     */
    public String getCity() {
        return city;
    }

    /**
     * City getter.
     * 
     * @param city
     *            City to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    
    /**
     * Address number getter.
     * 
     * @return Address number.
     */
    public String getAddressNumber() {
        return addressNumber;
    }

    /**
     * Address number setter.
     * 
     * @param addressNumber
     *            Address number to set.
     */
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

}
