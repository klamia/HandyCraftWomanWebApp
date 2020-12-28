package dz.com.cerist.artisanat.commons.utils;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class CrudJena {
private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	public CrudJena() {
			
	}
	
	 
	public List<Individual> getIndividuals(OntModel model, OntClass ontClass) {
		
		List<Individual> individuals = new ArrayList<Individual>();
        ExtendedIterator<Individual> iterator = model.listIndividuals(ontClass);

        while (iterator.hasNext()) {
            Individual individual = iterator.next();
            individuals.add(individual);
        }

       return individuals;
	
	}
	
	public Individual getIndividual(Long id, String cls, List<Individual> individuals) {
		@SuppressWarnings("unused")
		DatatypeProperty datatypeProperty;
		for(Individual ind:individuals) {
			if(ind.getLocalName().equals(cls+"_"+id)) {
				return ind;
			}
		}
		return null;
	}
	
	public static void addClient(Long id_cl, Long id_w, OntModel model) {
		//Individual 
		//Create an individual client
		OntClass clientClass = model.getOntClass(NAMESPACE + "Client");
		Individual clientIndividual = model.createIndividual(NAMESPACE + "Client_"+id_cl, clientClass);
		DatatypeProperty datatypePropoerty = model.getDatatypeProperty(NAMESPACE+ "hasId");
		clientIndividual.addProperty(datatypePropoerty, id_cl.toString(), XSDDatatype.XSDlong);
		
		Individual wilayaIndividual = model.getIndividual(NAMESPACE+ "Wilaya_"+id_w);
		ObjectProperty vivreAu = model.getObjectProperty(NAMESPACE + "vivreAu");
		clientIndividual.addProperty(vivreAu, wilayaIndividual);
				/*OntClass clientClass = instance.getOntModel().getOntClass(NAMESPACE + "Client");
				Individual clientIndividual = instance.getOntModel().createIndividual(NAMESPACE + "Client_" + id_client,clientClass);
				DatatypeProperty datatypeProperty = instance.getOntModel().getDatatypeProperty(NAMESPACE + "hasId");
				clientIndividual.addProperty(datatypeProperty, new Long(client.getId()).toString(), XSDDatatype.XSDlong);
				
				//Associate the client individual with the wilaya
				Individual wilayaIndividual = instance.getOntModel().getIndividual(NAMESPACE + "Wilaya_"+id_wilaya);
				ObjectProperty vivreAu = instance.getOntModel().getObjectProperty(NAMESPACE + "vivreAu");
				clientIndividual.addProperty(vivreAu, wilayaIndividual);*/
						
	}

}
