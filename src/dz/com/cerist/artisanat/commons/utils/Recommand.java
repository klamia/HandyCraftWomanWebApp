package dz.com.cerist.artisanat.commons.utils;
import java.util.ArrayList;
import java.util.Iterator;




import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.PrintUtil;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;



public class Recommand {
	public Recommand() {
		
	}
	
	private final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	
	public static void printStatements(Model m, Resource s, Property p, Resource o) {
    	int nb = 0;
        for (StmtIterator i = m.listStatements(s,p,o); i.hasNext(); ) {
        	nb++;
        	System.out.println("Le nombre de statement = "+nb);
            Statement stmt = i.nextStatement();
            System.out.println(" - " + PrintUtil.print(stmt));
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList recInteretDomaine(InfModel inf, Resource cl) {
    	ArrayList v = new ArrayList();
    	Property p = inf.createProperty(NAMESPACE, "aRecommandeShop");
    	Resource shop;
    	Property dp = inf.createProperty(NAMESPACE, "hasId");
    	StmtIterator i = inf.listStatements(null,p,cl);
        while(i.hasNext()){     
        	Statement stmt = i.nextStatement();
        	shop = stmt.getSubject();
        	//StmtIterator it = shop.listProperties();
        	
        	Statement s = shop.getProperty(dp);
        	long id = s.getLiteral().getLong();
        	//System.out.println(id);
        	
           // System.out.println(" - " + PrintUtil.print(stmt));
        	//v.add(shop.getLocalName().toString());
        	v.add(id);
        	//System.out.println(" - " + shop.getLocalName().toString());
            
        } 
        return v;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList listeShop(InfModel inf, OntModel m) {
    	ArrayList v = new ArrayList();
    	//Property p = inf.createProperty(NAMESPACE, "aRecommandeShop");
    	Resource shop = m.getResource(NAMESPACE+"Shops");
    	Property dp = inf.createProperty(NAMESPACE, "hasId");
    	ExtendedIterator<Individual> individuals = m.listIndividuals(shop);
    	//System.out.println("List of individuals");
        while(individuals.hasNext())
        {
            Individual ind = (Individual) individuals.next();
            Statement s = ind.getProperty(dp);
        	long id = s.getLiteral().getLong();
        	//System.out.println(id);
            //System.out.println(ind);
            //v.add(ind.getLocalName().toString());
            v.add(id);
            
        }
    	
        return v;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList recWilaya(InfModel inf, Resource cl) {
    	ArrayList v = new ArrayList();
    	Property p = inf.createProperty(NAMESPACE, "aRecommandeWilaya");
    	Resource shop;
    	Property dp = inf.createProperty(NAMESPACE, "hasId");
    	StmtIterator i = inf.listStatements(null,p,cl);
        while(i.hasNext()){     
        	Statement stmt = i.nextStatement();
        	shop = stmt.getSubject();
        	Statement s = shop.getProperty(dp);
        	long id = s.getLiteral().getLong();
        	//System.out.println(id);
            //System.out.println(" - " + PrintUtil.print(stmt));
        	//v.add(shop.getLocalName().toString());
        	v.add(id);
        	//System.out.println(" - " + shop.getLocalName().toString());
            
        } 
        return v;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList recLocalisation(InfModel inf, Resource cl) {
    	ArrayList v = new ArrayList();
    	Property p = inf.createProperty(NAMESPACE, "aRecommandeLocal");
    	Resource shop;
    	Property dp = inf.createProperty(NAMESPACE, "hasId");
    	StmtIterator i = inf.listStatements(null,p,cl);
        while(i.hasNext()){     
        	Statement stmt = i.nextStatement();
        	shop = stmt.getSubject();
        	Statement s = shop.getProperty(dp);
        	long id = s.getLiteral().getLong();
        	//System.out.println(id);
            //System.out.println(" - " + PrintUtil.print(stmt));
        	//v.add(shop.getLocalName().toString());
        	v.add(id);
        	//System.out.println(" - " + shop.getLocalName().toString());
            
        } 
        return v;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList recLocalisationProche(InfModel inf, Resource cl) {
    	ArrayList v = new ArrayList();
    	Property p = inf.createProperty(NAMESPACE, "aRecommandeLocalProche");
    	Resource shop;
    	Property dp = inf.createProperty(NAMESPACE, "hasId");
    	StmtIterator i = inf.listStatements(null,p,cl);
        while(i.hasNext()){     
        	Statement stmt = i.nextStatement();
        	shop = stmt.getSubject();
        	Statement s = shop.getProperty(dp);
        	long id = s.getLiteral().getLong();
        	//System.out.println(id);
            //System.out.println(" - " + PrintUtil.print(stmt));
        	//v.add(shop.getLocalName().toString());
        	v.add(id);
        	//System.out.println(" - " + shop.getLocalName().toString());
        } 
        return v;
    }
    
   /* public static void recommandation(ArrayList v1, ArrayList v2) {
    	Object o1, o2;
    	Iterator it1 = v1.iterator();
    	Iterator it2 = v2.iterator();
    	while(it1.hasNext()) {
    		o1 = it1.next();
    		if(v2.contains(o1)) {
    			if(!vecRec1.contains(o1))
    				vecRec1.add(o1);
    		}
    		else {
    			vecRec2.add(o1);
    		}
    	}
    	while(it2.hasNext()) {
    		o2 = it2.next();
    		if(v1.contains(o2)) {
    			if(!vecRec1.contains(o2))
    				vecRec1.add(o2);
    		}
    		else {
    			vecRec3.add(o2);
    		}
    	}
    }*/
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList recommandCommun(ArrayList v1, ArrayList v2) {
    	ArrayList v = new ArrayList();
    	Object o1, o2;
    	Iterator it1 = v1.iterator();
    	Iterator it2 = v2.iterator();
    	while(it1.hasNext()) {
    		o1 = it1.next();
    		if(v2.contains(o1)) {
    			if(!v.contains(o1))
    				v.add(o1);
    		}
    	}
    	while(it2.hasNext()) {
    		o2 = it2.next();
    		if(v1.contains(o2)) {
    			if(!v.contains(o2))
    				v.add(o2);
    		}
    	}
    	return v;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static  ArrayList recommandDiff(ArrayList v1, ArrayList v2) {
    	ArrayList v = new ArrayList();
    	Object o1, o2;
    	Iterator it1 = v1.iterator();
    	Iterator it2 = v2.iterator();
    	while(it1.hasNext()) {
    		o1 = it1.next();
    		if(!v2.contains(o1)) {
    			if(!v.contains(o1))
    				v.add(o1);
    		}
    	}
    	while(it2.hasNext()) {
    		o2 = it2.next();
    		if(!v1.contains(o2)) {
    			if(!v.contains(o2))
    				v.add(o2);
    		}
    	}
    	return v;
    }
    @SuppressWarnings("rawtypes")
	public static void printRec(ArrayList v) {
    	Iterator it = v.iterator();
    	while(it.hasNext()){ 
    		Object o = it.next();
    		   System.out.println(o); 
    		   //System.out.println("L'element existe dans vecLocalisation "+existe(vecLocalisation,o));
    	}
    }
    
	@SuppressWarnings("rawtypes")
	public static ArrayList recommandOther(InfModel inf, OntModel m, ArrayList v1, ArrayList v2) {
		ArrayList vec1 =new ArrayList();
		ArrayList vec2 =new ArrayList();
		ArrayList v =new ArrayList();
		vec1 = recommandDiff(listeShop(inf, m), v1);
		vec2 = recommandDiff(listeShop(inf, m), v2);
		v = recommandCommun(vec1, vec2);
		return v;
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList recommandLevel(ArrayList vecD, ArrayList vecL) {
		ArrayList v = new ArrayList();
		if (vecD.size() == 0) {
			v = vecL;
		}else {
			if(vecL.size() == 0){
				v = vecD;
			}else {
				v = recommandCommun(vecD, vecL);
			}
		}
		
		return v;
	}
	
	
}