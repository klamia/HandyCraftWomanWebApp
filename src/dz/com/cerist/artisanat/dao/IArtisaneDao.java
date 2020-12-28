package dz.com.cerist.artisanat.dao;



import dz.com.cerist.artisanat.entite.Artisanes;


public interface IArtisaneDao {

    public  void ajouterProfil(Artisanes artisane);
	
	public  Artisanes getArtisanebyId(Long id);
	
	
	//public  List<Artisanes> getAllArtisanes();
    
    public Artisanes editerProfil(Artisanes artisane);
    

}
