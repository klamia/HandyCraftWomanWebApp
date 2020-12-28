package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.SessionScoped;


import dz.com.cerist.artisanat.entite.Artisanes;

import dz.com.cerist.artisanat.entite.Comptes;
import dz.com.cerist.artisanat.service.ICompteService;

@ManagedBean(name = "artisaneEnCoursBean")
@SessionScoped
public class ArtisaneEnCoursBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9195618082581946583L;

	@ManagedProperty(name="iCompteService", value="#{iCompteService}")
	private ICompteService iCompteService;

	@ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;
	
	private Comptes compte;
	private Artisanes artisane;

	
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

	public Comptes getCompte() {
		/*
		String username=compteEnCoursBean.getUsername();
	    System.out.println(username);
	    compte = iCompteService.getCompteByLogin(username);
		
       */
		return compte;
	}

	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	public Artisanes getArtisane() {
		/*
		artisane=compte.getArtisane();
		System.out.println(artisane);
		*/
		return artisane;
		
	}

	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}


	/*
	public void init() {
	String username=compteEnCoursBean.getUsername();
    System.out.println(username);
    compte = iCompteService.getCompteByLogin(username);
    System.out.println(compte);
    artisane=compte.getArtisane();
    artisaneEnCoursBean.setArtisane(artisane);
    System.out.println(artisane);
    	
    }
*/
   


}
