package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;

import java.util.List;




import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import ro.tuc.dsrl.m2o.utility.PropertiesLoader;
import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Item;

import dz.com.cerist.artisanat.entite.Shop;
import dz.com.cerist.artisanat.service.IItemService;
import dz.com.cerist.artisanat.service.IShopService;

@ManagedBean(name = "shopActionBean")
@RequestScoped
public class ShopActionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7308385369473288211L;

	@ManagedProperty(name="artisaneBean", value="#{artisaneBean}")
	private ArtisaneBean artisaneBean;
	
	@ManagedProperty(name="clientBean", value="#{clientBean}")
	private ClientBean clientBean;
	
	
	@ManagedProperty(value="#{iItemService}")
    private IItemService iItemService;

	@ManagedProperty(name="iShopService", value="#{iShopService}")
    private IShopService iShopService;

    private Shop shop;
    
    private Shop newShop;
    private Shop editedShop;
	private Shop shopDeleted;
	private Shop shopEnCours;
	
	//private Item item=new Item();
	
	
	
	
	private Long shopId;
	
	int index;
	
	private List<Item> listItemsShop;
	
	private List<Item> listShopProducts;
	
	@ManagedProperty(value ="#{shopActionBeanlistShopsArtisane}")
	private List<Shop> listShopsArtisane ;
	
	private Artisanes artisane;
	
	private static String CONFIG_FILE = "/artisanat-config.config";
	
	
	
	
	
	public void init() {
    	
		
        shop = iShopService.getShopbyId(shopId);
    	System.out.println(shopId);
    	
	}

	
	


	


	public Artisanes getArtisane() {
		return artisane;
	}



	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}



	public Shop getNewShop() {
		return newShop;
	}



	public void setNewShop(Shop newShop) {
		this.newShop = newShop;
	}




	public Shop getEditedShop() {
		return editedShop;
	}



	public void setEditedShop(Shop editedShop) {
		this.editedShop = editedShop;
	}



	public Shop getShopDeleted() {
		return shopDeleted;
	}



	public void setShopDeleted(Shop shopDeleted) {
		this.shopDeleted = shopDeleted;
	}



	public Shop getShopEnCours() {
		return shopEnCours;
	}



	public void setShopEnCours(Shop shopEnCours) {
		this.shopEnCours = shopEnCours;
	}



	public ArtisaneBean getArtisaneBean() {
		return artisaneBean;
	}



	public void setArtisaneBean(ArtisaneBean artisaneBean) {
		this.artisaneBean = artisaneBean;
	}


     
	public ClientBean getClientBean() {
		return clientBean;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}



	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	
	
	public List<Item> getListItemsShop() {
		listItemsShop =iItemService.getAllItemsShop(shop);
		return listItemsShop;
	}

	public void setListItemsShop(List<Item> listItemsShop) {
		this.listItemsShop = listItemsShop;
	}

	
	
	public List<Shop> getListShopsArtisane() {
		listShopsArtisane=iShopService.getAllShopsArtisane(artisaneBean.getArtisaneEnCours());
		return listShopsArtisane;
	}



	public void setListShopsArtisane(List<Shop> listShopsArtisane) {
		this.listShopsArtisane = listShopsArtisane;
	}



	public IItemService getiItemService() {
		return iItemService;
	}

	public void setiItemService(IItemService iItemService) {
		this.iItemService = iItemService;
	}

	public IShopService getiShopService() {
		return iShopService;
	}

	public void setiShopService(IShopService iShopService) {
		this.iShopService = iShopService;
	}

	
	
    





/*******************************************************************************************/
     public void addShop() {
		
		newShop=new Shop();
		
		System.out.println(newShop);
		newShop.setArtisane(artisaneBean.getArtisaneEnCours());
		newShop.setImageSource(null);
 	  System.out.println(newShop);
 	    System.out.println("New Shop added, "+newShop );
 	}
    
     public void editShop(Shop shop) {
 		System.out.println(" Shop updated");
 	  index = listShopsArtisane.indexOf(shop);
 		System.out.println(index);
 		editedShop = shop;	
 	}
 	
	
     public void deleteShop(Shop shop) {
   		System.out.println(" Shop a supprimé");
   		index = listShopsArtisane.indexOf(shop);
   		System.out.println(index);
   		shopDeleted = shop;
   		}  
	

     public void checkShopInfo(Shop shop) {
  		System.out.println(" Shop a voir");
  		index = listShopsArtisane.indexOf(shop);
  		shopEnCours = shop;
  	
  	}
     
     
     public void checkShopItems(Shop shop) {
   		System.out.println(" Shop a voir produits");
   		index = listShopsArtisane.indexOf(shop);
   		shopEnCours = shop;
   	
   	}
     
     
     /*******************************************************************************************/

     public void ajoutShop() {
  	    
  		iShopService.ajouterShop(newShop);
          FacesContext context = FacesContext.getCurrentInstance();
          context.addMessage(null, new FacesMessage("Shop ajouté avec succés"));
          //RequestContext.getCurrentInstance().reset(":FormCreationCompte:editC:display");
      	  /* }catch(Exception e ){e.printStackTrace();}*/
  		
        PropertiesLoader.setConfigFile(CONFIG_FILE);
     	System.out.println("get id du shop : ");
     	long id_shop = newShop.getId();
      	System.out.println("id_shop ="+id_shop);
      	
      	System.out.println("Get id de l'artisane : ");
      	long id_artisane = newShop.getArtisane().getId();
      	System.out.println("id_artisane ="+id_artisane);
      	
      	System.out.println("Get id de la wilaya : ");
      	long id_wilaya = newShop.getWilaya().getId();
      	System.out.println("id_wilaya ="+id_wilaya);
  		iShopService.ajouterShopOntologie(id_shop, id_artisane, id_wilaya); 
  		
  		System.out.println("Shop ajouté à l'ontologie avec succés"); 
          
     }

     public void modifierShop() {
		    try{
			System.out.println("EEEEEEEEEEEEEEEEEE");
			editedShop= iShopService.editerShop(editedShop);
			//setImagePhoto(null);
			listShopsArtisane.set(index, editedShop);
		    FacesContext context1 = FacesContext.getCurrentInstance();
	        context1.addMessage(null, new FacesMessage("Shop modifié avec succés"));
	    
	    	   }catch(Exception e ){e.printStackTrace();}
	 }
     
     
     public void supprimerShop() {
  		
    	 try{
 			System.out.println("EEEEEEEEEEEEEEEEEE");
 			shopDeleted= iShopService.remove(shopDeleted);
 			listShopsArtisane.set(index, shopDeleted);
 		    FacesContext context1 = FacesContext.getCurrentInstance();
 	        context1.addMessage(null, new FacesMessage("Shop supprimé avec succés"));
 	    //RequestContext.getCurrentInstance().reset("editD:display");
 	    	   }catch(Exception e ){e.printStackTrace();}
 		
 	    
 	}
     
     
     
     public List<Item> voirProduitsShop (Shop shop){
    	 
    	 listShopProducts=iItemService.getAllItemsShop(shop); 
    	 return listShopProducts;
     }
     
     
     
     
     public List<Item> getListShopProducts() {
 		
    	 return listShopProducts;
 	}


 	public void setListShopProducts(List<Item> listShopProducts) {
 		this.listShopProducts = listShopProducts;
 	}
     
     
    
    	 
    
     
     
     /*
     public void ProdRecommandation() {       

    	 PropertiesLoader.setConfigFile(CONFIG_FILE);
     	instance = JenaUtility.getInstance();
     	model = (OntModel) instance.getDataModel();
     	
     	
     	//Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
     	Reasoner reasoner = PelletReasonerFactory.theInstance().create();
     	//InfModel inf = ModelFactory.createRDFSModel(model);
     	InfModel inf = ModelFactory.createInfModel(reasoner, model);
     	
     	//Vérifier la validité du modèle inféré	 
     	/*ValidityReport validity = inf.validate();
     	if (validity.isValid()) {
     	    System.out.println("\nOK");
     	} else {
     	    System.out.println("\nConflicts");
     	    for (Iterator i = validity.getReports(); i.hasNext(); ) {
     	        ValidityReport.Report report = (ValidityReport.Report)i.next();
     	        System.out.println(" - " + report);
     	    }
     	}
     	
     	System.out.println("Donner l'id du client: ");
     	long cl_id = clientBean.getClientEnCours().getId();
    	System.out.println("cl_id ="+cl_id);
     	
     	System.out.println("Donner l'id du Shop: ");
     	long sh_id = shop.getId();
     	System.out.println("sh_id ="+sh_id);
     	
     	Resource cl = inf.getResource(NAMESPACE+"Client_"+cl_id);
     	Resource sh = inf.getResource(NAMESPACE+"Shops_"+sh_id);
     	//Resource prod = inf.getResource(NAMESPACE+"Produit_"+cl_id);
     	
     	Recommand_prod recommand = new Recommand_prod();
     	//vecRecProd = recommand.prodShop(inf, sh);
     	//recommand.recommand(sh_id, model);
     	
     	System.out.println("\nLa liste des produits à recommander selon les preferences du client :");
     	vecRecProd = recommand.recommandProd(inf, cl,sh);
     	//System.out.println(vecRecProd.size());
     	recommand.printRec(vecRecProd);
     	for(int i = 0 ; i < vecRecProd.size(); i++)
    	{
			
     		prod = iItemService.getItemById((Long) vecRecProd.get(i));
			System.out.println("prod"+prod.getId());
			firstLevelItems.add(prod);
			
    	}
    	
    	System.out.println("firstLevelItems="+firstLevelItems);
     	
     	
     	
     	
     	System.out.println("\nLe reste des produits à recommander :");
        vecProdShop = recommand.prodShop(inf, sh);
     	vecRest = recommand.recommandRest(vecProdShop, vecRecProd);
     	recommand.printRec(vecRest);
     	for(int j = 0 ; j < vecRest.size(); j++)
    	{
			
     		prod = iItemService.getItemById((Long) vecRest.get(j));
			System.out.println("prod"+prod);
			secondLevelItems.add(prod);
			
    	}
    	
    	System.out.println("secondLevelItems="+secondLevelItems);
     
     
     
     
     }      
     
     */
     
     

     
     
    
    








	public void reset() {  
	        RequestContext.getCurrentInstance().reset("FormCreationShop:editS:display");  
	    } 

	


	




}
