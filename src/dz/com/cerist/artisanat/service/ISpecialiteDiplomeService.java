package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.SpecialiteDiplome;

public interface ISpecialiteDiplomeService {

    public  void ajouterSpecialiteDiplome(SpecialiteDiplome specialiteDiplome);
	
	public  SpecialiteDiplome getSpecialitebyId(Long id);
	
		
	public  List<SpecialiteDiplome> getAllSpecialite();
    
    public SpecialiteDiplome editerSpecialiteDiplome(SpecialiteDiplome specialiteDiplome);
}
