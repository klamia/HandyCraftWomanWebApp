package dz.com.cerist.artisanat.dao;

import java.util.List;


import dz.com.cerist.artisanat.entite.Diplomes;

public interface IDiplomeDao {
  
    public  void ajouterDiplome(Diplomes diplome);
	
	public  Diplomes getDiplomebyId(Long id);
	
		
	public  List<Diplomes> getAllDiplomes();
    
    public Diplomes editerDiplome(Diplomes diplome);


}
