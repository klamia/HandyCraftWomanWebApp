package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Computerliteracys;


public interface IComputerliteracysDao {

    public  void ajouterComputerliteracys(Computerliteracys computerliteracys);
	
	public  Computerliteracys getComputerliteracysbyId(Long id);
	
		
	public  List<Computerliteracys> getAllComputerliteracys();
    
    public Computerliteracys editerComputerliteracys(Computerliteracys computerliteracys);


}
