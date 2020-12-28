package dz.com.cerist.artisanat.commons.utils;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;

import dz.com.cerist.artisanat.entite.ontology.Activite;
import dz.com.cerist.artisanat.entite.ontology.Artisane;
import dz.com.cerist.artisanat.entite.ontology.Client;
import dz.com.cerist.artisanat.entite.ontology.Shops;
import dz.com.cerist.artisanat.entite.ontology.Wilaya;


public class Update_ont {
	private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	public Update_ont() {
			
	}
	@SuppressWarnings("unused")
	private static Wilaya getWilayaIndividual(OntModel ontModel, long id) {
		Wilaya wilaya = new Wilaya();
		wilaya.setId(id);
		Individual wilayaIndividual = ontModel.getIndividual(NAMESPACE + "Wilaya_"+id);
		DatatypeProperty hasId = ontModel.getDatatypeProperty(NAMESPACE + "hasId");
		
		return wilaya;
	}
	@SuppressWarnings("unused")
	private static Artisane getArtisaneIndividual(OntModel ontModel, long id) {
		Artisane artisane = new Artisane();
		artisane.setId(id);
		Individual artisaneIndividual = ontModel.getIndividual(NAMESPACE + "Artisane_"+id);
		DatatypeProperty hasId = ontModel.getDatatypeProperty(NAMESPACE + "hasId");
		
		return artisane;
	}
	
	public static void addArtisane(long id_artisane, long id_wilaya, long id_domaine, OntModel ontModel) {
		Activite domaine = new Activite(id_domaine);
		Wilaya wilaya = getWilayaIndividual(ontModel, id_wilaya);
		Artisane artisane = new Artisane(id_artisane, domaine, wilaya);
		
		// Create an individual of type artisane
		OntClass artisaneClass = ontModel.getOntClass(NAMESPACE + "Artisane");
		Individual artisaneIndividual = ontModel.createIndividual(NAMESPACE + "Artisane_"+id_artisane, artisaneClass);
		DatatypeProperty datatypeProperty = ontModel.getDatatypeProperty(NAMESPACE + "hasId");
		artisaneIndividual.addProperty(datatypeProperty, new Long(artisane.getId()).toString(), XSDDatatype.XSDlong);
		
		//Associate the artisane individual with the domaine
		Individual domaineIndividual = ontModel.getIndividual(NAMESPACE + "Activite_"+id_domaine);
		ObjectProperty aDomaine = ontModel.getObjectProperty(NAMESPACE + "aDomaine");
		artisaneIndividual.addProperty(aDomaine, domaineIndividual);
		
		//Associate the artisane individual with the wilaya
		Individual wilayaIndividual = ontModel.getIndividual(NAMESPACE + "Wilaya_"+id_wilaya);
		ObjectProperty vivreAu = ontModel.getObjectProperty(NAMESPACE + "vivreAu");
		artisaneIndividual.addProperty(vivreAu, wilayaIndividual);
		
	}
	
	
	public static void addShop(long id_shop, long id_artisane, long id_wilaya, OntModel ontModel) {
		Artisane artisane = getArtisaneIndividual(ontModel, id_artisane);
		Wilaya wilaya = getWilayaIndividual(ontModel, id_wilaya);
		Shops shop = new Shops(id_shop, artisane, wilaya);
		
		// Create an individual of type Shops
		OntClass shopClass = ontModel.getOntClass(NAMESPACE +"Shops");
		Individual shopIndividual = ontModel.createIndividual(NAMESPACE + "Shops_"+id_shop, shopClass);
		DatatypeProperty datatypeProperty = ontModel.getDatatypeProperty(NAMESPACE + "hasId");
		shopIndividual.addProperty(datatypeProperty, new Long(shop.getId()).toString(), XSDDatatype.XSDlong);
		
		//associate the shop individual with artisane
		Individual artisaneIndividual = ontModel.getIndividual(NAMESPACE + "Artisane_"+id_artisane);
		ObjectProperty shopAppartient = ontModel.getObjectProperty(NAMESPACE + "shopAppartient");
		shopIndividual.addProperty(shopAppartient, artisaneIndividual);
		
		// associate the shop individual with wilaya
		Individual wilayaIndividual = ontModel.getIndividual(NAMESPACE + "Wilaya_"+id_wilaya);
		ObjectProperty seLocaliseA = ontModel.getObjectProperty(NAMESPACE + "seLocaliseA");
		shopIndividual.addProperty(seLocaliseA, wilayaIndividual);
	}
	
	public static void addClient(long id_client, long id_wilaya, OntModel ontModel) {
		Wilaya wilaya = getWilayaIndividual(ontModel, id_wilaya);
		Client client = new Client(id_client, wilaya);
		
		//Create an individual client
		OntClass clientClass = ontModel.getOntClass(NAMESPACE + "Client");
		Individual clientIndividual = ontModel.createIndividual(NAMESPACE + "Client_" + id_client,clientClass);
		DatatypeProperty datatypeProperty = ontModel.getDatatypeProperty(NAMESPACE + "hasId");
		clientIndividual.addProperty(datatypeProperty, new Long(client.getId()).toString(), XSDDatatype.XSDlong);
		
		//Associate the client individual with the wilaya
		Individual wilayaIndividual = ontModel.getIndividual(NAMESPACE + "Wilaya_"+id_wilaya);
		ObjectProperty vivreAu = ontModel.getObjectProperty(NAMESPACE + "vivreAu");
		clientIndividual.addProperty(vivreAu, wilayaIndividual);
				
		
	}
	
	public void saveOnt() {
		
	}
	

}
