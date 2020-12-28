package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Couleurs;


public interface ICouleurDao {

    public  void ajouterCouleur(Couleurs couleur);
	
	public  Couleurs getCouleurbyId(Long id);
	
		
	public  List<Couleurs> getAllCouleurs();
    
    public Couleurs editerCouleur(Couleurs couleur);


}
