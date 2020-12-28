package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Attribute;
import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.entite.Item;
import dz.com.cerist.artisanat.entite.Shop;
import dz.com.cerist.artisanat.exception.MyProfilException;

@Repository("iItemDao")
@Transactional
public class ItemDAOimpl implements IItemDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8619502164529707080L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	/** Select items query constant. */
    private static final String SELECT_ITEMS_QUERY = "select i from Item i join fetch i.types";
	
	@Override
	public Item getItemById(Long id) {
		return em.find(Item.class, id);
	}

	@Override
	public Item saveItem(Item item) {
		if(item.getId() == null) {
			em.persist(item);
		} else {
			em.merge(item);
		}
        return item;
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<Attribute> getAttributes(Category selectedCategory) {
        if (selectedCategory != null) {
            Query attributesQuery = em
                    .createQuery("select a from Attribute a, Category c "
                            + "join c.attributeTemplate at "
                            + "where c.id = :categoryId and a.attributeName.id = at.id");
            attributesQuery.setParameter("categoryId", selectedCategory.getId());
            // List<Attribute> attributesFound =
            // attributesQuery.getResultList();
            // Set<Attribute> uniqueAttributes = new HashSet<Attribute>();
            // uniqueAttributes.addAll(attributesFound);
            // return new ArrayList(uniqueAttributes);
            return attributesQuery.getResultList();
        } else {
            return Collections.EMPTY_LIST;
        }
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<Item> getItems() {
        return em.createQuery(ItemDAOimpl.SELECT_ITEMS_QUERY).getResultList();
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<Item> getFirstPageItems(Category selectedCategory, Long attributeId) {
        Query query = null;
        if (selectedCategory == null) {
            query = em.createQuery("select i from Item i");
        } else if (selectedCategory != null && attributeId == null) {
            query = em.createQuery("select i from Item i, in (i.categories) c "
                    + "where c.id = :categoryId");
            query.setParameter("categoryId",
                    selectedCategory != null ? selectedCategory.getId() : null);
        } else if (selectedCategory != null && attributeId != null) {
            query = em.createQuery("select i from Item i, in (i.categories) c, in (i.attributes) a "
                            + "where c.id = :categoryId and a.id = :attributeId");
            query.setParameter("categoryId",
                    selectedCategory != null ? selectedCategory.getId() : null);
            query.setParameter("attributeId", attributeId);
        }

        return query.getResultList();
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<Item> getTopItems(Category selectedCategory, Long attributeId) {
        Query query = null;
        if (selectedCategory == null) {
            query = em.createQuery("select i from Item i");
        } else if (selectedCategory != null && attributeId == null) {
            query = em.createQuery("select i from Item i, in (i.categories) c "
                    + "where c.id = :categoryId");
            query.setParameter("categoryId",
                    selectedCategory != null ? selectedCategory.getId() : null);
        } else if (selectedCategory != null && attributeId != null) {
            query = em
                    .createQuery("select i from Item i, in (i.categories) c, in (i.attributes) a "
                            + "where c.id = :categoryId and a.id = :attributeId");
            query.setParameter("categoryId",
                    selectedCategory != null ? selectedCategory.getId() : null);
            query.setParameter("attributeId", attributeId);
        }

        query.setMaxResults(10);
        // TODO no hardcode
        return query.getResultList();
    }

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItemsArtisane(Artisanes artisane) {
		try {
		      return em.createNamedQuery("Item.findItemsArtisane").setParameter("artisane_ID", artisane.getId()).getResultList();
		    } catch (Throwable th) {
		      throw new MyProfilException(th,15);
		    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItemsShop(Shop shop) {
		try {
		      return em.createNamedQuery("Item.findItemsShops").setParameter("SHOP_ID", shop.getId()).getResultList();
		    } catch (Throwable th) {
		      throw new MyProfilException(th,15);
		    }
	
	}
	
	@Override
	public Item getItemByName(String name) {
		try{
			
			 Query query = em.createNamedQuery("Item.findByName");
				query.setParameter("name", name);
				return (Item) query.getSingleResult();
			
			 
			 
		 
		 }
		 catch (Throwable th){
			 throw new MyProfilException(th,15);
			 }
	}

	@Override
	public Item editerItem(Item item) {
		try{
			return em.merge(item);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
	}

	@Override
	public void activerItem(Item item) {
		try{
			
			item.setActivated(true);
			 em.merge(item);
	       }
	       catch (Throwable th){
				 throw new MyProfilException(th,17);
				 }
		
	}

	@Override
	public void desactiverItem(Item item) {
		try{
			item.setActivated(false);
			item.setShop(null);
			 em.merge(item);
			}
			catch (Throwable th){
				 throw new MyProfilException(th,18);
				 }
			}

	@Override
	public Item remove(Item item) {
		try{
			em.remove(em.merge(item));
			return item;
			}
			catch (Throwable th){
				 throw new MyProfilException(th,14);
				 }
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItemsPublies(Artisanes artisane) {
		try {
		      return em.createNamedQuery("Item.findItemsPublies").setParameter("artisane_ID", artisane.getId()).getResultList();
		    } catch (Throwable th) {
		      throw new MyProfilException(th,15);
		    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItemsNonPublies(Artisanes artisane) {
		try {
		      return em.createNamedQuery("Item.findItemsNonPublies").setParameter("artisane_ID", artisane.getId()).getResultList();
		    } catch (Throwable th) {
		      throw new MyProfilException(th,15);
		    }
	}

	
		
	

}
