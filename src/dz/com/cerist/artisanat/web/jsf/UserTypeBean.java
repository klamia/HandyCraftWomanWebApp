package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



import dz.com.cerist.artisanat.entite.Comptes;
import dz.com.cerist.artisanat.entite.Role;

import dz.com.cerist.artisanat.service.ICompteService;
import dz.com.cerist.artisanat.service.IRoleService;





@ManagedBean(name = "userTypeBean")
@SessionScoped
public class UserTypeBean  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -123744668264854784L;

	@ManagedProperty(name="iCompteService", value="#{iCompteService}")
	private ICompteService iCompteService;
	
	@ManagedProperty(name="iRoleService", value="#{iRoleService}")
	private IRoleService iRoleService;
	
	private Comptes compte;
	//private Authorities authority;
	
	private String username;
    private String password;
    
    private Boolean isArtisane;
    private Boolean isClient;
    
    @ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;

	
 // Getter and Setter
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CompteEnCoursBean getCompteEnCoursBean() {
		return compteEnCoursBean;
	}
	public void setCompteEnCoursBean(CompteEnCoursBean compteEnCoursBean) {
		this.compteEnCoursBean = compteEnCoursBean;
	}
	
	public ICompteService getiCompteService() {
		return iCompteService;
	}
	public void setiCompteService(ICompteService iCompteService) {
		this.iCompteService = iCompteService;
	}
	public Comptes getCompte() {
		return compte;
	}
	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	/*
	public Authorities getAuthority() {
		return authority;
	}
	public void setAuthority(Authorities authority) {
		this.authority = authority;
	}
	*/
	
	
	public IRoleService getiRoleService() {
		return iRoleService;
	}
	public void setiRoleService(IRoleService iRoleService) {
		this.iRoleService = iRoleService;
	}
	
	// Opérations Femme Artisane
	
	
	public Boolean getIsArtisane() {
		return isArtisane;
	}
	public void setIsArtisane(Boolean isArtisane) {
		this.isArtisane = isArtisane;
	}
	public Boolean getIsClient() {
		return isClient;
	}
	public void setIsClient(Boolean isClient) {
		this.isClient = isClient;
	}
	

	@PostConstruct
    public void init() {
        
		this.isArtisane=false;
		this.isClient=false;
        
	}

	
	
	
	
	public String addCompteArtisane() {
		compte=new Comptes();
		String intitulerole="ROLE_ARTISANE";
		this.isArtisane=true;
		System.out.println(isArtisane);
		Role role = iRoleService.findroleByName(intitulerole);
		compte.setRole(role);
		
		System.out.println("New Compte added, "+compte );
		return "/registration?faces-redirect=true";
	}

	public String addCompteClient() {
		compte=new Comptes();
		String intitulerole="ROLE_CLIENT";
		this.isClient=true;
		System.out.println(isClient);
		Role role = iRoleService.findroleByName(intitulerole);
		compte.setRole(role);
		
		System.out.println("New Compte added, "+compte );
		return "/registration?faces-redirect=true";
	}
	
	
	
	public String ajoutCompte() {
	   
	    String page=null;	
		System.out.println("Début ajout compte");
		iCompteService.ajouterCompte(compte);
		System.out.println("le compte cree est :" +compte);
        username=compte.getUsername();
        System.out.println(username);
        compteEnCoursBean.setUsername(username);
        System.out.println(compteEnCoursBean);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Compte ajouté avec succés"));
        
       // RequestContext.getCurrentInstance().reset(":FormCreationCompte:editC:display");
        if (isArtisane) {
            page ="/artisaneProfil?faces-redirect=true";
        } else if (isClient) {
        	page= "/clientProfil?faces-redirect=true";
        }
		return page;

	}

	
		
	
	
	


}
