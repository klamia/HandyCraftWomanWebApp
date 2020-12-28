package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Attribute;
import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.entite.Item;
import dz.com.cerist.artisanat.entite.Shop;



public interface IItemDao {
	/**
     * Gets item by id.
     * 
     * @param id
     *            Item id.
     * @return Item.
     */
	public Item getItemById(Long id);

    /**
     * Save new item.
     * 
     * @param item
     *            Item to save.
     * @return Saved item.
     */
	public Item saveItem(Item item);

    /**
     * Gets all attributes of items of selected category grouped by attribute
     * name.
     * 
     * @param selectedCategory
     *            Selected category for items navigation.
     * @return Map of attributes grouped by names.
     */
	public List<Attribute> getAttributes(Category selectedCategory);

    /**
     * Gets all items.
     * 
     * @return Collection of categories.
     */
	public List<Item> getItems();

    /**
     * Gets first page items.
     * 
     * @param selectedCategory
     *            Selected category for items navigation.
     * @param attributeId
     *            Selected attribute for items navigation.
     * @return List of first page items.
     */
	public List<Item> getFirstPageItems(Category selectedCategory, Long attributeId);

    /**
     * Gets top items.
     * 
     * @param selectedCategory
     *            Selected category for items navigation.
     * @param attributeId
     *            Selected attribute for items navigation.
     * @return List of top items.
     */
	public List<Item> getTopItems(Category selectedCategory, Long attributeId);

	public  List<Item> getAllItemsArtisane(Artisanes artisane);
	
	public  List<Item> getAllItemsPublies(Artisanes artisane);
	
	public  List<Item> getAllItemsNonPublies(Artisanes artisane);
	
	public  List<Item> getAllItemsShop(Shop shop);
	
	public Item getItemByName(String name);
	
	public Item editerItem(Item item);
	
	public Item remove(Item item);

	public void activerItem(Item item);
	  
    public void desactiverItem(Item item);


}
