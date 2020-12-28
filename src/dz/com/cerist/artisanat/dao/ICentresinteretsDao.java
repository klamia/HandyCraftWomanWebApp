package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Centresinterets;

public interface ICentresinteretsDao {

    public  void ajouterInteret(Centresinterets interet);
	
	public  Centresinterets getInteretbyId(Long id);
	
		
	public  List<Centresinterets> getAllInterets();
    
    public Centresinterets editerInteret(Centresinterets interet);

}
