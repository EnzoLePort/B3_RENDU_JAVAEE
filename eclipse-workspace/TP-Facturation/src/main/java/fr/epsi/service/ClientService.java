package fr.epsi.service;

import java.util.List;

import fr.epsi.dto.ClientDTO;

public interface ClientService {
	
	void create(ClientDTO d);
	
	public List<ClientDTO> getClients();
	
}
