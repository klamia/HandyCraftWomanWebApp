package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Langages;

public interface ILangageService {

    public  void ajouterLangage(Langages langage);
	
	public  Langages getLangagebyId(Long id);
	
		
	public  List<Langages> getAllLangages();
    
    public Langages editerLangage(Langages langage);
}
