package fr.epsi.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<ClientDTO> getClients() {
		List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
		ClientDAO dao = new ClientDAOImpl(em, utx);
		
		List<Client> clients = dao.getClients();
		
		for(Client client : clients) {
			ClientDTO clientDTO = new ClientDTO();
			clientDTO.setNom(client.getNom());
			clientDTO.setAdress(client.getAdress());
			clientsDTO.add(clientDTO);
		}
		
		return clientsDTO;
	}

}
