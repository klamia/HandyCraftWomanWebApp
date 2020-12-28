package dz.com.cerist.artisanat.service;

import java.util.List;


import dz.com.cerist.artisanat.entite.Category;

public interface ICategorieService {

      public  void ajouterCategorie(Category categorie);
	
		public  Category getCategoriebyId(Long id);
		
	//	public  List<Categorieproduit> getAllCategories();
	    
	   public Category editerCategorie(Category categorie);
       
	   public List<Category> getCategories();
	   public List<Category> getShopsCategories();
}
