package dz.com.cerist.artisanat.dao;

import java.util.List;


import dz.com.cerist.artisanat.entite.Capacitephys;

public interface ICapacitephysDao {

    public  void ajouterCapacitephys(Capacitephys capacitephys);
	
	public  Capacitephys getCapacitephysbyId(Long id);
	
		
	public  List<Capacitephys> getAllCapacitephys();
    
    public Capacitephys editerCapacitephys(Capacitephys capacitephys);
}
