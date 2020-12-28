package dz.com.cerist.artisanat.web.jsf;


import java.io.Serializable;



import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;


@ManagedBean(name = "produitBean")
@SessionScoped
public class ProduitBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3023070098155185408L;

/*
	@ManagedProperty(name="iArtisaneService", value="#{iArtisaneService}")
	private IArtisaneService iArtisaneService;
	
	
	@ManagedProperty(name="iCompteService", value="#{iCompteService}")
	private ICompteService iCompteService;
	
	@ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;
	
	@ManagedProperty(name="iProduitService", value="#{iProduitService}")
	private IProduitService iProduitService;
	
	
    private Artisanes artisane;
    private Comptes compte;
    private Artisanes artisaneEnCours;
    private Produits produit;
    private List<Produits> listproduitsArtisane ;
    private List<Produits> filteredProduits;
    private UploadedFile uploadedFile;
    private UploadedFile uploadedFile2 ;
    private DefaultStreamedContent myPhoto;
    private DefaultStreamedContent imagePhoto;
   
    private Produits editedProduit ;
    private Produits produitEnCours ;
    private Produits produitPublie;
    private Produits produitDeleted;
    
    
    int index;
    
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
	public IProduitService getiProduitService() {
		return iProduitService;
	}
	public void setiProduitService(IProduitService iProduitService) {
		this.iProduitService = iProduitService;
	}
	public Artisanes getArtisane() {
		return artisane;
	}
	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}
	public Comptes getCompte() {
		return compte;
	}
	public void setCompte(Comptes compte) {
		this.compte = compte;
	}
	public Artisanes getArtisaneEnCours() {
		return artisaneEnCours;
	}
	public void setArtisaneEnCours(Artisanes artisaneEnCours) {
		this.artisaneEnCours = artisaneEnCours;
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
	public List<Produits> getFilteredProduits() {
		return filteredProduits;
	}
	public void setFilteredProduits(List<Produits> filteredProduits) {
		this.filteredProduits = filteredProduits;
	}
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	

	public UploadedFile getUploadedFile2() {
		return uploadedFile2;
	}
	public void setUploadedFile2(UploadedFile uploadedFile2) {
		this.uploadedFile2 = uploadedFile2;
	}
	public DefaultStreamedContent getMyPhoto() {
		FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
           
           
        	myPhoto = new DefaultStreamedContent(new ByteArrayInputStream(produitEnCours.getImageProduit()));
            System.out.println(myPhoto);
        	
    	return myPhoto;
        }
	}
	public void setMyPhoto(DefaultStreamedContent myPhoto) {
		this.myPhoto = myPhoto;
	}
	public DefaultStreamedContent getImagePhoto() {
		return imagePhoto;
	}
	public void setImagePhoto(DefaultStreamedContent imagePhoto) {
		this.imagePhoto = imagePhoto;
	}
	public Produits getEditedProduit() {
		return editedProduit;
	}
	public void setEditedProduit(Produits editedProduit) {
		this.editedProduit = editedProduit;
	}
	

    public Produits getProduitEnCours() {
		return produitEnCours;
	}
	public void setProduitEnCours(Produits produitEnCours) {
		this.produitEnCours = produitEnCours;
	}
	public Produits getProduitPublie() {
		return produitPublie;
	}
	public void setProduitPublie(Produits produitPublie) {
		this.produitPublie = produitPublie;
	}
	public Produits getProduitDeleted() {
		return produitDeleted;
	}
	public void setProduitDeleted(Produits produitDeleted) {
		this.produitDeleted = produitDeleted;
	}
	
	
	@PostConstruct
    public void init() {
        
		
		String username=compteEnCoursBean.getUsername();
        System.out.println(username);
        compte = iCompteService.getCompteByLogin(username);
        System.out.println(compte);  
       artisaneEnCours=compte.getArtisane();
       System.out.println(artisaneEnCours);
        
	}
	
     public void handleFileUpload(FileUploadEvent event) throws IOException {

		
		uploadedFile = event.getFile();
	    System.out.println(uploadedFile.getFileName());
	   
	    
	    byte[] foto = IOUtils.toByteArray(uploadedFile.getInputstream());
	    System.out.println(foto);
	    produit.setImageProduit(foto);
	   
	    
	   setUploadedFile(null);
	    
	   
	}
    
     public void handleFileUploadSecond(FileUploadEvent event) throws IOException {

 	    
   	  // setImagePhoto(null);
			uploadedFile2 = event.getFile();
		    System.out.println(uploadedFile2.getFileName());
		 
		    
		    byte[] foto2 = IOUtils.toByteArray(uploadedFile2.getInputstream());
		    System.out.println(foto2);
		    
		    editedProduit.setImageProduit(foto2);
		   
		    ByteArrayInputStream img = new ByteArrayInputStream(foto2);
		    setImagePhoto(new DefaultStreamedContent(img,"image/png, jpg, jpeg, gif"));
		   
		  
		    setUploadedFile2(null);
		    
		  System.out.println(foto2);
		}
 
     
     
     
     public void addProduit() {
 		produit=new Produits();
 	   produit.setArtisane(artisaneEnCours);
 	 //  produit.setEtat("Non Publie");
 	    System.out.println("New Produit added, "+produit );
 	}
    
     public void editProduit(Produits produit) {
 		System.out.println(" Produit updated");
 	    index = listproduitsArtisane.indexOf(produit);
 		System.out.println(index);
 		editedProduit = produit;	
 	}
 	
     public void checkProduit(Produits produit) {
 		System.out.println(" Produit a voir");
 		index = listproduitsArtisane.indexOf(produit);
 		produitEnCours = produit;
 	
 	}
 	
     public void publishProduit(Produits produit) {
 		System.out.println(" Produit a publié");
 		index = listproduitsArtisane.indexOf(produit);
 		produitPublie = produit;
 		System.out.println(produitPublie.getEtat());
 		}  
     
     public void deleteProduit(Produits produit) {
  		System.out.println(" Produit a supprimé");
  		index = listproduitsArtisane.indexOf(produit);
  		 produitDeleted = produit;
  		}  
     
     */
     
 /********************************************************************************************/   
     
     /*
     public void ajoutProduit() {
 	    try{
 		System.out.println("AAAAAAAAAAAAAAAAAA");
 		iProduitService.ajouterProduit(produit);
         FacesContext context = FacesContext.getCurrentInstance();
         context.addMessage(null, new FacesMessage("Produit ajouté avec succés"));
         //RequestContext.getCurrentInstance().reset(":FormCreationCompte:editC:display");
     	   }catch(Exception e ){e.printStackTrace();}
 		
         }
 	
     public void modifierProduit() {
		    try{
			System.out.println("EEEEEEEEEEEEEEEEEE");
			editedProduit= iProduitService.editerProduit(editedProduit);
			//produit = editedProduit;
			setImagePhoto(null);
			listproduitsArtisane.set(index, editedProduit);
		    FacesContext context1 = FacesContext.getCurrentInstance();
	        context1.addMessage(null, new FacesMessage("Produit modifié avec succés"));
	    //RequestContext.getCurrentInstance().reset("editD:display");
	    	   }catch(Exception e ){e.printStackTrace();}
	 }
 	 
     
     public void publie_nonPublie_produit(){
		 
    	 String status = produitPublie.getEtat();

    	 switch(status) {
    	   case "NonPublie":
    		 produitPublie.setEtat("Publie");
    		 produitPublie= iProduitService.editerProduit(produitPublie);
    		 listproduitsArtisane.set(index, produitPublie);
    		 System.out.println("PUBBBBBBBB");
			 FacesContext context = FacesContext.getCurrentInstance();
		     context.addMessage(null, new FacesMessage("publication du produit réussie"));
    	     break;
    	   case "Publie":
    		 produitPublie.setEtat("NonPublie");
    		 produitPublie=iProduitService.editerProduit(produitPublie);
    		 listproduitsArtisane.set(index, produitPublie);
    		 FacesContext context2 = FacesContext.getCurrentInstance();
		     context2.addMessage(null, new FacesMessage("Non publication du produit réussie"));
    		 break;
    	  
    	 }
    	 
    	 
    	 
    	 
	 }
     
     
     public void supprimerProduit() {
 		
    	 try{
 			System.out.println("EEEEEEEEEEEEEEEEEE");
 			produitDeleted= iProduitService.remove(produitDeleted);
 			//setImagePhoto(null);
 			listproduitsArtisane.set(index, produitDeleted);
 		    FacesContext context1 = FacesContext.getCurrentInstance();
 	        context1.addMessage(null, new FacesMessage("Produit supprimé avec succés"));
 	    //RequestContext.getCurrentInstance().reset("editD:display");
 	    	   }catch(Exception e ){e.printStackTrace();}
 		
 	    
 	}
     
     
     
     
 	 public void reset() {  
 	        RequestContext.getCurrentInstance().reset("FormCreationProduit:editP:display");  
 	    } 

 	 
 	 */
}
