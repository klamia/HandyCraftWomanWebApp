package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Centresinterets;

public interface ICentresinteretsService {
  
	public  void ajouterInteret(Centresinterets interet);
	
	public  Centresinterets getInteretbyId(Long id);
	
		
	public  List<Centresinterets> getAllInterets();
    
    public Centresinterets editerInteret(Centresinterets interet);

}
