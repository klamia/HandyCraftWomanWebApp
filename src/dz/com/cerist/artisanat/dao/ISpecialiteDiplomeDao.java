package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.SpecialiteDiplome;



public interface ISpecialiteDiplomeDao {

	
    public  void ajouterSpecialiteDiplome(SpecialiteDiplome specialiteDiplome);
	
	public  SpecialiteDiplome getSpecialitebyId(Long id);
	
		
	public  List<SpecialiteDiplome> getAllSpecialite();
    
    public SpecialiteDiplome editerSpecialiteDiplome(SpecialiteDiplome specialiteDiplome);

}
