package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.SessionScoped;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import ro.tuc.dsrl.m2o.ontology.utility.JenaUtility;
import ro.tuc.dsrl.m2o.utility.PropertiesLoader;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.reasoner.Reasoner;

import dz.com.cerist.artisanat.commons.utils.Recommand_prod;
import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Comptes;
import dz.com.cerist.artisanat.entite.Item;
import dz.com.cerist.artisanat.entite.Shop;
import dz.com.cerist.artisanat.service.ICompteService;
import dz.com.cerist.artisanat.service.IItemService;
import dz.com.cerist.artisanat.service.IShopService;




@ManagedBean(name = "prodRecommendBean")
@SessionScoped
public class ProdRecommendBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9136838211912910808L;

	
	@ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;
	
	@ManagedProperty(value="#{iItemService}")
    private IItemService iItemService;

	@ManagedProperty(name="iShopService", value="#{iShopService}")
    private IShopService iShopService;

	private Item prod;
	private  List<Item> firstLevelItems = new ArrayList<Item>();
	private  List<Item> secondLevelItems = new ArrayList<Item>();
//	private List<Item> listItemsShop;
	
	private Shop shop;
	
	private Long shopId;
	
	private Comptes compte;
	
	private Clients client;
	
	
	
	@ManagedProperty(name="iCompteService", value="#{iCompteService}")
	private ICompteService iCompteService;
	
	private static String CONFIG_FILE = "/artisanat-config.config";
	private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	private static JenaUtility instance;
	private static OntModel model;
	@SuppressWarnings("unused")
	private static Model m;
	
	@SuppressWarnings("rawtypes")
	private static ArrayList vecRecProd = new ArrayList();
	@SuppressWarnings("rawtypes")
	private static ArrayList vecProdShop = new ArrayList();
	@SuppressWarnings("rawtypes")
	private static ArrayList vecRest = new ArrayList(); 
	
	private boolean affichage=false;
	
	
	
	public void init() {
    	
		
        shop = iShopService.getShopbyId(shopId);
    	System.out.println("shop id is :"+shopId);
    
    	
    	String username=compteEnCoursBean.getUsername();
        System.out.println("Username is :"+username);
        compte = iCompteService.getCompteByLogin(username);
        System.out.println("Compte is :"+compte.getRole().getIntitulerole());
        client=compte.getClient();
    	 System.out.println("ClientEnCours is :"+client.getPrenom());
   
    	 
    	 
    	 
    	 if (client != null )
    	 
    		 ProdRecommandation();
    		    	
	
	}
	
	
	
	
	public void ProdRecommandation() {       

   	 PropertiesLoader.setConfigFile(CONFIG_FILE);
    	instance = JenaUtility.getInstance();
    	model = (OntModel) instance.getDataModel();
    	

    	 vecRecProd = new ArrayList();
   	     vecProdShop = new ArrayList();
   	     vecRest = new ArrayList(); 
    	
   	     firstLevelItems = new ArrayList<Item>();
   	     secondLevelItems = new ArrayList<Item>();
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
    	}*/
    	
    	System.out.println("Donner l'id du client: ");
    	long cl_id = client.getId();
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


	public Item getProd() {
		return prod;
	}


	public void setProd(Item prod) {
		this.prod = prod;
	}


	public List<Item> getFirstLevelItems() {
		return firstLevelItems;
	}


	public void setFirstLevelItems(List<Item> firstLevelItems) {
		this.firstLevelItems = firstLevelItems;
	}


	public List<Item> getSecondLevelItems() {
		return secondLevelItems;
	}


	public void setSecondLevelItems(List<Item> secondLevelItems) {
		this.secondLevelItems = secondLevelItems;
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


	@SuppressWarnings("rawtypes")
	public static ArrayList getVecRecProd() {
		return vecRecProd;
	}


	@SuppressWarnings("rawtypes")
	public static void setVecRecProd(ArrayList vecRecProd) {
		ProdRecommendBean.vecRecProd = vecRecProd;
	}


	@SuppressWarnings("rawtypes")
	public static ArrayList getVecProdShop() {
		return vecProdShop;
	}


	public static void setVecProdShop(@SuppressWarnings("rawtypes") ArrayList vecProdShop) {
		ProdRecommendBean.vecProdShop = vecProdShop;
	}


	@SuppressWarnings("rawtypes")
	public static ArrayList getVecRest() {
		return vecRest;
	}


	public static void setVecRest(@SuppressWarnings("rawtypes") ArrayList vecRest) {
		ProdRecommendBean.vecRest = vecRest;
	}


	public CompteEnCoursBean getCompteEnCoursBean() {
		return compteEnCoursBean;
	}


	public void setCompteEnCoursBean(CompteEnCoursBean compteEnCoursBean) {
		this.compteEnCoursBean = compteEnCoursBean;
	}


	public Comptes getCompte() {
		return compte;
	}


	public void setCompte(Comptes compte) {
		this.compte = compte;
	}


	public ICompteService getiCompteService() {
		return iCompteService;
	}


	public void setiCompteService(ICompteService iCompteService) {
		this.iCompteService = iCompteService;
	}


	public Clients getClient() {
		return client;
	}


	public void setClient(Clients client) {
		this.client= client;
	}

/*
	public List<Item> getListItemsShop() {
		listItemsShop =iItemService.getAllItemsShop(shop);
		return listItemsShop;
	}


	public void setListItemsShop(List<Item> listItemsShop) {
		this.listItemsShop = listItemsShop;
	}

*/
	
	
    
	
	
	
}
