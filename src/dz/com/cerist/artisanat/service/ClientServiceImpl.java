package dz.com.cerist.artisanat.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.tuc.dsrl.m2o.ontology.utility.OntologyUtilityFactory;


import dz.com.cerist.artisanat.dao.IClientDao;
import dz.com.cerist.artisanat.entite.Clients;

import dz.com.cerist.artisanat.entite.ontology.Client;
import dz.com.cerist.artisanat.entite.ontology.Wilaya;
import dz.com.cerist.artisanat.entite.repository.ClientRepository;


@Service("iClientService")
@Transactional
public class ClientServiceImpl implements IClientService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 686773006008667889L;

	
	@Autowired
	private IClientDao iClientDao ;
	
	public IClientDao getiClientDao() {
		return iClientDao;
	}

	public void setiClientDao(IClientDao iClientDao) {
		this.iClientDao = iClientDao;
	}

	@Override
	public void ajouterProfil(Clients client) {
		// TODO Auto-generated method stub
		iClientDao.ajouterProfil(client);
	}

	@Override
	public Clients getClientbyId(Long id) {
		// TODO Auto-generated method stub
		return iClientDao.getClientbyId(id);
	}

	@Override
	public Clients editerClient(Clients client) {
		// TODO Auto-generated method stub
		return iClientDao.editerClient(client);
	}

	@Override
	public void ajouterClientOntologie(long id_client, long id_wilaya) {
		
		Wilaya w2 = new Wilaya(id_wilaya);
    	ClientRepository cRepo = new ClientRepository();
		Client client = new Client(id_client, w2);
		cRepo.create(client);
		OntologyUtilityFactory.getInstance().saveOntology();
	}

	

}
