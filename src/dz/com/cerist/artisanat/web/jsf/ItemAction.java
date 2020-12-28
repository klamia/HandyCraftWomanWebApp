/**
 * ItemAction.java
 * Created: 8:55:17 PM Jul 30, 2008
 */
package dz.com.cerist.artisanat.web.jsf;


import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Part;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.apache.commons.io.IOUtils;
import ro.tuc.dsrl.m2o.utility.PropertiesLoader;
import dz.com.cerist.artisanat.entite.Comment;
import dz.com.cerist.artisanat.entite.Comptes;

import dz.com.cerist.artisanat.entite.Users;
import dz.com.cerist.artisanat.entite.Item;
import dz.com.cerist.artisanat.service.IArtisaneService;
import dz.com.cerist.artisanat.service.ICommentService;
import dz.com.cerist.artisanat.service.ICompteService;
import dz.com.cerist.artisanat.service.IShopService;
import dz.com.cerist.artisanat.service.IItemService;

/**
 * Component for showing item details related information.
 * 
 * @author Ignas
 * 
 */
@ManagedBean(name = "itemAction")
@SessionScoped
public class ItemAction implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8697362578474928125L;

	
	@ManagedProperty(name="iArtisaneService", value="#{iArtisaneService}")
	private IArtisaneService iArtisaneService;
	
	
	@ManagedProperty(name="iCompteService", value="#{iCompteService}")
	private ICompteService iCompteService;
	
	@ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;
	
	@ManagedProperty(name="artisaneBean", value="#{artisaneBean}")
	private ArtisaneBean artisaneBean;
   
	
	
	
	/*private Artisanes artisane;*/
    private Comptes compte;
   
    
    private List<Item> listItemsArtisane ;
    
    private List<Item> listItemsPublies ;
    
    private List<Item> listItemsNonPublies ;
    
    private List<Item> filteredItems;

	@ManagedProperty(name="iShopService", value="#{iShopService}")
    private IShopService iShopService;
	
	private static String CONFIG_FILE = "/artisanat-config.config";
    @SuppressWarnings("unused")
	private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	

	public ArtisaneBean getArtisaneBean() {
		return artisaneBean;
	}

	public void setArtisaneBean(ArtisaneBean artisaneBean) {
		this.artisaneBean = artisaneBean;
	}

	private Item newItem;
	private Item editedItem ;
    private Item itemEnCours ;
    private Item itemPublie;
    private Item itemDeleted;
    private Item itemNonPublie;
    private UploadedFile uploadedFile;
    
    
   
    
    int index;
	
    
    private Part photo;
   
	
	public IArtisaneService getiArtisaneService() {
		return iArtisaneService;
	}

	public void setiArtisaneService(IArtisaneService iArtisaneService) {
		this.iArtisaneService = iArtisaneService;
	}

	public ICompteService getiCompteService() {
		return iCompteService;
	}

	public void setiCompteService(ICompteService iCompteService) {
		this.iCompteService = iCompteService;
	}

	public CompteEnCoursBean getCompteEnCoursBean() {
		return compteEnCoursBean;
	}

	public void setCompteEnCoursBean(CompteEnCoursBean compteEnCoursBean) {
		this.compteEnCoursBean = compteEnCoursBean;
	}
/*
	public Artisanes getArtisane() {
		return artisane;
	}

	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}
*/
	public Comptes getCompte() {
		return compte;
	}

	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	

	public List<Item> getListItemsArtisane() {
		listItemsArtisane = iItemService.getAllItemsArtisane(artisaneBean.getArtisaneEnCours());
		return listItemsArtisane;
	}

	public void setListItemsArtisane(List<Item> listItemsArtisane) {
		this.listItemsArtisane = listItemsArtisane;
	}

	public List<Item> getListItemsPublies() {
		listItemsPublies = iItemService.getAllItemsPublies(artisaneBean.getArtisaneEnCours());
		return listItemsPublies;
	}

	public void setListItemsPublies(List<Item> listItemsPublies) {
		this.listItemsPublies = listItemsPublies;
	}

	public List<Item> getListItemsNonPublies() {
		listItemsNonPublies =iItemService.getAllItemsNonPublies(artisaneBean.getArtisaneEnCours());
		return listItemsNonPublies;
	}

	public void setListItemsNonPublies(List<Item> listItemsNonPublies) {
		this.listItemsNonPublies = listItemsNonPublies;
	}

	public IShopService getiShopService() {
		return iShopService;
	}




	public void setiShopService(IShopService iShopService) {
		this.iShopService = iShopService;
	}
	


	public List<Item> getFilteredItems() {
		return filteredItems;
	}

	

	

	public void setFilteredItems(List<Item> filteredItems) {
		this.filteredItems = filteredItems;
	}

	

	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}

	public Item getEditedItem() {
		return editedItem;
	}

	public void setEditedItem(Item editedItem) {
		this.editedItem = editedItem;
	}

	public Item getItemEnCours() {
		return itemEnCours;
	}

	public void setItemEnCours(Item itemEnCours) {
		this.itemEnCours = itemEnCours;
	}

	public Item getItemPublie() {
		return itemPublie;
	}

	public void setItemPublie(Item itemPublie) {
		this.itemPublie = itemPublie;
	}

	public Item getItemNonPublie() {
		return itemNonPublie;
	}

	public void setItemNonPublie(Item itemNonPublie) {
		this.itemNonPublie = itemNonPublie;
	}

	public Item getItemDeleted() {
		return itemDeleted;
	}

	public void setItemDeleted(Item itemDeleted) {
		this.itemDeleted = itemDeleted;
	}

	/** Constant for number of comments to show in item details. */
    private static final int COMMENTS_NUMBER = 6;

    /** Item service remote ejb. */
    @ManagedProperty(value="#{iItemService}")
    private IItemService iItemService;

    /** Comment service remote ejb. */
    @ManagedProperty(value="#{iCommentService}")
    private ICommentService iCommentService;
    
    /**
     * Injected user bean used for getting current logged in user. Needed when
     * user post comment about item.
     */
    @ManagedProperty(value="#{userBean}")
    private UserBean userBean;

    /** Item id request parameter. Used to load selected item. */
   private Long itemId;
    
  

    /** Item to show it's details for the user. */
    private Item item;
    
    private Comment comment;

    

	public IItemService getiItemService() {
		return iItemService;
	}

	public void setiItemService(IItemService iItemService) {
		this.iItemService = iItemService;
	}

	public ICommentService getiCommentService() {
		return iCommentService;
	}

	public void setiCommentService(ICommentService iCommentService) {
		this.iCommentService = iCommentService;
	}

	
	public Item getItem() {
        return item;
    }

	
	public void setItem(Item item) {
		this.item = item;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
     * Is invoked on creation of this component.
     */
    
	
	public void init() {
    	   	
    	item = iItemService.getItemById((itemId));
        
    	
    	comment = new Comment();
        
         
   
	}

     
    /**
     * Getter of item details page comments.
     * 
     * @return Comments to show in item details page.
     */
    public List<Comment> getComments() {
        return iCommentService.getItemComments(item, 1, ItemAction.COMMENTS_NUMBER);
    }
    
    /**
     * Adding new comment to database.
     */
    public void addComment() {
    	comment = new Comment();
    	comment.setItem(item);
        comment.setUser(getCurrentLoggedInUser());
        comment.setCommentedOn(new Date());
        iCommentService.saveComment(comment);
      //  comment = new Comment();
    }
    
    public Comment getComment() {
    	return comment;
    }

    /**
     * Getter of item.
     * 
     * @return Item to show.
     */
    
  
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Users getCurrentLoggedInUser() {
        Users currentUser = userBean.getUser();
        return currentUser;
    }
	
	public void wasCommentValuable(Boolean wasValuable) {
        // TODO Auto-generated method stub
    }

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}


public Part getPhoto() {
		return photo;
	}

	public void setPhoto(Part photo) {
		this.photo = photo;
	}


	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	
	public void handleFileUpload(FileUploadEvent event) throws IOException {

		
		uploadedFile = event.getFile();
	    System.out.println(uploadedFile.getFileName());
	   
	    
	    byte[] foto = IOUtils.toByteArray(uploadedFile.getInputstream());
	    System.out.println(foto);
	    newItem.setImageProduit(foto);     
	   setUploadedFile(null);
	    
	   
	}
	
	
	
	

/****************************************************************************************/

	public void addItem() {
		
		newItem=new Item();
		//artisane=artisaneEnCoursBean.getArtisane();
		System.out.println(newItem);
		newItem.setArtisane(artisaneBean.getArtisaneEnCours());
		newItem.setShop(null);
		newItem.setImageSource(null);
		newItem.setActivated(false);
 	  System.out.println(newItem);
 	    System.out.println("New Item added, "+newItem );
 	}
    
     public void editItem(Item item) {
 		System.out.println(" Item updated");
 	    index = listItemsArtisane.indexOf(item);
 		System.out.println(index);
 		editedItem = item;	
 	}
 	
     public void checkItem(Item item) {
 		System.out.println(" Item a voir");
 		index = listItemsArtisane.indexOf(item);
 		itemEnCours = item;
 	
 	}
 	
     public void publishItem(Item item) {
 		System.out.println(" Item a publié");
 		index = listItemsNonPublies.indexOf(item);
 		itemPublie = item;
 		
 		System.out.println(itemPublie.getActivated());
 		
     }  
     
     public void NonpublishItem(Item item) {
  		System.out.println(" Item a publié");
  		index = listItemsPublies.indexOf(item);
  		itemNonPublie = item;;
  		
  		System.out.println(itemNonPublie.getActivated());
  		
      }  
     
     public void deleteItem(Item item) {
  		System.out.println(" Produit a supprimé");
  		index = listItemsArtisane.indexOf(item);
  		 itemDeleted = item;
  		}  
    
/*******************************************************************************************/

     public void ajoutItem() {
  	    /*
    	 try{
  		System.out.println("AAAAAAAAAAAAAAAAAA");
  		
  		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String prefix = Long.toString(timestamp.getTime());

        InputStream in = photo.getInputStream();

        File f = new File("E:/workspace-sts-3.3.0.RELEASE/E-Artisane/WebContent/sample-pictures/" + prefix + photo.getSubmittedFileName());
        f.createNewFile();
        FileOutputStream out = new FileOutputStream(f);

        byte[] buffer = new byte[1024];
        int length;

        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }

        out.close();
        in.close();

        InputStream in2 = photo2.getInputStream();
        File f2 = new File("C:/Users/Lamia/Documents/bidding-shop/web/uploads/"  + prefix + photo2.getSubmittedFileName());
        f2.createNewFile();
        FileOutputStream out2 = new FileOutputStream(f2);

        byte[] buffer2 = new byte[1024];
        int length2;

        while ((length2 = in2.read(buffer2)) > 0) {
            out2.write(buffer2, 0, length2);
        }
        out2.close();
        in2.close();
  		*/
  		iItemService.saveItem(newItem);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Item ajouté avec succés"));
        
        
        
      
         
     }

     public void modifierItem() {
		    try{
			System.out.println("EEEEEEEEEEEEEEEEEE");
			editedItem= iItemService.editerItem(editedItem);
			
			//setImagePhoto(null);
			listItemsArtisane.set(index, editedItem);
		    FacesContext context1 = FacesContext.getCurrentInstance();
	        context1.addMessage(null, new FacesMessage("Item modifié avec succés"));
	    
	    	   }catch(Exception e ){e.printStackTrace();}
	 }
     
     
     public void supprimerItem() {
  		
    	 try{
 			System.out.println("EEEEEEEEEEEEEEEEEE");
 			itemDeleted= iItemService.remove(itemDeleted);
 			//setImagePhoto(null);
 			listItemsArtisane.set(index, itemDeleted);
 		    FacesContext context1 = FacesContext.getCurrentInstance();
 	        context1.addMessage(null, new FacesMessage("Item supprimé avec succés"));
 	    //RequestContext.getCurrentInstance().reset("editD:display");
 	    	   }catch(Exception e ){e.printStackTrace();}
 		
 	    
 	}
     
     
     /*
     public void publie_nonPublie_item(){
		 
		 if (itemPublie.getActivated()==true) {

				System.out.println("DEDEDEDEDEDEDEDEDE");
			
				iItemService.desactiverItem(itemPublie);
			    FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage("Non publication du produit réussie"));
		    
		 }
		        else {
		        	System.out.println("ACACACACACACACACACAC");  	
		        	iItemService.activerItem(itemPublie);       
				    FacesContext context = FacesContext.getCurrentInstance();
			        context.addMessage(null, new FacesMessage("publication du item réussie"));
			    
		 
		 
		 }
		    	  
	 }  
    */
     
       public void disableItem(){
		 
			System.out.println("DEDEDEDEDEDEDEDEDE");
			
				iItemService.desactiverItem(itemNonPublie);
			    FacesContext context = FacesContext.getCurrentInstance();
			    context.addMessage(null, new FacesMessage("Non publication du item réussie"));
		 
			    System.out.println("Suppresion du produit de l'ontologie:");
		        PropertiesLoader.setConfigFile(CONFIG_FILE);  
		        System.out.println("Donner l'id du produit : ");
		    	long prod_id = itemNonPublie.getId();
		    	System.out.println("prod_id ="+prod_id);
		
		    	iItemService.supprimerItemOntologie(prod_id);
		    	System.out.println("Produit supprimé avec succes de l'ontologie"); 
		 
		 }
		    	  
       public void enableItem(){
       	System.out.println("ACACACACACACACACACAC");  	
       	iItemService.activerItem(itemPublie);       
		    FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("publication du item réussie"));
	    
	        System.out.println("Insertion du produit dans l'ontologie:");
	        PropertiesLoader.setConfigFile(CONFIG_FILE);  
	        System.out.println("Donner l'id du produit : ");
	    	long prod_id = itemPublie.getId();
	    	System.out.println("prod_id ="+prod_id);
	    	System.out.println("Donner l'id du shop : ");
	    	long shop_id = itemPublie.getShop().getId();
	    	System.out.println("shop_id ="+shop_id);
	    	System.out.println("Donner l'id de la tendance : ");
	    	long tendance_id = itemPublie.getTendance().getId() ;
	    	System.out.println("tendance_id="+tendance_id);
	    	System.out.println("Donner l'id de la couleur : ");
	    	long couleur_id = itemPublie.getCouleur().getId();
	    	System.out.println("couleur_id ="+couleur_id );
	    	
	    	iItemService.ajouterItemOntologie(prod_id, shop_id, tendance_id, couleur_id);
	    	System.out.println("Produit ajouté avec succes a l'ontologie"); 
	        
	        
       
       }
       
       
     public void reset() {  
	        RequestContext.getCurrentInstance().reset("FormCreationProduit:editP:display");  
	    } 
}
