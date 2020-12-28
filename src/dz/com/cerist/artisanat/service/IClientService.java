package dz.com.cerist.artisanat.service;

import dz.com.cerist.artisanat.entite.Clients;

public interface IClientService {

	public  void ajouterProfil(Clients client);
	
	public  Clients getClientbyId(Long id);
	
	public void ajouterClientOntologie(long id_client, long id_wilaya) ;
	
	//public  List<Artisanes> getAllArtisanes();
    
    public Clients editerClient(Clients client);



}
