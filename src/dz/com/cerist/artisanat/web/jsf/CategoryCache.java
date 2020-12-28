/**
 * CategoriesCache.java
 * Created: Feb 5, 2008 10:23:31 PM
 */
package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.exception.fatal.UnrecoverableApplicationException;
import dz.com.cerist.artisanat.service.ICategorieService;





/**
 * Component in application scope for keeping cached {@link Category} objects.
 * On application startup it loads all categories and sorts them. Categories in
 * application are used only from this cache.
 * 
 * @author Ignas
 * 
 */
@ManagedBean(name = "categoryCache")
@SessionScoped
public class CategoryCache implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9008707097164605127L;


	/** Category service remote ejb. */
	@ManagedProperty(value="#{iCategorieService}")
    private ICategorieService iCategorieService;
	                         

    /**
     * Map of all application {@link Category} objects. Parent category is map
     * key and value is list of children categories.
     */
    private Map<Category, List<Category>> sortedCategories;

    /** List of all categories. */
    private List<Category> allCategories;

    private List<Category> shopsCategories;
	
	public Map<Category, List<Category>> getSortedCategories() {
		return sortedCategories;
	}

	public void setSortedCategories(Map<Category, List<Category>> sortedCategories) {
		this.sortedCategories = sortedCategories;
	}

	public List<Category> getAllCategories() {
		return allCategories;
	}

	public void setAllCategories(List<Category> allCategories) {
		this.allCategories = allCategories;
	}

	public ICategorieService getiCategorieService() {
		return iCategorieService;
	}

	public void setiCategorieService(ICategorieService iCategorieService) {
		this.iCategorieService = iCategorieService;
	}

	/**
     * Gets children categories by parent category.
     * 
     * @param parent
     *            Parent category.
     * @return Children categories of parent.
     */
    public List<Category> getCategoriesByParent(Category parent) {
        if (allCategories == null || sortedCategories == null) {
            buildCategories();
        }
        return sortedCategories.get(parent);
    }

    /**
     * Gets category by given id.
     * 
     * @param id
     *            Identifier of category we want to get.
     * @return Category.
     */
    public Category getCategoryById(Long id) {
        if (allCategories == null || sortedCategories == null) {
            buildCategories();
        }

        Category categoryToReturn = null;
        for (Category category : allCategories) {
            if (category.getId().equals(id)) {
                categoryToReturn = category;
            }
        }
        return categoryToReturn;
    }

    /**
     * Builds categories map from database.
     */
    private void buildCategories() {
        List<Category> categories = iCategorieService.getCategories();
        if (categories == null || categories.size() == 0) {
            throw new UnrecoverableApplicationException(
                    "no item types found in database");
        }

        Map<Category, List<Category>> categoriesMap = new HashMap<Category, List<Category>>();
        for (Category subCategory : categories) {
            Category parent = subCategory.getParentCategory();
            if (categoriesMap.get(parent) == null) {
                categoriesMap.put(parent, new ArrayList<Category>());
                categoriesMap.get(parent).add(subCategory);
            } else {
                categoriesMap.get(parent).add(subCategory);
            }
        }

        this.allCategories = categories;
        this.sortedCategories = categoriesMap;
    }

    
    
    
    /**
     * Refresh map of {@link Category} objects. Usually is usable when new item
     * type is added to database. For now refresh categories is not implemented
     * and changes in categories table in database are not mirrored to
     * application.
     */
    @SuppressWarnings("unused")
    private void refreshCategories() {
    }

    public List<Category> getShopsCategories() {
		shopsCategories= iCategorieService.getShopsCategories();
		return shopsCategories;
	}

	public void setShopsCategories(List<Category> shopsCategories) {
		this.shopsCategories = shopsCategories;
	}
  


}
