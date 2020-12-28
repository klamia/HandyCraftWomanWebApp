package dz.com.cerist.artisanat.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.ontology.Client;
import dz.com.cerist.artisanat.entite.ontology.Wilaya;
import dz.com.cerist.artisanat.entite.repository.ClientRepository;

@Repository("crudDao")
@Transactional
public class CrudDaoImpl implements CrudDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ClientRepository cRepo;
	
	
	
	public ClientRepository getcRepo() {
		return cRepo;
	}



	public void setcRepo(ClientRepository cRepo) {
		this.cRepo = cRepo;
	}



	@Override
	public void ajouterClient(long id_client, long id_wilaya) {
		// TODO Auto-generated method stub

		Wilaya w2 = new Wilaya(id_wilaya);
    	cRepo = new ClientRepository();
		Client client = new Client(id_client, w2);
		cRepo.create(client);
	
	}

}
