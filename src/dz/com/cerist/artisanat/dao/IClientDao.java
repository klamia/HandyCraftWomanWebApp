package dz.com.cerist.artisanat.dao;


import dz.com.cerist.artisanat.entite.Clients;

public interface IClientDao {

	    public  void ajouterProfil(Clients client);
		
		public  Clients getClientbyId(Long id);
		
		
		//public  List<Artisanes> getAllArtisanes();
	    
	    public Clients editerClient(Clients client);
	    


}
