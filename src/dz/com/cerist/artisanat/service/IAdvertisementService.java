/**
 * IAdvertismentService.java
 * Created: May 14, 2008 8:31:04 PM
 */
package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Advertisment;
import dz.com.cerist.artisanat.entite.Category;


/**
 * Interface for Advertisments related services.
 * 
 * @author Donatas
 * 
 */

public interface IAdvertisementService {

    /**
     * Gets list of advertisments. Takes selected category into account.
     * 
     * @return Collection of categories.
     */
    List<Advertisment> getAdvertisments(Category selectedCategory);

}
