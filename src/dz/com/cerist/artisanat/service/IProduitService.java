package dz.com.cerist.artisanat.service;

import java.util.List;

import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Produits;

public interface IProduitService {

public  void ajouterProduit(Produits produit);
	
	public  Produits getProduitbyId(Long id);
	
	public Produits getProduitByName(String nomProduit);
	
	public  List<Produits> getAllProduits();
    
	public  List<Produits> getAllProduitsArtisane(Artisanes artisane);
	
	public Produits editerProduit(Produits produit);

    public Produits remove(Produits produit);

    
}
