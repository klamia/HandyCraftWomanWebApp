package dz.com.cerist.artisanat.dao;

import java.util.List;


import dz.com.cerist.artisanat.entite.Tendances;

public interface ITendanceDao {

    public  void ajouterTendance(Tendances tendance);
	
	public  Tendances getTendancebyId(Long id);
	
		
	public  List<Tendances> getAllTendances();
    
    public Tendances editerTendance(Tendances tendance);

	
}
