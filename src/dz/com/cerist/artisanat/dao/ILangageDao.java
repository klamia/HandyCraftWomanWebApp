package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Langages;


public interface ILangageDao {

    public  void ajouterLangage(Langages langage);
	
	public  Langages getLangagebyId(Long id);
	
		
	public  List<Langages> getAllLangages();
    
    public Langages editerLangage(Langages langage);

}
