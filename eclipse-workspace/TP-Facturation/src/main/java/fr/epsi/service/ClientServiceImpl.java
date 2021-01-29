package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ejb.TransactionManagementType;

import fr.epsi.dao.ClientDAO;
import fr.epsi.dao.ClientDAOImpl;
import fr.epsi.dto.ClientDTO;
import fr.epsi.entite.Client;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientServiceImpl implements ClientService {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction utx;
	
	public void create(ClientDTO c)  {
		
		Client client = new Client();
		client.setNom(c.getNom());
		client.setAdress(c.getAdress());
		ClientDAO dao = new ClientDAOImpl(em, utx);
		
		dao.create(client);
		
	}

}
