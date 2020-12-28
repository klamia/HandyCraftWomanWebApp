package dz.com.cerist.artisanat.web.util;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.reasoner.Reasoner;

import dz.com.cerist.artisanat.commons.utils.Crud;
import dz.com.cerist.artisanat.entite.ontology.Activite;
import dz.com.cerist.artisanat.entite.ontology.Artisane;
import dz.com.cerist.artisanat.entite.ontology.Client;
import dz.com.cerist.artisanat.entite.ontology.Shops;
import dz.com.cerist.artisanat.entite.ontology.Wilaya;
import dz.com.cerist.artisanat.entite.repository.ArtisaneRepository;
import dz.com.cerist.artisanat.entite.repository.ClientRepository;
import dz.com.cerist.artisanat.entite.repository.ShopsRepository;

import ro.tuc.dsrl.m2o.ontology.access.JenaAccessManager;
import ro.tuc.dsrl.m2o.ontology.access.OntologyAccessManager;
import ro.tuc.dsrl.m2o.ontology.utility.JenaUtility;
import ro.tuc.dsrl.m2o.ontology.utility.OntologyUtilityFactory;
import ro.tuc.dsrl.m2o.utility.PropertiesLoader;





public class Start implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3438961848963853075L;
	private static final Log LOGGER = LogFactory.getLog(Start.class);
	private static String CONFIG_FILE = "/artisanat-config.config";
	//private static PropertiesLoader prop;
	private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	
    private Start() {
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertiesLoader.setConfigFile(CONFIG_FILE);
    
    	Crud crud = new Crud();
      	Scanner sc = new Scanner(System.in);
    	
      	System.out.println("Que voulez-vous faire?");
      	System.out.println("	1- Ajouter une artisane,");
      	System.out.println("	2- Ajouter un shop,");
      	System.out.println("	3- Ajouter un client.");
      	int choix = sc.nextInt();
      	switch (choix) {
      	case 1:
	      	//Ajouter Artisane
	      	System.out.println("Donner l'id de l'artisane : ");
	    	long ar_id = sc.nextLong();
	    	System.out.println("Donner l'id de la wilaya : ");
	    	long w_id = sc.nextLong();
	    	System.out.println("Donner l'id du domaine d'activit� : ");
	    	long d_id = sc.nextLong();
			
	    	Crud.ajouterArtisane(ar_id, w_id, d_id);
	    	System.out.println("Artisane ajoutee.");
	    	break;
	
      	case 2:
		//Ajouter Shop 
	    	System.out.println("Donner l'id de l'artisane : ");
	    	long a_id = sc.nextLong();
	    	System.out.println("Donner l'id de la wilaya : ");
	    	long wilaya_id = sc.nextLong();
	    	System.out.println("Donner l'id du Shop : ");
	    	long s_id = sc.nextLong();
			
	    	Crud.ajouterShop(s_id, a_id, wilaya_id);
	    	System.out.println("Shop ajoute.");
	    	break;
      	case 3:
	    //Ajouter Client
	    	System.out.println("Donner l'id du client : ");
	    	long cl_id = sc.nextLong();
	    	System.out.println("Donner l'id de la wilaya : ");
	    	long w2_id = sc.nextLong();
	    	
	    	Crud.ajouterClient(cl_id, w2_id);
	    	System.out.println("Client ajoute.");
	      	break;
      	}
        // SAVE A SNAPSHOT
         OntologyUtilityFactory.getInstance().saveOntology();

	}

}
