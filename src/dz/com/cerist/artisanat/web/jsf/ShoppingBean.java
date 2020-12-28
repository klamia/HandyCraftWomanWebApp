package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import dz.com.cerist.artisanat.entite.Advertisment;
import dz.com.cerist.artisanat.entite.Attribute;
import dz.com.cerist.artisanat.entite.AttributeName;
import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.entite.Shop;

import dz.com.cerist.artisanat.entite.Item;
import dz.com.cerist.artisanat.service.IAdvertisementService;

import dz.com.cerist.artisanat.service.IItemService;
import dz.com.cerist.artisanat.service.IShopService;
import dz.com.cerist.artisanat.web.jsf.CategoryCache;



/**
 * Shopping related services component.
 * 
 * @author Donatas
 * 
 */
@ManagedBean(name = "shoppingBean")
@SessionScoped
public class ShoppingBean implements Serializable {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = -9076712638893073779L;

	/** Item service remote ejb. */
	@ManagedProperty(value="#{iItemService}")
    private IItemService iItemService;

	@ManagedProperty(name="iShopService", value="#{iShopService}")
    private IShopService iShopService;
	
	/** Advertisments service remote ejb. */
	@ManagedProperty(value="#{iAdvertisementService}")
    private IAdvertisementService iAdvertisementService;

	private List<Category> allParentCategories;
	
	
	private  List<Item> firstPageItems ;
	
	
	private  List<Shop> firstPageShops ;
	
	
	private List<AttributeName> itemAttributeNames;
	
	
	private List<Item> topItems;
	
	private List<Advertisment> advertisments;
	
	private List<Category> categories;
	
	private List<Category> categoriesShop;
	
	private List<Category> categoriesForSearch;
	private Category selectedCategory;
	
	private Long selectedAttributeId;
	
	
	
	
	

	/** Component were all system item types are cached. */
	@ManagedProperty(value="#{categoryCache}")
    private CategoryCache categoryCache;

    /** Loaded attributes. */
    private Map<AttributeName, List<Attribute>> loadedAttributes;

    /** Category id request parameter for selected category identification. */
    private Long categoryId;

    /** Attribute id request parameter for selected attribute identification. */
    private Long attributeId;

	public IItemService getiItemService() {
		return iItemService;
	}

	public void setiItemService(IItemService iItemService) {
		this.iItemService = iItemService;
	}


	public IAdvertisementService getiAdvertisementService() {
		return iAdvertisementService;
	}

	public void setiAdvertisementService(IAdvertisementService iAdvertisementService) {
		this.iAdvertisementService = iAdvertisementService;
	}

	public void setCategoryCache(CategoryCache categoryCache) {
		this.categoryCache = categoryCache;
	}

	
	
	
	
	
	/**
     * Gets items by selected category to show on first page.
     * 
     * @return List of items.
     */
    public List<Item> getFirstPageItems() {
    	firstPageItems=iItemService.getFirstPageItems(selectedCategory, attributeId);
    	return firstPageItems; 
    }

    public void setFirstPageItems(List<Item> firstPageItems) {
		this.firstPageItems = firstPageItems;
	}

	/**
     * Gets all attributes of items of selected category.
     * 
     * @return Map of grouped by name attributes.
     */
    public List<AttributeName> getItemAttributeNames() {
        if (loadedAttributes == null) {
            loadAttributes();
        }
        itemAttributeNames= new ArrayList<AttributeName>(loadedAttributes.keySet());
        return itemAttributeNames;
    }

    
    public void setItemAttributeNames(List<AttributeName> itemAttributeNames) {
		this.itemAttributeNames = itemAttributeNames;
	}

	/**
     * Gets item attributes by attribute name (e.g. name:color{value:white,
     * value:black, value:red})
     * 
     * @param attributeName
     *            Name of attribute.
     * @return List of different attributes of that name.
     */
    public List<Attribute> getItemAttributes(AttributeName attributeName) {
        return loadedAttributes.get(attributeName);
    }

    /**
     * Gets items by selected category to show in top items box.
     * 
     * @return List of items.
     */
    public List<Item> getTopItems() {
    	topItems= iItemService.getTopItems(selectedCategory, attributeId);
    	return topItems;
    }

    /**
     * Gets advertisments by selected category.
     * 
     * @return List of advertisments.
     */
    public List<Advertisment> getAdvertisments() {
    	advertisments=iAdvertisementService.getAdvertisments(selectedCategory);
    	return advertisments; 
    }

    /**
     * Gets categories to show in categories box. Returned categories are
     * children of currently selected category.
     * 
     * @return List of categories.
     */
    public List<Category> getCategories() {
        List<Category> subCategories = categoryCache.getCategoriesByParent(selectedCategory);
        categories=subCategories != null ? subCategories : categoryCache.getCategoriesByParent(selectedCategory.getParentCategory());
        return categories;
    }

    /**
     * Gets categories to show in in search bar dropdown.
     * 
     * @return List of categories.
     */
    public List<Category> getCategoriesForSearch() {
        List<Category> searchCategories = categoryCache.getCategoriesByParent(selectedCategory);
        categoriesForSearch=searchCategories != null ? searchCategories : Arrays.asList(selectedCategory);
        return categoriesForSearch; 
    }

    /**
     * Gets parent categories of currently selected category. Used in
     * breadcrums.
     * 
     * @return List of categories.
     */
    public List<Category> getAllParentCategories() {
        Category category = selectedCategory;
         allParentCategories = new ArrayList<Category>();
        while (category != null) {
            allParentCategories.add(category);
            category = category.getParentCategory();
        }
        // null represents parent type for all item types
        Collections.reverse(allParentCategories);
        return allParentCategories;
    }

    public void setAllParentCategories(List<Category> allParentCategories) {
		this.allParentCategories = allParentCategories;
	}

	/**
     * Currently selected category getter.
     * 
     * @return Selected category.
     */
    public Category getSelectedCategory() {
    	selectedCategory=categoryCache.getCategoryById(categoryId);
    	
    	return selectedCategory;
    	
    
    }

    /**
     * Gets currently selected attribute id.
     * 
     * @return attributeId Selected attribute id.
     */
    public Long getSelectedAttributeId() {
    	selectedAttributeId = attributeId;
    	
    	return selectedAttributeId;
    }

    /**
     * Loads attributes by selected category and sorts it to map in
     * loadedAttributes variable.
     */
    private void loadAttributes() {
        List<Attribute> attributes = iItemService.getAttributes(selectedCategory);
        loadedAttributes = new HashMap<AttributeName, List<Attribute>>();
        for (Attribute attribute : attributes) {
            List<Attribute> attributesByName = loadedAttributes.get(attribute.getAttributeName());
            if (attributesByName != null) {
                attributesByName.add(attribute);
            } else {
                attributesByName = new ArrayList<Attribute>();
                attributesByName.add(attribute);
                loadedAttributes.put(attribute.getAttributeName(), attributesByName);
            }
        }
    }

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}

	public Map<AttributeName, List<Attribute>> getLoadedAttributes() {
		return loadedAttributes;
	}

	public void setLoadedAttributes(
			Map<AttributeName, List<Attribute>> loadedAttributes) {
		this.loadedAttributes = loadedAttributes;
	}

	public CategoryCache getCategoryCache() {
		return categoryCache;
	}

	

	public void setTopItems(List<Item> topItems) {
		this.topItems = topItems;
	}

	public void setAdvertisments(List<Advertisment> advertisments) {
		this.advertisments = advertisments;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setCategoriesForSearch(List<Category> categoriesForSearch) {
		this.categoriesForSearch = categoriesForSearch;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public void setSelectedAttributeId(Long selectedAttributeId) {
		this.selectedAttributeId = selectedAttributeId;
	}

	public IShopService getiShopService() {
		return iShopService;
	}

	public void setiShopService(IShopService iShopService) {
		this.iShopService = iShopService;
	}

	

	public List<Category> getCategoriesShop() {
		categoriesShop=categoryCache.getShopsCategories();
		return categoriesShop;
	}

	public void setCategoriesShop(List<Category> categoriesShop) {
		this.categoriesShop = categoriesShop;
	}

	public List<Shop> getFirstPageShops() {
		firstPageShops = iShopService.getAllShops();
		return firstPageShops;
	}

	public void setFirstPageShops(List<Shop> firstPageShops) {
		this.firstPageShops = firstPageShops;
	}

	
	
    
	
	
	
	
}
