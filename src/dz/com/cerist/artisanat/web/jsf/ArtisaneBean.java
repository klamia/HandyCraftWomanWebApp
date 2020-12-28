package dz.com.cerist.artisanat.web.jsf;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;


import ro.tuc.dsrl.m2o.utility.PropertiesLoader;





import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Comptes;
import dz.com.cerist.artisanat.entite.Item;
import dz.com.cerist.artisanat.entite.Order;
import dz.com.cerist.artisanat.entite.OrderStatusEnum;




import dz.com.cerist.artisanat.service.IArtisaneService;
import dz.com.cerist.artisanat.service.ICompteService;
import dz.com.cerist.artisanat.service.IItemService;
import dz.com.cerist.artisanat.service.IOrderService;






@ManagedBean(name = "artisaneBean")
@SessionScoped
public class ArtisaneBean implements Serializable {

	
	
	
   
	//private static PropertiesLoader prop;
    private static String CONFIG_FILE = "/artisanat-config.config";
    
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3256063428327604106L;
	
	// Getter and Setter

	@ManagedProperty(name="iArtisaneService", value="#{iArtisaneService}")
	private IArtisaneService iArtisaneService;
	
	
	@ManagedProperty(name="iCompteService", value="#{iCompteService}")
	private ICompteService iCompteService;
	
	@ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;
	
	@ManagedProperty(value="#{iItemService}")
    private IItemService iItemService;
	
	/*
	@ManagedProperty(name="iProduitService", value="#{iProduitService}")
	private IProduitService iProduitService;
	*/
	/*@ManagedProperty(value ="#{artisaneBeanartisane}")*/
    private Artisanes artisane;
    
    
    private Comptes compte;
    
    @ManagedProperty(value ="#{artisaneBeanartisaneEnCours}")
    private Artisanes artisaneEnCours;
    private Item item;
    
    private UploadedFile uploadedFile2 ;
    private DefaultStreamedContent imagePhoto;
    //  private Produits produit;
   // private List<Produits> listproduitsArtisane ;
   // private UploadedFile uploadedFile;
    
    private List<Item> listItemsArtisane ;
    private Item editedItem ;
    private Item itemEnCours ;
    private Item itemPublie;
    private Item itemDeleted;
	
    private List<Order> allcurrentOrders;
    private List<Order> alldeliveredOrders;
    private List<Order> allsentOrders;
    private List<Order> allonTheWayOrders;
  
    
    private Order currentOrder;
    private Order editedOrder;
    
    private Long id;
	
    @ManagedProperty(value="#{iOrderService}")
    private IOrderService iOrderService;
    
    public ArtisaneBean() {
		
	}
    
    
    
    public Comptes getCompte() {
		return compte;
	}
	public void setCompte(Comptes compte) {
		this.compte = compte;
	}
	
	public IArtisaneService getiArtisaneService() {
		return iArtisaneService;
	}
	public void setiArtisaneService(IArtisaneService iArtisaneService) {
		this.iArtisaneService = iArtisaneService;
	}
	public Artisanes getArtisane() {
		return artisane;
	}
	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}
	
	/*
	public Artisanes getArtisaneEnCours() {
		return artisaneEnCours;
	}
	public void setArtisaneEnCours(Artisanes artisaneEnCours) {
		this.artisaneEnCours = artisaneEnCours;
	}
	
	*/
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	public IProduitService getiProduitService() {
		return iProduitService;
	}
	public void setiProduitService(IProduitService iProduitService) {
		this.iProduitService = iProduitService;
	}
	public Produits getProduit() {
		return produit;
	}
	public void setProduit(Produits produit) {
		this.produit = produit;
	}
	public List<Produits> getListproduitsArtisane() {
		listproduitsArtisane = iProduitService.getAllProduitsArtisane(artisaneEnCours);
		return listproduitsArtisane;
	}
	public void setListproduitsArtisane(List<Produits> listproduitsArtisane) {
		this.listproduitsArtisane = listproduitsArtisane;
	}



	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

     */

	public IItemService getiItemService() {
		return iItemService;
	}
	public void setiItemService(IItemService iItemService) {
		this.iItemService = iItemService;
	}
	public Artisanes getArtisaneEnCours() {
		return artisaneEnCours;
	}
	public void setArtisaneEnCours(Artisanes artisaneEnCours) {
		this.artisaneEnCours = artisaneEnCours;
	}
	public List<Item> getListItemsArtisane() {
		listItemsArtisane = iItemService.getAllItemsArtisane(artisaneEnCours);
		return listItemsArtisane;
	}
	public void setListItemsArtisane(List<Item> listItemsArtisane) {
		this.listItemsArtisane = listItemsArtisane;
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
	public Item getItemDeleted() {
		return itemDeleted;
	}
	public void setItemDeleted(Item itemDeleted) {
		this.itemDeleted = itemDeleted;
	}

	
	int index, index1, index2, index3;
	
	public List<Order> getAllcurrentOrders() {
		allcurrentOrders = iOrderService.getAllWaitingOrders(artisaneEnCours);
		return allcurrentOrders;
	}




	public void setAllcurrentOrders(List<Order> allcurrentOrders) {
		this.allcurrentOrders = allcurrentOrders;
	}

 


	public List<Order> getAlldeliveredOrders() {
		alldeliveredOrders = iOrderService.getAllDeliveredOrders(artisaneEnCours);
		return alldeliveredOrders;
	}






	public void setAlldeliveredOrders(List<Order> alldeliveredOrders) {
		this.alldeliveredOrders = alldeliveredOrders;
	}






	public List<Order> getAllsentOrders() {
		allsentOrders = iOrderService.getAllSentOrders(artisaneEnCours);
		return allsentOrders;
	}






	public void setAllsentOrders(List<Order> allsentOrders) {
		this.allsentOrders = allsentOrders;
	}






	public List<Order> getAllonTheWayOrders() {
		allonTheWayOrders = iOrderService.getAllOnTheWayOrders(artisaneEnCours);
		return allonTheWayOrders;
	}






	public void setAllonTheWayOrders(List<Order> allonTheWayOrders) {
		this.allonTheWayOrders = allonTheWayOrders;
	}





	
	
	//operations métiers
	
	
	
	public UploadedFile getUploadedFile2() {
		return uploadedFile2;
	}
	public void setUploadedFile2(UploadedFile uploadedFile2) {
		this.uploadedFile2 = uploadedFile2;
	}
	public DefaultStreamedContent getImagePhoto() {
		return imagePhoto;
	}
	public void setImagePhoto(DefaultStreamedContent imagePhoto) {
		this.imagePhoto = imagePhoto;
	}
	public IOrderService getiOrderService() {
		return iOrderService;
	}
	public void setiOrderService(IOrderService iOrderService) {
		this.iOrderService = iOrderService;
	}
	
	public Order getCurrentOrder() {
		return currentOrder;
	}
	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	public Order getEditedOrder() {
		return editedOrder;
	}
	public void setEditedOrder(Order editedOrder) {
		this.editedOrder = editedOrder;
	}
	
	

	
	
	@PostConstruct
    public void init() {
		System.out.println("Début de la fonction init");
		artisane=new Artisanes();
		String username=compteEnCoursBean.getUsername();
        System.out.println(username);
        compte = iCompteService.getCompteByLogin(username);
        System.out.println(compte);
       
        artisane.setCompte(compte);
        System.out.println(artisane);
       
       artisaneEnCours=compte.getArtisane();
        System.out.println("artisaneEnCours"+artisaneEnCours);
        System.out.println("Fin de la fonction init");
	}

	public String inscription() {
	   
		
		try{
		System.out.println("AAAAAAAAAAAAAAAAAA");
		
		iArtisaneService.ajouterProfil(artisane);
		compte.setArtisane(artisane);
		iCompteService.editerCompte(compte);
		System.out.println(compte);
		
		PropertiesLoader.setConfigFile(CONFIG_FILE);
		System.out.println("Get l'id de l'artisane : ");
		long ar_id = artisane.getId();
		System.out.println("ar_id ="+ ar_id);
		System.out.println("Get l'id de la wilaya : ");
		long w_id = artisane.getWilaya().getId();
		System.out.println("w_id ="+w_id);
		System.out.println("Get l'id du domaine d'activité : ");
		long d_id = artisane.getActivite().getId();
		System.out.println("d_id = "+d_id );
		iArtisaneService.ajouterArtisaneOntologie(ar_id, w_id, d_id);
		System.out.println("Artisane ajoutée à l'ontologie avec succés");
		
		
		
		
		
		
		/*artisaneEnCoursBean.setId(artisane.getId());
		System.out.println(artisaneEnCoursBean);*/
		
		return "/login.xhtml";
		
	    }catch(Exception e ){e.printStackTrace();  return null;}
	
	    
	
	
	
	}

	
	
	/*
	public void handleFileUpload(FileUploadEvent event) throws IOException {

		
		uploadedFile = event.getFile();
	    System.out.println(uploadedFile.getFileName());
	   
	    
	    byte[] foto = IOUtils.toByteArray(uploadedFile.getInputstream());
	    System.out.println(foto);
	    produit.setImageProduit(foto);
	   
	    
	   setUploadedFile(null);
	    
	   
	}
	*/
	
	
	/*
	public void addProduitArtisane() {
		produit=new Produits();
	    produit.setArtisane(artisaneEnCours);
	    produit.setEtat("non publié");
	    System.out.println("New Produit added, "+produit );
	}


	public void ajoutProduit() {
	    try{
		System.out.println("AAAAAAAAAAAAAAAAAA");
		iProduitService.ajouterProduit(produit);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Produit ajouté avec succés"));
        //RequestContext.getCurrentInstance().reset(":FormCreationCompte:editC:display");
    	   }catch(Exception e ){e.printStackTrace();}
		
        }
	
	
	 
	 public void reset() {  
	        RequestContext.getCurrentInstance().reset(":FormCreationProduit:editP:display");  
	    } 

	*/
	
	/****************************************************************************************/

	public void addItem() {
 	   item=new Item();
 	   item.setArtisane(artisaneEnCours);
 	 //  produit.setEtat("Non Publie");
 	    System.out.println("New Item added, "+item );
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
 		index = listItemsArtisane.indexOf(item);
 		itemPublie = item;
 		System.out.println(itemPublie.getActivated());
 		}  
     
     public void deleteItem(Item item) {
  		System.out.println(" Produit a supprimé");
  		index = listItemsArtisane.indexOf(item);
  		 itemDeleted = item;
  		}  
     

     public void handleFileUploadSecond(FileUploadEvent event) throws IOException {

  	    
      	  // setImagePhoto(null);
   			uploadedFile2 = event.getFile();
   		    System.out.println(uploadedFile2.getFileName());
   		 
   		    
   		    byte[] foto2 = IOUtils.toByteArray(uploadedFile2.getInputstream());
   		    System.out.println(foto2);
   		    
   		    editedItem.setImageProduit(foto2);
   		   
   		    ByteArrayInputStream img = new ByteArrayInputStream(foto2);
   		    setImagePhoto(new DefaultStreamedContent(img,"image/png, jpg, jpeg, gif"));
   		   
   		  
   		    setUploadedFile2(null);
   		    
   		  System.out.println(foto2);
   		}
    
     
     
     /*******************************************************************************************/
     public void ajoutItem() {
   	    try{
   		System.out.println("AAAAAAAAAAAAAAAAAA");
   		iItemService.saveItem(item);
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage("Item ajouté avec succés"));
           //RequestContext.getCurrentInstance().reset(":FormCreationCompte:editC:display");
       	   }catch(Exception e ){e.printStackTrace();}
   		
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
      
      
      
      public void publie_nonPublie_item(){
 		 
 		 if (itemPublie.getActivated()==true) {

 				System.out.println("DEDEDEDEDEDEDEDEDE");
 				iItemService.desactiverItem(itemPublie);
 			    FacesContext context = FacesContext.getCurrentInstance();
 		        context.addMessage(null, new FacesMessage("Non publication du item réussie"));
 		    
 		 }
 		        else {
 		        	System.out.println("ACACACACACACACACACAC");
 		        	iItemService.activerItem(itemPublie);       
 				
 				    FacesContext context = FacesContext.getCurrentInstance();
 			        context.addMessage(null, new FacesMessage("publication du item réussie"));
 			    
 		 
 		 
 		 }
 		    	  
 	 }  
      
/****************************************************************************************************/
      public void checkOrder(Order order) {
   		System.out.println(" Commande a voir");
   		index1 = allsentOrders.indexOf(order);
   		currentOrder = order;
   	}
   	
      public void editSentOrder(Order order) {
     		System.out.println(" Commande a modifier etat");
     		index1 = allsentOrders.indexOf(order);
     		editedOrder = order;
     	}
	
      public void editCurrentOrder(Order order) {
   		System.out.println(" Commande a modifier etat");
   		index2 = allcurrentOrders.indexOf(order);
   		editedOrder = order;
   	}
      
      public void editOnTheWayOrder(Order order) {
     		System.out.println(" Commande a modifier etat");
     		index3 = allonTheWayOrders.indexOf(order);
     		editedOrder = order;
     	} 
      public void modifierEtatOrder() {
    	  OrderStatusEnum status = editedOrder.getStatus();
    	  switch(status){
    	  case SENT :
    	  editedOrder.setStatus(OrderStatusEnum.PROCESSING);
    	  editedOrder.setAcceptedOn(new Date());
    	  editedOrder=iOrderService.editerOrder(editedOrder);
    	  allsentOrders.set(index1, editedOrder);
    	  FacesContext context1 = FacesContext.getCurrentInstance();
	        context1.addMessage(null, new FacesMessage("Commande en cours de traitement"));
	      break;
    	  
    	  case PROCESSING :
    		  editedOrder.setStatus(OrderStatusEnum.ON_THE_WAY);
        	  editedOrder=iOrderService.editerOrder(editedOrder);
        	  allcurrentOrders.set(index2, editedOrder);
        	  FacesContext context2 = FacesContext.getCurrentInstance();
    	        context2.addMessage(null, new FacesMessage("Commande en cours de livraison"));
    	      break;
    	  
    	  case ON_THE_WAY :
    		  editedOrder.setStatus(OrderStatusEnum.DELIVERED);
        	  editedOrder.setDeliveredOn(new Date());
        	  editedOrder=iOrderService.editerOrder(editedOrder);
        	  allonTheWayOrders.set(index3, editedOrder);
        	  FacesContext context3 = FacesContext.getCurrentInstance();
    	        context3.addMessage(null, new FacesMessage("Commande livrée "));
    	      break;
			  
    	  default: 
			break;
    	  
    	  }


      }
      
      
      
      public void annulerCommande() { 
    	  
    	  editedOrder.setStatus(OrderStatusEnum.CANCELED);
    	  editedOrder=iOrderService.editerOrder(editedOrder);
    	  allsentOrders.set(index1, editedOrder);
    	  FacesContext context1 = FacesContext.getCurrentInstance();
	        context1.addMessage(null, new FacesMessage("Commande Annulée"));
      }
      
}