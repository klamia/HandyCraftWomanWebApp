package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.service.ICategorieService;



@ManagedBean(name = "categorieBean")
@SessionScoped
public class CategorieBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(name="iCategorieService", value="#{iCategorieService}")
	private ICategorieService iCategorieService;
	private Category categorie;
	private List<Category> listCategorie ;
	private Category editedCategorie ;
	
	
	int index;


	public ICategorieService getiCategorieService() {
		return iCategorieService;
	}


	public void setiCategorieService(ICategorieService iCategorieService) {
		this.iCategorieService = iCategorieService;
	}


	public Category getCategorie() {
		return categorie;
	}


	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}


	public List<Category> getListCategorie() {
		listCategorie= iCategorieService.getCategories();
		return listCategorie;
	}


	public void setListCategorie(List<Category> listCategorie) {
		this.listCategorie = listCategorie;
	}


	public Category getEditedCategorie() {
		return editedCategorie;
	}


	public void setEditedCategorie(Category editedCategorie) {
		this.editedCategorie = editedCategorie;
	}

//  Les opérations métiers des boutons
	
	public void addCategorie() {
		categorie=new Category();
		System.out.println("New Categorie added, "+categorie );
	}
	public void editCategorie(Category categorie) {
		System.out.println(" Categorie updated");
		index = listCategorie.indexOf(categorie);
		System.out.println(index);
		editedCategorie = categorie;	
	}

        //  Les services métiers 
	
	
	 public void ajoutCategorie() {
		    try{
			System.out.println("CATTTTTTTTT");
			iCategorieService.ajouterCategorie(categorie);   
			System.out.println(categorie);
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Categorie ajoutée avec succés"));
	        //RequestContext.getCurrentInstance().reset(":FormCreationCompte:editC:display");
	    	   }catch(Exception e ){e.printStackTrace();}
	 }
	
	 public void modifierCategorie() {
		    try{
			System.out.println("modCattttttt");
			editedCategorie= iCategorieService.editerCategorie(editedCategorie);     
			listCategorie.set(index, editedCategorie);
		    FacesContext context1 = FacesContext.getCurrentInstance();
	        context1.addMessage(null, new FacesMessage("Categorie modifiée avec succés"));
	    //RequestContext.getCurrentInstance().reset("editD:display");
	    	   }catch(Exception e ){e.printStackTrace();}
	 }

	 public void reset() {  
	      //  RequestContext.getCurrentInstance().reset("editC:display");  
	    }  
	 
	


}
