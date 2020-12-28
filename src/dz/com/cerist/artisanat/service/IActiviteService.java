package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Activites;

public interface IActiviteService {

    public  void ajouterActivite(Activites activite);
	
	public  Activites getActivitebyId(Long id);
	
		
	public  List<Activites> getAllActivites();
    
    public Activites editerActivite(Activites activite);
}
