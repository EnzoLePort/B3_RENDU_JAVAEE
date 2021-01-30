package fr.epsi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.dto.ClientDTO;
import fr.epsi.entite.Client;
import fr.epsi.service.ArticleService;
import fr.epsi.service.ClientService;

@SuppressWarnings("serial")
public class Clients extends HttpServlet{
	
	@EJB
	private ClientService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
			List<Client> clients = new ArrayList<Client>();
			
			//clients.add(new Client("nom1","adress1"));
			//clients.add(new Client("nom2","adress2"));
			
			List<ClientDTO> clientsDTO = service.getClients();
			
			for(ClientDTO clientDTO : clientsDTO) {
				Client client = new Client();
				client.setNom(clientDTO.getNom());
				client.setAdress(clientDTO.getAdress());
				clients.add(client);
			}
		
			req.setAttribute("clients", clients);
			
			System.out.println("------------------JE passe par ServletClient--------------------");
		
		   this.getServletContext().getRequestDispatcher("/WEB-INF/clients.jsp").forward(req, resp);
	    }

}
