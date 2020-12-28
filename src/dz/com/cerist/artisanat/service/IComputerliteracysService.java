package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Computerliteracys;

public interface IComputerliteracysService {

    public  void ajouterComputerliteracys(Computerliteracys computerliteracys);
	
	public  Computerliteracys getComputerliteracysbyId(Long id);
	
		
	public  List<Computerliteracys> getAllComputerliteracys();
    
    public Computerliteracys editerComputerliteracys(Computerliteracys computerliteracys);


}
