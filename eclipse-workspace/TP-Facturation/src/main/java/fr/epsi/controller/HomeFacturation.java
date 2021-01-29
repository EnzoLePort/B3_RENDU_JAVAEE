package fr.epsi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.epsi.entite.Facture;

import java.util.Date;

@SuppressWarnings("serial")
public class HomeFacturation extends HttpServlet{ // http://localhost:8080/TP-Facturation-0.0.1-SNAPSHOT/home
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
			List<Facture> factures = new ArrayList<Facture>();
			
			factures.add(new Facture(new Date(),"001",500.01));
			factures.add(new Facture(new Date(),"002",300.01));
		
			req.setAttribute("factures", factures);
		
		   this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
	    }

}
