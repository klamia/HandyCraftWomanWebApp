package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Activites;


public interface IActiviteDao {

   public  void ajouterActivite(Activites activite);
	
	public  Activites getActivitebyId(Long id);
	
		
	public  List<Activites> getAllActivites();
    
    public Activites editerActivite(Activites activite);

}
