package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import dz.com.cerist.artisanat.entite.Activites;
import dz.com.cerist.artisanat.entite.Capacitecogns;
import dz.com.cerist.artisanat.entite.Capacitephys;

import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.entite.Centresinterets;
import dz.com.cerist.artisanat.entite.Computerliteracys;
import dz.com.cerist.artisanat.entite.Couleurs;
import dz.com.cerist.artisanat.entite.Diplomes;
import dz.com.cerist.artisanat.entite.Langages;
import dz.com.cerist.artisanat.entite.Shop;
import dz.com.cerist.artisanat.entite.SpecialiteDiplome;
import dz.com.cerist.artisanat.entite.Tendances;
import dz.com.cerist.artisanat.entite.Wilayas;
import dz.com.cerist.artisanat.service.IActiviteService;
import dz.com.cerist.artisanat.service.ICapacitecognsService;
import dz.com.cerist.artisanat.service.ICapacitephysService;
import dz.com.cerist.artisanat.service.ICategorieService;
import dz.com.cerist.artisanat.service.ICentresinteretsService;
import dz.com.cerist.artisanat.service.IComputerliteracysService;
import dz.com.cerist.artisanat.service.ICouleurService;
import dz.com.cerist.artisanat.service.IDiplomeService;
import dz.com.cerist.artisanat.service.ILangageService;
import dz.com.cerist.artisanat.service.ITendanceService;

import dz.com.cerist.artisanat.service.ISpecialiteDiplomeService;
import dz.com.cerist.artisanat.service.IWilayaService;





@ManagedBean(name = "autoCompleteBean")
@RequestScoped
public class AutoCompleteBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 10101010;

	private String txt1;

	private String txt2;

	private String txt3;

	private String txt4;

	private String txt5;

	private String txt6;

	private String txt7;


	private Tendances selectedTendance;
	
	private List<Tendances> tendances;
	private List<SelectItem> selectItemTendances;
	@ManagedProperty(name = "iTendanceService", value = "#{iTendanceService}")
	private ITendanceService iTendanceService;
	private List<Tendances> selectedTendances;
	
    
	
	public Tendances getSelectedTendance() {
		return selectedTendance;
	}

	public void setSelectedTendance(Tendances selectedTendance) {
		this.selectedTendance = selectedTendance;
	}

	public List<Tendances> getTendances() {
		tendances = iTendanceService.getAllTendances();
		return tendances;
	}

	public void setTendances(List<Tendances> tendances) {
		this.tendances = tendances;
	}

	public List<SelectItem> getSelectItemTendances() {
		getTendances();
		
		selectItemTendances = new ArrayList<SelectItem>();
			
			for (Tendances td:tendances){
				
				selectItemTendances.add(new SelectItem(td, td.getIntitule()));
			}
			
			System.out.println("Size:" +selectItemTendances.size());
		
		return selectItemTendances;
	}

	public void setSelectItemTendances(List<SelectItem> selectItemTendances) {
		this.selectItemTendances = selectItemTendances;
	}

	public ITendanceService getiTendanceService() {
		return iTendanceService;
	}

	public void setiTendanceService(ITendanceService iTendanceService) {
		this.iTendanceService = iTendanceService;
	}

	public List<Tendances> getSelectedTendances() {
		return selectedTendances;
	}

	public void setSelectedTendances(List<Tendances> selectedTendances) {
		this.selectedTendances = selectedTendances;
	}

	
	
	

/*************************************************************************************************************/	
	
private Couleurs selectedCouleur;
	
	private List<Couleurs> couleurs;
	private List<SelectItem> selectItemCouleurs;
	@ManagedProperty(name = "iCouleurService", value = "#{iCouleurService}")
	private ICouleurService iCouleurService;
	private List<Couleurs> selectedCouleurs;
	

	public Couleurs getSelectedCouleur() {
		return selectedCouleur;
	}
	public void setSelectedCouleur(Couleurs selectedCouleur) {
		this.selectedCouleur = selectedCouleur;
	}
	public List<Couleurs> getCouleurs() {
		couleurs = iCouleurService.getAllCouleurs();
		return couleurs;
	}
	public void setCouleurs(List<Couleurs> couleurs) {
		this.couleurs = couleurs;
	}
	public List<SelectItem> getSelectItemCouleurs() {
		getCouleurs();
		
		selectItemCouleurs = new ArrayList<SelectItem>();
			
			for (Couleurs cr:couleurs){
				
				selectItemCouleurs.add(new SelectItem(cr, cr.getIntitule()));
			}
			
			System.out.println("Size:" +selectItemCouleurs.size());
		
		
		return selectItemCouleurs;
	}
	public void setSelectItemCouleurs(List<SelectItem> selectItemCouleurs) {
		this.selectItemCouleurs = selectItemCouleurs;
	}
	public ICouleurService getiCouleurService() {
		return iCouleurService;
	}
	public void setiCouleurService(ICouleurService iCouleurService) {
		this.iCouleurService = iCouleurService;
	}
	public List<Couleurs> getSelectedCouleurs() {
		return selectedCouleurs;
	}
	public void setSelectedCouleurs(List<Couleurs> selectedCouleurs) {
		this.selectedCouleurs = selectedCouleurs;
	}
	
	
	
	
/*----------------------------------------------------------------------------------------------------------------------------------------*/
		
	private Wilayas selectedWilaya;
	
	private List<Wilayas> wilayas;
	private List<SelectItem> selectItemWilayas;
	@ManagedProperty(name = "iWilayaService", value = "#{iWilayaService}")
	private IWilayaService iWilayaService;
	private List<Wilayas> selectedWilayas;
	
	public Wilayas getSelectedWilaya() {
		return selectedWilaya;
	}
	public void setSelectedWilaya(Wilayas selectedWilaya) {
		this.selectedWilaya = selectedWilaya;
	}
	public List<Wilayas> getWilayas() {
		wilayas = iWilayaService.getAllWilaya();
		
		
		return wilayas;
	}
	public void setWilayas(List<Wilayas> wilayas) {
		this.wilayas = wilayas;
	}
	public List<SelectItem> getSelectItemWilayas() {
		
		getWilayas();
		
	       selectItemWilayas = new ArrayList<SelectItem>();
			
			for (Wilayas w:wilayas){
				
				selectItemWilayas.add(new SelectItem(w, w.getNom()));
			}
			
			System.out.println("Size:" +selectItemWilayas.size());
		
		
		return selectItemWilayas;
	}
	public void setSelectItemWilayas(List<SelectItem> selectItemWilayas) {
		this.selectItemWilayas = selectItemWilayas;
	}
	public IWilayaService getiWilayaService() {
		return iWilayaService;
	}
	public void setiWilayaService(IWilayaService iWilayaService) {
		this.iWilayaService = iWilayaService;
	}
	public List<Wilayas> getSelectedWilayas() {
		return selectedWilayas;
	}
	public void setSelectedWilayas(List<Wilayas> selectedWilayas) {
		this.selectedWilayas = selectedWilayas;
	}
	
	
	
	/*
	private Role selectedRole;
	private List<Role> roles;
	private List<SelectItem> selectItemRoles;
	@ManagedProperty(name = "iRoleService", value = "#{iRoleService}")
	private IRoleService iRoleService;
	private List<Role> selectedRoles;
	
	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}

	public List<Role> getRoles() {
		roles = iRoleService.findAllroles();
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<SelectItem> getSelectItemRoles() {
		
		getRoles();
		
	       selectItemRoles = new ArrayList<SelectItem>();
			
			for (Role r:roles){
				
				selectItemRoles.add(new SelectItem(r, r.getIntitulerole()));
			}
			
			System.out.println("Size:" +selectItemRoles.size());
		
		return selectItemRoles;
	}

	public void setSelectItemRoles(List<SelectItem> selectItemRoles) {
		this.selectItemRoles = selectItemRoles;
	}

	public IRoleService getiRoleService() {
		return iRoleService;
	}

	public void setiRoleService(IRoleService iRoleService) {
		this.iRoleService = iRoleService;
	}

	public List<Role> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<Role> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
*/

/*----------------------------------------------------------------------------------------------------------------------------------------*/
	
	private Langages selectedLangage;
	private List<Langages> langages;
	private List<SelectItem> selectItemLangages;
	@ManagedProperty(name = "iLangageService", value = "#{iLangageService}")
	private ILangageService iLangageService;
	private List<Langages> selectedLangages;
	

	public Langages getSelectedLangage() {
		return selectedLangage;
	}
	public void setSelectedLangage(Langages selectedLangage) {
		this.selectedLangage = selectedLangage;
	}
	public List<Langages> getLangages() {
		
		langages=iLangageService.getAllLangages();
		return langages;
	}
	public void setLangages(List<Langages> langages) {
		this.langages = langages;
	}
	public List<SelectItem> getSelectItemLangages() {
		
		getLangages();
		
	       selectItemLangages = new ArrayList<SelectItem>();
			
			for (Langages l:langages){
				
				selectItemLangages.add(new SelectItem(l, l.getNom()));
			}
			
			System.out.println("Size:" +selectItemLangages.size());
		
		return selectItemLangages;
	}
	public void setSelectItemLangages(List<SelectItem> selectItemLangages) {
		this.selectItemLangages = selectItemLangages;
	}
	public ILangageService getiLangageService() {
		return iLangageService;
	}
	public void setiLangageService(ILangageService iLangageService) {
		this.iLangageService = iLangageService;
	}
	public List<Langages> getSelectedLangages() {
		return selectedLangages;
	}
	public void setSelectedLangages(List<Langages> selectedLangages) {
		this.selectedLangages = selectedLangages;
	}
	

	

	
/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	private Activites selectedActivite;
	private List<Activites> activites;
	private List<SelectItem> selectItemActivites;
	@ManagedProperty(name = "iActiviteService", value = "#{iActiviteService}")
	private IActiviteService iActiviteService;
	private List<Langages> selectedActivites;
	

	public Activites getSelectedActivite() {
		return selectedActivite;
	}
	public void setSelectedActivite(Activites selectedActivite) {
		this.selectedActivite = selectedActivite;
	}
	public List<Activites> getActivites() {
		
		activites = iActiviteService.getAllActivites();
		return activites;
	}
	public void setActivites(List<Activites> activites) {
		this.activites = activites;
	}
	public List<SelectItem> getSelectItemActivites() {
		
		getActivites();
		
	       selectItemActivites = new ArrayList<SelectItem>();
			
			for (Activites ac:activites){
				
				selectItemActivites.add(new SelectItem(ac, ac.getNom()));
			}
			
			System.out.println("Size:" +selectItemActivites.size());
		
		
		return selectItemActivites;
	}
	
	public void setSelectItemActivites(List<SelectItem> selectItemActivites) {
		this.selectItemActivites = selectItemActivites;
	}
	public IActiviteService getiActiviteService() {
		return iActiviteService;
	}
	public void setiActiviteService(IActiviteService iActiviteService) {
		this.iActiviteService = iActiviteService;
	}
	public List<Langages> getSelectedActivites() {
		return selectedActivites;
	}
	public void setSelectedActivites(List<Langages> selectedActivites) {
		this.selectedActivites = selectedActivites;
	}
	
/*----------------------------------------------------------------------------------------------------------------------------------*/	
	private Diplomes selectedDiplome;
	private List<Diplomes> diplomes;
	private List<SelectItem> selectItemDiplomes;
	@ManagedProperty(name = "iDiplomeService", value = "#{iDiplomeService}")
	private IDiplomeService iDiplomeService;
	private List<Diplomes> selectedDiplomes;
	
	public Diplomes getSelectedDiplome() {
		return selectedDiplome;
	}
	public void setSelectedDiplome(Diplomes selectedDiplome) {
		this.selectedDiplome = selectedDiplome;
	}
	public List<Diplomes> getDiplomes() {
		
		diplomes= iDiplomeService.getAllDiplomes();
		return diplomes;
	}
	public void setDiplomes(List<Diplomes> diplomes) {
		this.diplomes = diplomes;
	}
	public List<SelectItem> getSelectItemDiplomes() {
		getDiplomes();
		
		selectItemDiplomes = new ArrayList<SelectItem>();
		
		for (Diplomes dp:diplomes){
			
			selectItemDiplomes.add(new SelectItem(dp, dp.getNom()));
		}
		
		System.out.println("Size:" +selectItemDiplomes.size());
		
		return selectItemDiplomes;
	}
	public void setSelectItemDiplomes(List<SelectItem> selectItemDiplomes) {
		this.selectItemDiplomes = selectItemDiplomes;
	}
	public IDiplomeService getiDiplomeService() {
		return iDiplomeService;
	}
	public void setiDiplomeService(IDiplomeService iDiplomeService) {
		this.iDiplomeService = iDiplomeService;
	}
	public List<Diplomes> getSelectedDiplomes() {
		return selectedDiplomes;
	}
	public void setSelectedDiplomes(List<Diplomes> selectedDiplomes) {
		this.selectedDiplomes = selectedDiplomes;
	}

	
/*---------------------------------------------------------------------------------------------------------------------------------------------*/
	private Capacitephys selectedCapacitephy;
	private List<Capacitephys> capacitephyss;
	private List<SelectItem> selectItemCapacitephys;
	@ManagedProperty(name = "iCapacitephysService", value = "#{iCapacitephysService}")
	private ICapacitephysService iCapacitephysService;
	private List<Diplomes> selectedCapacitephys;
     
	
	public Capacitephys getSelectedCapacitephy() {
		return selectedCapacitephy;
	}
	public void setSelectedCapacitephy(Capacitephys selectedCapacitephy) {
		this.selectedCapacitephy = selectedCapacitephy;
	}
	public List<Capacitephys> getCapacitephyss() {
		capacitephyss= iCapacitephysService.getAllCapacitephys();
		return capacitephyss;
	}
	public void setCapacitephyss(List<Capacitephys> capacitephyss) {
		this.capacitephyss = capacitephyss;
	}
	public List<SelectItem> getSelectItemCapacitephys() {
		
		getCapacitephyss();
        selectItemCapacitephys = new ArrayList<SelectItem>();
		
		for (Capacitephys cp:capacitephyss){
			
			selectItemCapacitephys.add(new SelectItem(cp, cp.getNom()));
		}
		
		System.out.println("Size:" +selectItemCapacitephys.size());
		
		return selectItemCapacitephys;
	}
	public void setSelectItemCapacitephys(List<SelectItem> selectItemCapacitephys) {
		this.selectItemCapacitephys = selectItemCapacitephys;
	}
	public ICapacitephysService getiCapacitephysService() {
		return iCapacitephysService;
	}
	public void setiCapacitephysService(ICapacitephysService iCapacitephysService) {
		this.iCapacitephysService = iCapacitephysService;
	}
	public List<Diplomes> getSelectedCapacitephys() {
		return selectedCapacitephys;
	}
	public void setSelectedCapacitephys(List<Diplomes> selectedCapacitephys) {
		this.selectedCapacitephys = selectedCapacitephys;
	}

/*---------------------------------------------------------------------------------------------------*/
   
	private Capacitecogns selectedCapacitecogn;
	private List<Capacitecogns> capacitecognss;
	private List<SelectItem> selectItemCapacitecogn;
	@ManagedProperty(name = "iCapacitecognsService", value = "#{iCapacitecognsService}")
	private ICapacitecognsService iCapacitecognsService;
	private List<Diplomes> selectedCapacitecogns;
	

	public Capacitecogns getSelectedCapacitecogn() {
		return selectedCapacitecogn;
	}
	public void setSelectedCapacitecogn(Capacitecogns selectedCapacitecogn) {
		this.selectedCapacitecogn = selectedCapacitecogn;
	}
	public List<Capacitecogns> getCapacitecognss() {
		capacitecognss= iCapacitecognsService.getAllCapacitecogns();
		return capacitecognss;
	}
	public void setCapacitecognss(List<Capacitecogns> capacitecognss) {
		this.capacitecognss = capacitecognss;
	}
	public List<SelectItem> getSelectItemCapacitecogn() {
		
		getCapacitecognss();
        selectItemCapacitecogn = new ArrayList<SelectItem>();
		for (Capacitecogns cc:capacitecognss){
			
			selectItemCapacitecogn.add(new SelectItem(cc, cc.getNom()));
		}
		
		System.out.println("Size:" +selectItemCapacitecogn.size());
		
		return selectItemCapacitecogn;
	}
	public void setSelectItemCapacitecogn(List<SelectItem> selectItemCapacitecogn) {
		this.selectItemCapacitecogn = selectItemCapacitecogn;
	}
	public ICapacitecognsService getiCapacitecognsService() {
		return iCapacitecognsService;
	}
	public void setiCapacitecognsService(ICapacitecognsService iCapacitecognsService) {
		this.iCapacitecognsService = iCapacitecognsService;
	}
	public List<Diplomes> getSelectedCapacitecogns() {
		return selectedCapacitecogns;
	}
	public void setSelectedCapacitecogns(List<Diplomes> selectedCapacitecogns) {
		this.selectedCapacitecogns = selectedCapacitecogns;
	}

	/*----------------------------------------------------------------------------------------------------*/
     
	private Centresinterets selectedinteret;
	private List<Centresinterets> interets;
	private List<SelectItem> selectIteminteret;
	@ManagedProperty(name = "iCentresinteretsService", value = "#{iCentresinteretsService}")
	private ICentresinteretsService iCentresinteretsService;
	private List<Diplomes> selectedinterets;
	
	
	public Centresinterets getSelectedinteret() {
		return selectedinteret;
	}
	public void setSelectedinteret(Centresinterets selectedinteret) {
		this.selectedinteret = selectedinteret;
	}
	public List<Centresinterets> getInterets() {
		interets = iCentresinteretsService.getAllInterets();
		return interets;
	}
	public void setInterets(List<Centresinterets> interets) {
		this.interets = interets;
	}
	public List<SelectItem> getSelectIteminteret() {
		getInterets();
        selectIteminteret = new ArrayList<SelectItem>();
		
		for (Centresinterets ci:interets){
			
			selectIteminteret.add(new SelectItem(ci, ci.getNom()));
		}
		
		System.out.println("Size:" +selectIteminteret.size());
		
		return selectIteminteret;
	}
	public void setSelectIteminteret(List<SelectItem> selectIteminteret) {
		this.selectIteminteret = selectIteminteret;
	}
	public ICentresinteretsService getiCentresinteretsService() {
		return iCentresinteretsService;
	}
	public void setiCentresinteretsService(
			ICentresinteretsService iCentresinteretsService) {
		this.iCentresinteretsService = iCentresinteretsService;
	}
	public List<Diplomes> getSelectedinterets() {
		return selectedinterets;
	}
	public void setSelectedinterets(List<Diplomes> selectedinterets) {
		this.selectedinterets = selectedinterets;
	}

	/*---------------------------------------------------------------------------------------------------*/
	private Computerliteracys selectedComputerliteracy;
	private List<Computerliteracys> computerliteracys;
	private List<SelectItem> selectItemComputerliteracys;
	@ManagedProperty(name = "iComputerliteracysService", value = "#{iComputerliteracysService}")
	private IComputerliteracysService iComputerliteracysService;
	private List<Computerliteracys> selectedComputerliteracys;
	
	
	public Computerliteracys getSelectedComputerliteracy() {
		return selectedComputerliteracy;
	}
	public void setSelectedComputerliteracy(
			Computerliteracys selectedComputerliteracy) {
		this.selectedComputerliteracy = selectedComputerliteracy;
	}
	public List<Computerliteracys> getComputerliteracys() {
		
		computerliteracys= iComputerliteracysService.getAllComputerliteracys();
		return computerliteracys;
	}
	public void setComputerliteracys(List<Computerliteracys> computerliteracys) {
		this.computerliteracys = computerliteracys;
	}
	public List<SelectItem> getSelectItemComputerliteracys() {
		
		getComputerliteracys();
        selectItemComputerliteracys = new ArrayList<SelectItem>();
		
		for (Computerliteracys cl:computerliteracys){
			
			selectItemComputerliteracys.add(new SelectItem(cl, cl.getNom()));
		}
		
		System.out.println("Size:" +selectItemComputerliteracys.size());
		
		return selectItemComputerliteracys;
	}
	public void setSelectItemComputerliteracys(
			List<SelectItem> selectItemComputerliteracys) {
		this.selectItemComputerliteracys = selectItemComputerliteracys;
	}
	public IComputerliteracysService getiComputerliteracysService() {
		return iComputerliteracysService;
	}
	public void setiComputerliteracysService(
			IComputerliteracysService iComputerliteracysService) {
		this.iComputerliteracysService = iComputerliteracysService;
	}
	public List<Computerliteracys> getSelectedComputerliteracys() {
		return selectedComputerliteracys;
	}
	public void setSelectedComputerliteracys(
			List<Computerliteracys> selectedComputerliteracys) {
		this.selectedComputerliteracys = selectedComputerliteracys;
	}

    /*---------------------------------------------------------------------------------------------------*/
	    
	private SpecialiteDiplome selectedSpecialite;
	private List<SpecialiteDiplome> specialites;
	private List<SelectItem> selectItemSpecialite;
	@ManagedProperty(name = "iSpecialiteDiplomeService", value = "#{iSpecialiteDiplomeService}")
	private ISpecialiteDiplomeService iSpecialiteDiplomeService;
	private List<SpecialiteDiplome> selectedSpecialites;
	
	
	public SpecialiteDiplome getSelectedSpecialite() {
		return selectedSpecialite;
	}
	public void setSelectedSpecialite(SpecialiteDiplome selectedSpecialite) {
		this.selectedSpecialite = selectedSpecialite;
	}
	public List<SpecialiteDiplome> getSpecialites() {
		specialites = iSpecialiteDiplomeService.getAllSpecialite();
		return specialites;
	}
	public void setSpecialites(List<SpecialiteDiplome> specialites) {
		this.specialites = specialites;
	}
	public List<SelectItem> getSelectItemSpecialite() {
		getSpecialites();
        selectItemSpecialite = new ArrayList<SelectItem>();
		
		for (SpecialiteDiplome sd:specialites){
			
			selectItemSpecialite.add(new SelectItem(sd, sd.getIntitule()));
		}
		
		System.out.println("Size:" +selectItemSpecialite.size());
		
		
		return selectItemSpecialite;
	}
	public void setSelectItemSpecialite(List<SelectItem> selectItemSpecialite) {
		this.selectItemSpecialite = selectItemSpecialite;
	}
	public ISpecialiteDiplomeService getiSpecialiteDiplomeService() {
		return iSpecialiteDiplomeService;
	}
	public void setiSpecialiteDiplomeService(
			ISpecialiteDiplomeService iSpecialiteDiplomeService) {
		this.iSpecialiteDiplomeService = iSpecialiteDiplomeService;
	}
	public List<SpecialiteDiplome> getSelectedSpecialites() {
		return selectedSpecialites;
	}
	public void setSelectedSpecialites(List<SpecialiteDiplome> selectedSpecialites) {
		this.selectedSpecialites = selectedSpecialites;
	}
 
/*---------------------------------------------------------------------------------------------------*/
	
	private Category selectedCategorie;
	private List<Category> categories;
	private List<SelectItem> selectItemCategories;
	@ManagedProperty(name = "iCategorieService", value = "#{iCategorieService}")
	private ICategorieService iCategorieService;
	private List<Category> selectedCategories;
	

	public Category getSelectedCategorie() {
		return selectedCategorie;
	}
	public void setSelectedCategorie(Category selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}
	
	public List<Category> getCategories() {
		categories =iCategorieService.getCategories();
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<SelectItem> getSelectItemCategories() {
		
		getCategories();
        selectItemCategories = new ArrayList<SelectItem>();
		
		for (Category c:categories){
			
			selectItemCategories.add(new SelectItem(c, c.getName()));
		}
		
		System.out.println("Size:" +selectItemCategories.size());
		
		return selectItemCategories;
	}
	public void setSelectItemCategories(List<SelectItem> selectItemCategories) {
		this.selectItemCategories = selectItemCategories;
	}
	public ICategorieService getiCategorieService() {
		return iCategorieService;
	}
	public void setiCategorieService(ICategorieService iCategorieService) {
		this.iCategorieService = iCategorieService;
	}
	public List<Category> getSelectedCategories() {
		return selectedCategories;
	}
	public void setSelectedCategories(List<Category> selectedCategories) {
		this.selectedCategories = selectedCategories;
	}


/*****************************************************************************************/

	private Shop selectedShop;
	private List<Shop> shops;
	private List<SelectItem> selectItemShops;
	
	
	@ManagedProperty(name = "shopActionBean", value = "#{shopActionBean}")
	private ShopActionBean shopActionBean;
	
	private List<Shop> selectedShops;
	
	public Shop getSelectedShop() {
		return selectedShop;
	}
	public void setSelectedShop(Shop selectedShop) {
		this.selectedShop = selectedShop;
	}
	public List<Shop> getShops() {
		shops = shopActionBean.getListShopsArtisane();
		return shops;
	}
	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	public List<SelectItem> getSelectItemShops() {
		getShops();
		selectItemShops = new ArrayList<SelectItem>();
		
		for (Shop sh:shops){
			
			selectItemShops.add(new SelectItem(sh, sh.getName()));
		}
		
		System.out.println("Size:" +selectItemShops.size());
		
		return selectItemShops;
	}
	public void setSelectItemShops(List<SelectItem> selectItemShops) {
		this.selectItemShops = selectItemShops;
	}
	
	public List<Shop> getSelectedShops() {
		return selectedShops;
	}
	public void setSelectedShops(List<Shop> selectedShops) {
		this.selectedShops = selectedShops;
	}
	

	public ShopActionBean getShopActionBean() {
		return shopActionBean;
	}
	public void setShopActionBean(ShopActionBean shopActionBean) {
		this.shopActionBean = shopActionBean;
	}



	/*---------------------------------------------------------------------------------------------------*/
	private List<String> selectedTexts;
       public List<String> getSelectedTexts() {
   		return selectedTexts;
   	}
       public void setSelectedTexts(List<String> selectedTexts) {
   		this.selectedTexts = selectedTexts;
   	}

	   public List<String> complete(String query) {
		List<String> results = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			results.add(query + i);
		}

		return results;
	}

	public List<Wilayas> completeWilaya(String query) {
		List<Wilayas> suggestions = new ArrayList<Wilayas>();

		for (Wilayas w : wilayas) {
			if (w.getNom().startsWith(query))
				suggestions.add(w);
		}

		return suggestions;
		
	}
	

	
	
	
	public List<String> completeArea(String query) {
		List<String> results = new ArrayList<String>();

		if (query.equals("PrimeFaces")) {
			results.add("PrimeFaces Rocks!!!");
			results.add("PrimeFaces has 100+ components.");
			results.add("PrimeFaces is lightweight.");
			results.add("PrimeFaces is easy to use.");
			results.add("PrimeFaces is developed with passion!");
		} else {
			for (int i = 0; i < 10; i++) {
				results.add(query + i);
			}
		}

		return results;
	}

	public void handleSelect(SelectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Selected:" + event.getObject().toString(), null);

		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void handleUnselect(UnselectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Unselected:" + event.getObject().toString(), null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public String getTxt2() {
		return txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	public String getTxt3() {
		return txt3;
	}

	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}

	public String getTxt4() {
		return txt4;
	}

	public void setTxt4(String txt4) {
		this.txt4 = txt4;
	}

	public String getTxt5() {
		return txt5;
	}

	public void setTxt5(String txt5) {
		this.txt5 = txt5;
	}

	public String getTxt6() {
		return txt6;
	}

	public void setTxt6(String txt6) {
		this.txt6 = txt6;
	}

	public String getTxt7() {
		return txt7;
	}

	public void setTxt7(String txt7) {
		this.txt7 = txt7;
	}

	

	
}
