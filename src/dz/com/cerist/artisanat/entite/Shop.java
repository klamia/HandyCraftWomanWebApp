/**
 * Shop.java
 * Created: Sep 4, 2007 11:17:29 PM
 */
package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import java.util.List;






import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



import javax.persistence.Table;



import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;



import dz.com.cerist.artisanat.entite.base.BaseEntity;



/**
 * Shop domain object.
 * 
 * @author Donatas
 * 
 */
@Entity
@Table(name = "SHOPS")
@Searchable

@NamedQueries({
	
	@NamedQuery(name = "Shop.getShopByID", query = "select sh FROM Shop sh WHERE sh.id = :id"),
    @NamedQuery(name = "Shop.getAllShops", query = "select sh FROM Shop sh "),
    @NamedQuery(name = "Shop.getAllShopsCategory",  query = "select sh FROM Shop sh join sh.category ca where ca.id=:categoryId"),
    @NamedQuery(name = "Shop.findShopsArtisane", query = "select sh FROM Shop sh join sh.artisane ar where ar.id=:artisane_ID")
})

public class Shop implements Serializable{

    /** Generated UID for serializable classes. */
    private static final long serialVersionUID = -5839055053496203469L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    
    private Long id;
    
    /** Shop name field */
    @Column(name = "NAME", nullable = false)
   
    private String name;

    /** Unique id of the shop's logotype. */
    @Column(name = "IMAGE_SRC", nullable = true)
    
    private String imageSource;

    
    /*
    /*Additional shop information 
    @OneToOne
    @JoinColumn(name = "SHOP_INFO_ID", nullable = false)
    private ShopInfo shopInfo;
    */
    @Embedded
    
    private Contact contact;
    
    @Embedded
   
    private Address address;
    
    @JoinColumn(name = "category_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
  
    private Category category;
    
    @JoinColumn(name = "artisane_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    
    private Artisanes artisane;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "wilaya_ID", referencedColumnName = "ID")
    
    private Wilayas wilaya;
    
    @OneToMany(mappedBy="shop", cascade=CascadeType.ALL)
	private List<Item> items;
    
    
	/**
     * Pure constructor.
     */
    public Shop() {
    	super();
       /* shopInfo = new ShopInfo();*/
        address = new Address();
        contact = new Contact();
    }

    
    
   
	
	
    
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
     * Name getter.
     * 
     * @return Name.
     */
    public String getName() {
        return name;
    }

   

	/**
     * Name setter.
     * 
     * @param name
     *            Name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ImageSource getter.
     * 
     * @return ImageSource.
     */
    public String getImageSource() {
        return imageSource;
    }

    /**
     * ImageSource setter.
     * 
     * @param imageSource
     *            ImageSource to set.
     */
    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Artisanes getArtisane() {
		return artisane;
	}

	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}

	/**
     * Additional shop info getter.
     * 
     * @return ShopInfo.
     */
    
	public Wilayas getWilaya() {
		return wilaya;
	}

	public void setWilaya(Wilayas wilaya) {
		this.wilaya = wilaya;
	}
    

	public Contact getContact() {
		return contact;
	}

	

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Category getCategory() {
		return category;
	}

	

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public List<Item> getItems() {
		return items;
	}







	public void setItems(List<Item> items) {
		this.items = items;
	}


	
	
	public Item addItem(Item item) {
		getItems().add(item);
		item.setShop(this);

		return item;
	}

	public Item removeIdent(Item item) {
		getItems().remove(item);
		item.setShop(null);

		return item;
	}





	@Override
    public String toString() {
    	return String.format("Shop[%s,%s]", getName(), getArtisane()); 
    }

}
