package dz.com.cerist.artisanat.web.util;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;

import dz.com.cerist.artisanat.entite.ontology.Activite;
import dz.com.cerist.artisanat.entite.ontology.Artisane;
import dz.com.cerist.artisanat.entite.ontology.Client;
import dz.com.cerist.artisanat.entite.ontology.Shops;
import dz.com.cerist.artisanat.entite.ontology.Wilaya;


import ro.tuc.dsrl.m2o.ontology.utility.JenaUtility;

public class Crud_jena {
	private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	public Crud_jena() {
			
	}
	private static Wilaya getWilayaIndividual(JenaUtility instance, long id) {
		Wilaya wilaya = new Wilaya();
		wilaya.setId(id);
		Individual wilayaIndividual = instance.getOntModel().getIndividual(NAMESPACE + "Wilaya_"+id);
		DatatypeProperty hasId = instance.getOntModel().getDatatypeProperty(NAMESPACE + "hasId");
		
		return wilaya;
	}
	private static Artisane getArtisaneIndividual(JenaUtility instance, long id) {
		Artisane artisane = new Artisane();
		artisane.setId(id);
		Individual artisaneIndividual = instance.getOntModel().getIndividual(NAMESPACE + "Artisane_"+id);
		DatatypeProperty hasId = instance.getOntModel().getDatatypeProperty(NAMESPACE + "hasId");
		
		return artisane;
	}
	
	public static void addArtisane(long id_artisane, long id_wilaya, long id_domaine, JenaUtility instance) {
		Activite domaine = new Activite(id_domaine);
		Wilaya wilaya = getWilayaIndividual(instance, id_wilaya);
		Artisane artisane = new Artisane(id_artisane, domaine, wilaya);
		
		// Create an individual of type artisane
		OntClass artisaneClass = instance.getOntModel().getOntClass(NAMESPACE + "Artisane");
		Individual artisaneIndividual = instance.getOntModel().createIndividual(NAMESPACE + "Artisane_"+id_artisane, artisaneClass);
		DatatypeProperty datatypeProperty = instance.getOntModel().getDatatypeProperty(NAMESPACE + "hasId");
		artisaneIndividual.addProperty(datatypeProperty, new Long(artisane.getId()).toString(), XSDDatatype.XSDlong);
		
		//Associate the artisane individual with the domaine
		Individual domaineIndividual = instance.getOntModel().getIndividual(NAMESPACE + "Activite_"+id_domaine);
		ObjectProperty aDomaine = instance.getOntModel().getObjectProperty(NAMESPACE + "aDomaine");
		artisaneIndividual.addProperty(aDomaine, domaineIndividual);
		
		//Associate the artisane individual with the wilaya
		Individual wilayaIndividual = instance.getOntModel().getIndividual(NAMESPACE + "Wilaya_"+id_wilaya);
		ObjectProperty vivreAu = instance.getOntModel().getObjectProperty(NAMESPACE + "vivreAu");
		artisaneIndividual.addProperty(vivreAu, wilayaIndividual);
		
	}
	
	
	public static void addShop(long id_shop, long id_artisane, long id_wilaya, JenaUtility instance) {
		Artisane artisane = getArtisaneIndividual(instance, id_artisane);
		Wilaya wilaya = getWilayaIndividual(instance, id_wilaya);
		Shops shop = new Shops(id_shop, artisane, wilaya);
		
		// Create an individual of type Shops
		OntClass shopClass = instance.getOntModel().getOntClass(NAMESPACE +"Shops");
		Individual shopIndividual = instance.getOntModel().createIndividual(NAMESPACE + "Shops_"+id_shop, shopClass);
		DatatypeProperty datatypeProperty = instance.getOntModel().getDatatypeProperty(NAMESPACE + "hasId");
		shopIndividual.addProperty(datatypeProperty, new Long(shop.getId()).toString(), XSDDatatype.XSDlong);
		
		//associate the shop individual with artisane
		Individual artisaneIndividual = instance.getOntModel().getIndividual(NAMESPACE + "Artisane_"+id_artisane);
		ObjectProperty shopAppartient = instance.getOntModel().getObjectProperty(NAMESPACE + "shopAppartient");
		shopIndividual.addProperty(shopAppartient, artisaneIndividual);
		
		// associate the shop individual with wilaya
		Individual wilayaIndividual = instance.getOntModel().getIndividual(NAMESPACE + "Wilaya_"+id_wilaya);
		ObjectProperty seLocaliseA = instance.getOntModel().getObjectProperty(NAMESPACE + "seLocaliseA");
		shopIndividual.addProperty(seLocaliseA, wilayaIndividual);
	}
	
	public static void addClient(long id_client, long id_wilaya, JenaUtility instance) {
		Wilaya wilaya = getWilayaIndividual(instance, id_wilaya);
		Client client = new Client(id_client, wilaya);
		
		//Create an individual client
		OntClass clientClass = instance.getOntModel().getOntClass(NAMESPACE + "Client");
		Individual clientIndividual = instance.getOntModel().createIndividual(NAMESPACE + "Client_" + id_client,clientClass);
		DatatypeProperty datatypeProperty = instance.getOntModel().getDatatypeProperty(NAMESPACE + "hasId");
		clientIndividual.addProperty(datatypeProperty, new Long(client.getId()).toString(), XSDDatatype.XSDlong);
		
		//Associate the client individual with the wilaya
		Individual wilayaIndividual = instance.getOntModel().getIndividual(NAMESPACE + "Wilaya_"+id_wilaya);
		ObjectProperty vivreAu = instance.getOntModel().getObjectProperty(NAMESPACE + "vivreAu");
		clientIndividual.addProperty(vivreAu, wilayaIndividual);
				
		
	}
	

}
