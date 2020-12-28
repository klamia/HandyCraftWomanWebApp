package dz.com.cerist.artisanat.web.jsf;






import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;




import org.mindswap.pellet.jena.PelletReasonerFactory;

import ro.tuc.dsrl.m2o.ontology.utility.JenaUtility;


import ro.tuc.dsrl.m2o.utility.PropertiesLoader;


import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ValidityReport;










import dz.com.cerist.artisanat.commons.utils.Recommand;


import dz.com.cerist.artisanat.entite.Clients;
import dz.com.cerist.artisanat.entite.Comptes;
import dz.com.cerist.artisanat.entite.Shop;
import dz.com.cerist.artisanat.service.CrudService;
import dz.com.cerist.artisanat.service.IClientService;
import dz.com.cerist.artisanat.service.ICompteService;
import dz.com.cerist.artisanat.service.IShopService;



@ManagedBean(name = "clientBean")
@RequestScoped
public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5901446831723748584L;

	@ManagedProperty(name="iClientService", value="#{iClientService}")
	private IClientService iClientService;
	
	
	@ManagedProperty(name="iCompteService", value="#{iCompteService}")
	private ICompteService iCompteService;
	
	@ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;
	
	@ManagedProperty(name="iShopService", value="#{iShopService}")
	private IShopService iShopService;
	
	@ManagedProperty(name="crudService", value="#{crudService}")
	private CrudService crudService;
	
	private Clients client;
	
    private Shop shop=new Shop();
	private Comptes compte;
    
    private  List<Shop> firstLevelShops = new ArrayList<Shop>();
	private  List<Shop> secondLevelShops = new ArrayList<Shop>();
	private  List<Shop> thirdLevelShops = new ArrayList<Shop>();
    
	 
	
    
    private Clients clientEnCours;
    
 
    
	public CrudService getCrudService() {
		return crudService;
	}
	public void setCrudService(CrudService crudService) {
		this.crudService = crudService;
	}
	
	public IShopService getiShopService() {
		return iShopService;
	}
	public void setiShopService(IShopService iShopService) {
		this.iShopService = iShopService;
	}

	 /* variable de recommandation */
	
	//private static PropertiesLoader prop;
    private static String CONFIG_FILE = "/artisanat-config.config";
    private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	private static JenaUtility instance;
	private static OntModel model;
	@SuppressWarnings("unused")
	private static Model m;
	@SuppressWarnings("rawtypes")
	private static ArrayList vecDomaine = new ArrayList(); 
	@SuppressWarnings({ "rawtypes", "unused" })
	private static ArrayList vecWilaya = new ArrayList();
	@SuppressWarnings("rawtypes")
	private static ArrayList vecLocalisation = new ArrayList();
	@SuppressWarnings("rawtypes")
	private static ArrayList vecLocalisationProche = new ArrayList();
	@SuppressWarnings("rawtypes")
	private static ArrayList vecRec1 = new ArrayList(); 
	@SuppressWarnings("rawtypes")
	private static ArrayList vecRec2 = new ArrayList();
	@SuppressWarnings("rawtypes")
	private static ArrayList vecRec3 = new ArrayList();
    
	
	
	int index;
    
    public ClientBean() {
		
	}
	public IClientService getiClientService() {
		return iClientService;
	}
	public void setiClientService(IClientService iClientService) {
		this.iClientService = iClientService;
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
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	public Comptes getCompte() {
		return compte;
	}
	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	public Clients getClientEnCours() {
		return clientEnCours;
	}
	public void setClientEnCours(Clients clientEnCours) {
		this.clientEnCours = clientEnCours;
	}
	
    
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	
	
	public List<Shop> getFirstLevelShops() {
		
    	
		
		return firstLevelShops;
	}

	public void setFirstLevelShops(List<Shop> firstLevelShops) {
		this.firstLevelShops = firstLevelShops;
	}

	public List<Shop> getSecondLevelShops() {
		
		return secondLevelShops;
	}

	public void setSecondLevelShops(List<Shop> secondLevelShops) {
		this.secondLevelShops = secondLevelShops;
	}

	public List<Shop> getThirdLevelShops() {
		
		return thirdLevelShops;
	}

	public void setThirdLevelShops(List<Shop> thirdLevelShops) {
		this.thirdLevelShops = thirdLevelShops;
	}

	
	
	
	@PostConstruct
    public void init() {
        
		client=new Clients();
		String username=compteEnCoursBean.getUsername();
        System.out.println(username);
        compte = iCompteService.getCompteByLogin(username);
       System.out.println(compte);
       client.setCompte(compte);
       
       
       clientEnCours=compte.getClient();
       System.out.println("clientEnCours="+clientEnCours);
      
       if (clientEnCours != null)
             ShopRecommandation();
	
	}
    
	public String inscription() {
	    
		System.out.println("CCCCCCCCCCC");
		
		iClientService.ajouterProfil(client);
		System.out.println(client);
		compte.setClient(client);
		iCompteService.editerCompte(compte);
		System.out.println(compte);
		
		PropertiesLoader.setConfigFile(CONFIG_FILE);
   	    System.out.println("get id du client : ");
   	    long cl_id = client.getId();
    	System.out.println("cl_id ="+cl_id);
    	System.out.println("Get id de la wilaya : ");
    	long w2_id = client.getWilaya().getId();
    	System.out.println("W2_id ="+w2_id);
		iClientService.ajouterClientOntologie(cl_id, w2_id); 
		
		System.out.println("Client ajouté à l'ontologie avec succés"); 
		
		
		
		return "/login.xhtml";
	    
	    
	
	    
	}

	
@SuppressWarnings({ "rawtypes", "static-access" })
public void ShopRecommandation() {
		
    	PropertiesLoader.setConfigFile(CONFIG_FILE);
    	System.out.println("properties loader is good");
    	instance = JenaUtility.getInstance();
    	System.out.println("instance is good");
    	model = instance.getDataModel();
    	System.out.println("model is good");
    	
    	Reasoner reasoner = PelletReasonerFactory.theInstance().create();
    	//Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
    	System.out.println("reasoner is good");
    	
    	InfModel inf = ModelFactory.createInfModel(reasoner, model);
    	//Vérifier la validité du modèle inféré	 
    	ValidityReport validity = inf.validate();
    	if (validity.isValid()) {
    	    System.out.println("\nOK");
    	} else {
    	    System.out.println("\nConflicts");
    	    for (Iterator i = validity.getReports(); i.hasNext(); ) {
    	        ValidityReport.Report report = (ValidityReport.Report)i.next();
    	        System.out.println(" - " + report);
    	    }
    	}
    	System.out.println("inf is good");
    	
    	long cl_id = clientEnCours.getId();
    	System.out.println("cl_id ="+cl_id);
    	
    	
    	Resource cl = inf.getResource(NAMESPACE+"Client_"+cl_id);
    
    	Recommand recommand = new Recommand();
    	
    	vecDomaine = recommand.recInteretDomaine(inf, cl);
    	vecWilaya = recommand.recWilaya(inf, cl);
    	vecLocalisation = recommand.recLocalisation(inf, cl);
    	vecLocalisationProche = recommand.recLocalisationProche(inf, cl);
		
    	
    	
    	System.out.println("\nLa liste de recommandation 1er nivau :");
    	vecRec1 = recommand.recommandLevel(vecDomaine, vecLocalisation);
    	recommand.printRec(vecRec1);
    	for(int i = 0 ; i < vecRec1.size(); i++)
    	{
			
    		shop = iShopService.getShopbyId((Long) vecRec1.get(i));
			System.out.println("shop"+shop);
			firstLevelShops.add(shop);
			
    	}
    	
    	System.out.println("firstLevelShops="+firstLevelShops);
    	
    	
  System.out.println("\nLa liste de recommandation 2eme nivau :");
    	
    	
    	vecRec2 = recommand.recommandLevel(vecDomaine, vecLocalisationProche);
    	recommand.printRec(vecRec2);
    	for(int j = 0 ; j < vecRec2.size(); j++)
    	{
			
    		shop = iShopService.getShopbyId((Long) vecRec2.get(j));
			System.out.println("shop"+shop);
			secondLevelShops.add(shop);
			
    	}
    	System.out.println("SecondLevelShops"  + secondLevelShops);
    	
   System.out.println("\nLa liste de recommandation 3eme nivau :");
    	
    	vecRec3 = recommand.recommandOther(inf, model, vecRec1, vecRec2);
    	recommand.printRec(vecRec3);
    	for(int k = 0 ; k < vecRec3.size(); k++)
    	{
			
    		shop = iShopService.getShopbyId((Long) vecRec3.get(k));
			System.out.println("shop"+shop);
			thirdLevelShops.add(shop);
			
    	}
    	System.out.println("ThirdLevelShops" + thirdLevelShops);
    
    }
	
     
     
        
        
}
     
        
     




