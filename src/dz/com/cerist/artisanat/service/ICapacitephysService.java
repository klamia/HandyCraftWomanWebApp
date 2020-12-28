package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Capacitephys;

public interface ICapacitephysService {

    public  void ajouterCapacitephys(Capacitephys capacitephys);
	
	public  Capacitephys getCapacitephysbyId(Long id);
	
		
	public  List<Capacitephys> getAllCapacitephys();
    
    public Capacitephys editerCapacitephys(Capacitephys capacitephys);
}
