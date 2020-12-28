package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Capacitecogns;


public interface ICapacitecognsDao {
  
    public  void ajouterCapacitecogns(Capacitecogns capacitecogns);
	
	public  Capacitecogns getCapacitecognsbyId(Long id);
	
		
	public  List<Capacitecogns> getAllCapacitecogns();
    
    public Capacitecogns editerCapacitecogns(Capacitecogns capacitecogns);

}
