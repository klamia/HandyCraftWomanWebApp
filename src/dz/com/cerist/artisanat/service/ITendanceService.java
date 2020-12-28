package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Tendances;

public interface ITendanceService {

    public  void ajouterTendance(Tendances tendance);
	
	public  Tendances getTendancebyId(Long id);
		
	public  List<Tendances> getAllTendances();
    
    public Tendances editerTendance(Tendances tendance);

	
}
