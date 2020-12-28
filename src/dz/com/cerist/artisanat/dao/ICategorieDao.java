package dz.com.cerist.artisanat.dao;

import java.util.List;


import dz.com.cerist.artisanat.entite.Category;





public interface ICategorieDao {
	

	    public  void ajouterCategorie(Category categorie);
		
		public  Category getCategoriebyId(Long id);
		
		//public  List<Category> getAllCategories();
	    
	   public Category editerCategorie(Category categorie);
		
	   public List<Category> getCategories();
	   public List<Category> getShopsCategories();
}
