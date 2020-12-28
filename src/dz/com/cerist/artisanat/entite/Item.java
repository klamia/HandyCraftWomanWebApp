/**
 * Item.java
 * Created: Sep 4, 2007 11:10:36 PM
 */
package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




import org.compass.annotations.ExcludeFromAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.SearchableReference;



import dz.com.cerist.artisanat.entite.base.BaseEntity;


/**
 * Shop item domain object.
 * 
 * @author Donatas
 * 
 */
@Entity
@Table(name = "ITEMS")
@Searchable
@NamedQueries({
    
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findItemsArtisane", query = "select i FROM Item i join i.artisane ar where ar.id=:artisane_ID"),
    @NamedQuery(name = "Item.findItemsPublies", query = "select i FROM Item i join i.artisane ar where ar.id=:artisane_ID and i.activated=true" ),
    @NamedQuery(name = "Item.findItemsNonPublies", query = "select i FROM Item i join i.artisane ar where ar.id=:artisane_ID and i.activated=false" ),
    @NamedQuery(name = "Item.findItemsShops", query = "select i FROM Item i join i.shop sh where sh.id=:SHOP_ID")
    
})

public class Item  implements Serializable {

    /** Generated serialVersionUID. */
    private static final long serialVersionUID = 2497245037644206019L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    
    private Long id;
    
    
    /** Shop containing this item. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_ID", nullable = false)
    @SearchableReference
    private Shop shop;

    /**
     * Name of the item. This field is indexed by hibernate search, so that
     * means it is searchable.
     */
    @Column(name = "NAME", nullable = false)
    @SearchableProperty 
    private String name;

    /** Price of the item. */
    @Column(name = "PRICE", nullable = false)
    @SearchableProperty(excludeFromAll = ExcludeFromAll.YES)
    private BigDecimal price;

    /** Number of available items. */
    @Column(name = "QUANTITY", nullable = false)
    @SearchableProperty(excludeFromAll = ExcludeFromAll.YES)  
    private Long quantity;

    /**
     * Short description of the item. This field is indexed by hibernate search,
     * so that means it is searchable.
     */
    @Column(name = "SHORT_DESCRIPTION", nullable = false)
    @SearchableProperty   
    private String shortDescription;

    /** Short description of the item. */
    @Column(name = "FULL_DESCRIPTION", nullable = false, length = 10000)
    @SearchableProperty 
    private String fullDescription;


    /** Image source unique id, for retrieving images from image server. */
    @Column(name = "IMAGE_SRC", nullable = false)
    @SearchableProperty(excludeFromAll = ExcludeFromAll.YES)
    
    private String imageSource;

    /**
     * This field indicates if item is activated and should be shown for user to
     * buy.
     */
    @Column(name = "IS_ACTIVATED")
    @SearchableProperty(excludeFromAll = ExcludeFromAll.YES)
    
    private Boolean activated;

    /** Categories this item belongs to. */
    @ManyToMany
    @JoinTable(name = "ITEM_CATEGORIES", joinColumns = { @JoinColumn(name = "ITEM_ID") }, inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    @SearchableReference
   
    private Set<Category> categories;

    /** Attributes this item has. */
    @ManyToMany
    @JoinTable(name = "ITEM_ATTRIBUTES", joinColumns = { @JoinColumn(name = "ITEM_ID") }, inverseJoinColumns = @JoinColumn(name = "ATTRIBUTE_ID"))
    @SearchableReference
   
    private Set<Attribute> attributes;

    
    @JoinColumn(name = "artisane_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Artisanes artisane;
    
    /** Colour of the item. */
    @JoinColumn(name = "couleur_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Couleurs couleur;
    
    /** Type of the item. */
    @JoinColumn(name = "tendance_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tendances tendance;
   
    
    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "imageProduit")
    private byte[] imageProduit;
   
    
  

    
    
    /**
     * Compass search is used for full text search. By design Compass search
     * needs to store an id in the index. <i>@SearchableId</i> annotation marks
     * the property to use for this purpose. Since our item id is inherited from
     * {@link BaseEntity} we need transient method to get that id and
     * annotate it for Compass search.
     * 
     * @return Item ID
     */
 
    @SearchableId
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
    
    /**
     * Categories getter.
     * 
     * @return categories.
     */
    public Set<Category> getCategories() {
        return categories;
    }

    

	/**
     * Categories setter.
     * 
     * @param categories
     *            Categories to set.
     */
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    /**
     * Item name getter.
     * 
     * @return Item name.
     */
    public String getName() {
        return name;
    }

    /**
     * Item name setter.
     * 
     * @param name
     *            Item name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Shop getter.
     * 
     * @return Shop.
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * Shop setter.
     * 
     * @param shop
     *            Shop to set.
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     * Price getter.
     * 
     * @return Price.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Price setter.
     * 
     * @param price
     *            Price to set.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Quantity getter.
     * 
     * @return Quantity.
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * Quantity setter.
     * 
     * @param quantity
     *            Quantity to set.
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * Short description getter.
     * 
     * @return Short description.
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Short description setter.
     * 
     * @param shortDescription
     *            Short description to set.
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Image unique id getter.
     * 
     * @return Image unique id.
     */
    public String getImageSource() {
        return imageSource;
    }

    /**
     * Image unique id setter.
     * 
     * @param imageSource
     *            Image unique id to set.
     */
    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    /**
     * Full description getter.
     * 
     * @return Full description.
     */
    public String getFullDescription() {
        return fullDescription;
    }

    /**
     * Full description getter.
     * 
     * @param fullDescription
     *            Full description to set.
     */
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    /**
     * Activated boolean value getter.
     * 
     * @return true if item activated and false otherwise.
     */
    public Boolean getActivated() {
        return activated;
    }

    /**
     * Activated boolean value setter.
     * 
     * @param activated
     *            Activated boolean value to set.
     */
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    /**
     * Attributes getter.
     * 
     * @return attributes.
     */
    public Set<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Attributes setter.
     * 
     * @param attributes
     *            Attributes to set.
     */
    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

	public Artisanes getArtisane() {
		return artisane;
	}

	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}

		
	
	public Couleurs getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleurs couleur) {
		this.couleur = couleur;
	}

	public Tendances getTendance() {
		return tendance;
	}

	public void setTendance(Tendances tendance) {
		this.tendance = tendance;
	}

	public byte[] getImageProduit() {
		return imageProduit;
	}

	public void setImageProduit(byte[] imageProduit) {
		this.imageProduit = imageProduit;
	}

	
	

	/**
     * Better to override this method in concrete domain class, because for
     * transient entities ID is null.
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Better to override this method in concrete domain class, because for
     * transient entities ID is null.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
	
	
	
	@Override
    public String toString() {
    	return String.format("Item[%s,%s]", getName(), getArtisane()); 
    }
    


}
