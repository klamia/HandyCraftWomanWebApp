package dz.com.cerist.artisanat.service;



import dz.com.cerist.artisanat.entite.Artisanes;

public interface IArtisaneService {

    public  void ajouterProfil(Artisanes artisane);
	
	public  Artisanes getArtisanebyId(Long id);
	
	
	//public  List<Artisanes> getAllArtisanes();
    
    public Artisanes editerProfil(Artisanes artisane);

    public void ajouterArtisaneOntologie(long id_artisane, long id_wilaya, long id_domaine) ;

}
