package dz.com.cerist.artisanat.web.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

import dz.com.cerist.artisanat.commons.utils.Update_ont;

import ro.tuc.dsrl.m2o.ontology.utility.JenaUtility;
import ro.tuc.dsrl.m2o.ontology.utility.OntologyUtilityFactory;
import ro.tuc.dsrl.m2o.utility.PropertiesLoader;

public class Main_update {

	private static final Log LOGGER = LogFactory.getLog(Main_update.class);
	//private static String CONFIG_FILE = "/artisanat-config.config";
	//private static PropertiesLoader prop;
	private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	//static Model model = ModelFactory.createDefaultModel();
	static String inputFileName = "profil_rdf.owl";
	static OntModel ontModel = ModelFactory.createOntologyModel();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PropertiesLoader.setConfigFile(CONFIG_FILE);
		//JenaUtility instance = JenaUtility.getInstance();
		
		InputStream in = FileManager.get().open( inputFileName );
		ontModel.read(in, null);
    	
		Update_ont crud = new Update_ont();
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
			
	    	crud.addArtisane(ar_id, w_id, d_id, ontModel);
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
			
	    	crud.addShop(s_id, a_id, wilaya_id, ontModel);
	    	System.out.println("Shop ajoute.");
	    	break;
      	case 3:
	    //Ajouter Client
	    	System.out.println("Donner l'id du client : ");
	    	long cl_id = sc.nextLong();
	    	System.out.println("Donner l'id de la wilaya : ");
	    	long w2_id = sc.nextLong();
	    	
	    	crud.addClient(cl_id, w2_id, ontModel);
	    	System.out.println("Client ajoute.");
	      	break;
	      	
      	}
        // SAVE A SNAPSHOT
        // OntologyUtilityFactory.getInstance().saveOntology();
      	try {
			ontModel.write(new FileOutputStream(inputFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
