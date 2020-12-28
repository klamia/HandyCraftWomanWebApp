package dz.com.cerist.artisanat.entite.ontology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ro.tuc.dsrl.m2o.annotations.InstanceIdentifier;
import ro.tuc.dsrl.m2o.annotations.ObjectProperty;
import ro.tuc.dsrl.m2o.annotations.OntologyEntity;


@OntologyEntity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7014718746729021635L;

	@InstanceIdentifier
	private long id;
	
	@ObjectProperty(value = "aPreference", range = Preference.class)
    private List<Preference> preferences;
	@ObjectProperty(value = "aInteret", range = CentreInteret.class)
    private List<CentreInteret> interets;
	@ObjectProperty(value = "aCompetence", range = Competence.class)
    private List<Competence> competences;
	@ObjectProperty(value = "aCompInformatique", range = Informatique.class)
    private List<Competence> computerliteracys;
	@ObjectProperty(value = "aDiplome", range = Diplome.class)
    private List<Competence> diplomes;
	@ObjectProperty(value = "aLangue", range = Langue.class)
    private List<Competence> langages;
	@ObjectProperty(value = "aCapaciteCongnitive", range = CapaciteCognitive.class)
    private List<Aptitude> capaciteCongnitives;
	@ObjectProperty(value = "aCapacitePhysique", range = CapacitePhysique.class)
    private List<Aptitude> capacitePhysiques;
	@ObjectProperty(value = "aCapaciteMotrice", range = CapaciteMotrice.class)
    private List<Aptitude> capaciteMotrices;
	@ObjectProperty(value = "aCapaciteSensorielle", range = CapaciteSensorielle.class)
    private List<Aptitude> capaciteSensorielles;
	@ObjectProperty(value = "utiliseTag", range = Tag.class)
    private List<Tag> tags;
	@ObjectProperty(value = "utiliseTagProd", range = TagProduit.class)
    private List<Tag> tagProduits;
	@ObjectProperty(value = "utilseTagUser", range = TagUtilisateur.class)
    private List<Tag> tagUtilisateurs;
	@ObjectProperty(value = "vivreAu", range = Wilaya.class)
    private Wilaya wilaya ;
	
	public User() {
		
	}
	
	public User(long id, Wilaya wilaya) {
		super();
		this.id = id;
		this.wilaya = wilaya;
		this.preferences = new ArrayList<Preference>();
		this.interets = new ArrayList<CentreInteret>();
		this.competences = new ArrayList<Competence>();
		this.computerliteracys = new ArrayList<Competence>();
		this.diplomes = new ArrayList<Competence>();
		this.langages = new ArrayList<Competence>();
		this.capaciteCongnitives = new ArrayList<Aptitude>();
		this.capacitePhysiques = new ArrayList<Aptitude>();
		this.capaciteMotrices = new ArrayList<Aptitude>();
		this.capaciteSensorielles = new ArrayList<Aptitude>();
		this.tagProduits = new ArrayList<Tag>();
		this.tagProduits = new ArrayList<Tag>();
		this.tags = new ArrayList<Tag>();
	}
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Wilaya getWilaya() {
		return wilaya;
	}

	public void setWilaya(Wilaya wilaya) {
		this.wilaya = wilaya;
	}

	public List<Preference> getPreferences() {
	    return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}
	public List<CentreInteret> getInterets() {
	    return interets;
	}

	public void setInterets(List<CentreInteret> interets) {
		this.interets = interets;
	}
	public List<Competence> getCompetences() {
	    return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	
	public List<Competence> getComputerliteracys() {
	    return computerliteracys;
	}

	public void setComputerliteracys(List<Competence> computerliteracys) {
		this.computerliteracys = computerliteracys;
	}
	
	public List<Competence> getDiplomes() {
	    return diplomes;
	}

	public void setDiplomes(List<Competence> diplomes) {
		this.diplomes = diplomes;
	}
	
	public List<Competence> getLangages() {
	    return langages;
	}

	public void setLangages(List<Competence> langages) {
		this.langages = langages;
	}
	
	public List<Aptitude> getCapaciteCongnitives() {
	    return capaciteCongnitives;
	}

	public void setCapaciteCongnitives(List<Aptitude> capacitePhysiques) {
		this.capacitePhysiques = capacitePhysiques;
	}
	public List<Aptitude> getCapacitePhysiques() {
	    return capacitePhysiques;
	}

	public void setCapacitePhysiques(List<Aptitude> capaciteCongnitives) {
		this.capaciteCongnitives = capaciteCongnitives;
	}
	public List<Aptitude> getCapaciteMotrices() {
	    return capaciteMotrices;
	}

	public void setCapaciteMotrices(List<Aptitude> capaciteMotrices) {
		this.capaciteMotrices = capaciteMotrices;
	}
	public List<Aptitude> getCapaciteSensorielles() {
	    return capaciteSensorielles;
	}

	public void setCapaciteSensorielles(List<Aptitude> capaciteSensorielles) {
		this.capaciteSensorielles = capaciteSensorielles;
	}
	public List<Tag> getTagProduits() {
	    return tagProduits;
	}

	public void setTagProduits(List<Tag> tagProduits) {
		this.tagProduits = tagProduits;
	}
	public List<Tag> getTagUtilisateurs() {
	    return tagUtilisateurs;
	}

	public void setTagUtilisateurs(List<Tag> tagUtilisateurs) {
		this.tagUtilisateurs = tagUtilisateurs;
	}
}
