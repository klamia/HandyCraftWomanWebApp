package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Artisanes;
import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.entite.Shop;




public interface IShopDao {

	public  void ajouterShop(Shop shop);
	
	public  Shop getShopbyId(Long id);
	
	public  List<Shop> getAllShopsCategory(Category category);
	
	public  List<Shop> getAllShops();
    
     public Shop editerShop(Shop shop);
	
     public List<Shop> getFirstPageShops();

     public  List<Shop> getAllShopsArtisane(Artisanes artisane);

     public Shop remove(Shop shop);

}
