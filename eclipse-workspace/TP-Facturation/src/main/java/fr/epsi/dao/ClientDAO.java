package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Client;

public interface ClientDAO {
	
	void create(Client c);
	
	public List<Client> getClients();
	
}
