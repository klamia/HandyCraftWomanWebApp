package dz.com.cerist.artisanat.service;

import java.util.List;


import dz.com.cerist.artisanat.entite.Comptes;

public interface ICompteService {

    public  void ajouterCompte(Comptes compte);
	
	public  Comptes getComptebyId(Long id);
	
	public Comptes getCompteByLogin(String username);
	
	public  List<Comptes> getAllCompte();
    
    public Comptes editerCompte(Comptes compte);

}
