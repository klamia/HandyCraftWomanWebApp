package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Wilayas;

public interface IWilayaService {

	public  void ajouterWilaya(Wilayas wilaya);
	
	public  Wilayas getWilayabyId(Long id);
	
		
	public  List<Wilayas> getAllWilaya();
    
    public Wilayas editerWilaya(Wilayas wilaya);

}
