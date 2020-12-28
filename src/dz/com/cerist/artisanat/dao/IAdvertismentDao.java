package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Advertisment;
import dz.com.cerist.artisanat.entite.Category;

public interface IAdvertismentDao {

	/**
     * Gets list of advertisments. Takes selected category into account.
     * 
     * @return Collection of categories.
     */
    List<Advertisment> getAdvertisments(Category selectedCategory);

}
