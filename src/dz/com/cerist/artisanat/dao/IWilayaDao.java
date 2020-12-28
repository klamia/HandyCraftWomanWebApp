package dz.com.cerist.artisanat.dao;

import java.util.List;


import dz.com.cerist.artisanat.entite.Wilayas;

public interface IWilayaDao {

    public  void ajouterWilaya(Wilayas wilaya);
	
	public  Wilayas getWilayabyId(Long id);
	
		
	public  List<Wilayas> getAllWilaya();
    
    public Wilayas editerWilaya(Wilayas wilaya);
	

}
