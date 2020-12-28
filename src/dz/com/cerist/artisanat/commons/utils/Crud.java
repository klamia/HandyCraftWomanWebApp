package dz.com.cerist.artisanat.commons.utils;


import java.io.Serializable;

import dz.com.cerist.artisanat.entite.ontology.Activite;
import dz.com.cerist.artisanat.entite.ontology.Artisane;
import dz.com.cerist.artisanat.entite.ontology.Client;
import dz.com.cerist.artisanat.entite.ontology.Shops;
import dz.com.cerist.artisanat.entite.ontology.Wilaya;
import dz.com.cerist.artisanat.entite.repository.ArtisaneRepository;
import dz.com.cerist.artisanat.entite.repository.ClientRepository;
import dz.com.cerist.artisanat.entite.repository.ShopsRepository;



public class Crud implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2454821791991574595L;

	public Crud() {
		
	}
	
	public static void ajouterArtisane(long id_artisane, long id_wilaya, long id_domaine) {
		
    	Wilaya w = new Wilaya(id_wilaya);
    	Activite domaine = new Activite(id_domaine);
		ArtisaneRepository aRepo = new ArtisaneRepository();
		Artisane artisane = new Artisane(id_artisane,domaine,  w);
		aRepo.create(artisane);
	}
	
	public static void ajouterShop(long id_shop, long id_artisane, long id_wilaya) {
		
		Artisane artisan = new Artisane(id_artisane, null, null);
    	Wilaya w_shop = new Wilaya(id_wilaya);
    	ShopsRepository sRepo = new ShopsRepository();
		Shops shop = new Shops(id_shop, artisan, w_shop);
		sRepo.create(shop);
		
	}
	
	public static void ajouterClient(long id_client, long id_wilaya) {
		
		Wilaya w2 = new Wilaya(id_wilaya);
    	ClientRepository cRepo = new ClientRepository();
		Client client = new Client(id_client, w2);
		cRepo.create(client);
	}
    
}
