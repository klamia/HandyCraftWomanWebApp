package dz.com.cerist.artisanat.commons.utils;


import java.util.ArrayList;
import java.util.Iterator;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.PrintUtil;






public class Recommand_prod {
	public Recommand_prod(){
		
	}
	
	final static String NAMESPACE = "http://www.semanticweb.org/islam/ontologies/2018/0/Profil#";
	
	
	public static void printStatements(Model m, Resource s, Property p, Resource o) {
    	int nb = 0;
        for (StmtIterator i = m.listStatements(s,p,o); i.hasNext(); ) {
        	nb++;
        	System.out.println("Le nombre de statement = "+nb);
            Statement stmt = i.nextStatement();
            System.out.println(" - " + PrintUtil.print(stmt));
        }
    }
	
	 public void printRec(@SuppressWarnings("rawtypes") ArrayList v) {
	    	@SuppressWarnings("rawtypes")
			Iterator it = v.iterator();
	    	while(it.hasNext()){ 
	    		Object o = it.next();
	    		   System.out.println(o); 
	    		   //System.out.println("L'element existe dans vecLocalisation "+existe(vecLocalisation,o));
	    	}
	    }
	
	/* public static void recommand (long id_sh, OntModel model) {
		 String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
					"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
						"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+
						"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
						"PREFIX base:<http://www.semanticweb.org/islam/ontologies/2018/0/Profil#>"+
						"SELECT ?produit ?shop\r\n" + 
						"	WHERE {  " + 
						"	?produit rdf:type base:Produit.\r\n" +
						"	?shop rdf:type base:Shops.\r\n" + 
						"	?produit base:appartientAShop ?shop.\r\n" + 
						"	FILTER (?shop IN(base:Shops_"+id_sh+"))\r\n" + 
						"	}";
		 
		 	Query query = QueryFactory.create(queryString);
	        QueryExecution qexec = QueryExecutionFactory.create(query, model);
	        try {
	            ResultSet results = qexec.execSelect();
	            while ( results.hasNext() ) {
	                QuerySolution soln = results.nextSolution();
	                Literal name = soln.getLiteral("name");
	                System.out.println(name);
	            }
	        } finally {
	            qexec.close();
	        }
	 }
	 */
	  
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList prodShop(InfModel inf, Resource sh) {
		 ArrayList v = new ArrayList();
		 Property ps = inf.createProperty(NAMESPACE, "appartientAShop");
		 Resource shop;
		 Property dps = inf.createProperty(NAMESPACE, "hasId");
		 StmtIterator i = inf.listStatements(null,ps,sh);
	        while(i.hasNext()){     
	        	Statement stmt = i.nextStatement();
	        	shop = stmt.getSubject();
	        	//StmtIterator it = produit.listProperties();
	        	
	        	Statement s = shop.getProperty(dps);
	        	long id = s.getLiteral().getLong();
	        	//System.out.println(id);
	        	
	           // System.out.println(" - " + PrintUtil.print(stmt));
	        	//v.add(produit.getLocalName().toString());
	        	v.add(id);
	        	//System.out.println(" - " + produit.getLocalName().toString());
	            
	        } 
		 return v;
	 }
	 
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList prodCommun(ArrayList v1, ArrayList v2) {
			ArrayList v = new ArrayList(); 
			Iterator it1 = v1.iterator();
			Object o1;
			
			while(it1.hasNext()){
	    		o1 = it1.next();
	    		if(v2.contains(o1))
	    			v.add(o1);
	    	}	
	    	
			return v;
		}
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList recommandProd(InfModel inf, Resource cl, Resource sh) {
		ArrayList vRec = new ArrayList();
		ArrayList vProd = new ArrayList();
		ArrayList v = new ArrayList();
		
		//liste des produit � recommander au client cl
		Property p = inf.createProperty(NAMESPACE, "aRecommandeProd");
    	Resource produit;
    	Property dp = inf.createProperty(NAMESPACE, "hasId");    	
    	StmtIterator i = inf.listStatements(null,p,cl);
        while(i.hasNext()){     
        	Statement stmt = i.nextStatement();
        	produit = stmt.getSubject();
        	//StmtIterator it = produit.listProperties();
        	
        	Statement s = produit.getProperty(dp);
        	long id = s.getLiteral().getLong();

        	vRec.add(id);
        	
        } 
        vProd = prodShop(inf, sh);
        v = prodCommun(vRec, vProd);   
		return v;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList recommandProdCoul(InfModel inf, Resource cl) {
		ArrayList v = new ArrayList();
		Property p = inf.createProperty(NAMESPACE, "aRecommandeProdCoul");
    	Resource produit;
    	Property dp = inf.createProperty(NAMESPACE, "hasId");
    	StmtIterator i = inf.listStatements(null,p,cl);
        while(i.hasNext()){     
        	Statement stmt = i.nextStatement();
        	produit = stmt.getSubject();
        	Statement s = produit.getProperty(dp);
        	long id = s.getLiteral().getLong();
        	v.add(id);
        	 
        } 
		
		return v;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList recommandProdTend(InfModel inf, Resource cl) {
		ArrayList<Long> v = new ArrayList();
		Property p = inf.createProperty(NAMESPACE, "aRecommandeProdTend");
    	Resource produit;
    	Property dp = inf.createProperty(NAMESPACE, "hasId");
    	StmtIterator i = inf.listStatements(null,p,cl);
        while(i.hasNext()){     
        	Statement stmt = i.nextStatement();
        	produit = stmt.getSubject();
        	Statement s = produit.getProperty(dp);
        	long id = s.getLiteral().getLong();
        	v.add(id);
        	 
        } 
		
		return v;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList recommandRest(ArrayList v1, ArrayList v2) {
		ArrayList v = new ArrayList(); 
		Iterator it1 = v1.iterator();
		Object o1;
		
		while(it1.hasNext()){
    		o1 = it1.next();
    		if (!v2.contains(o1)) 
    			v.add(o1);
    	}	
	
		return v;
	}
	
	
}
