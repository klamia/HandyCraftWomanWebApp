package dz.com.cerist.artisanat.service;

import java.io.Serializable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.tuc.dsrl.m2o.ontology.utility.OntologyUtilityFactory;

import dz.com.cerist.artisanat.dao.IArtisaneDao;



import dz.com.cerist.artisanat.entite.Artisanes;

import dz.com.cerist.artisanat.entite.ontology.Activite;
import dz.com.cerist.artisanat.entite.ontology.Artisane;
import dz.com.cerist.artisanat.entite.ontology.Wilaya;
import dz.com.cerist.artisanat.entite.repository.ArtisaneRepository;


@Service("iArtisaneService")
@Transactional
public class ArtisaneServiceImpl implements IArtisaneService, Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4270639758694529153L;
	/**
	 * 
	 */

	@Autowired
	private IArtisaneDao iArtisaneDao;

	public IArtisaneDao getiArtisaneDao() {
		return iArtisaneDao;
	}

	public void setiArtisaneDao(IArtisaneDao iArtisaneDao) {
		this.iArtisaneDao = iArtisaneDao;
	}

	@Override
	public void ajouterProfil(Artisanes artisane) {
		// TODO Auto-generated method stub
		iArtisaneDao.ajouterProfil(artisane);
	}

	@Override
	public Artisanes getArtisanebyId(Long id) {
		// TODO Auto-generated method stub
		return iArtisaneDao.getArtisanebyId(id);
	}

	/*
	@Override
	public List<Artisanes> getAllArtisanes() {
		// TODO Auto-generated method stub
		return iArtisaneDao.getAllArtisanes();
	}
     */
	
	@Override
	public Artisanes editerProfil(Artisanes artisane) {
		// TODO Auto-generated method stub
		return iArtisaneDao.editerProfil(artisane);
	}

	@Override
	public void ajouterArtisaneOntologie(long id_artisane, long id_wilaya, long id_domaine) {
		Wilaya w = new Wilaya(id_wilaya);
    	Activite domaine = new Activite(id_domaine);
		ArtisaneRepository aRepo = new ArtisaneRepository();
		Artisane artisane = new Artisane(id_artisane,domaine,  w);
		aRepo.create(artisane);
		OntologyUtilityFactory.getInstance().saveOntology();
	}

}
