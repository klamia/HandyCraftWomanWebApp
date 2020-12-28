package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Diplomes;

public interface IDiplomeService {

    public  void ajouterDiplome(Diplomes diplome);
	
	public  Diplomes getDiplomebyId(Long id);
	
		
	public  List<Diplomes> getAllDiplomes();
    
    public Diplomes editerDiplome(Diplomes diplome);

}
