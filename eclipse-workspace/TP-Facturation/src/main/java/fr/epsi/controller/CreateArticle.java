package fr.epsi.controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.dto.ArticleDTO;
import fr.epsi.service.ArticleService;

@SuppressWarnings("serial")
public class CreateArticle extends HttpServlet{
	
	@EJB
	private ArticleService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
		   this.getServletContext().getRequestDispatcher("/WEB-INF/createArticle.jsp").forward(req, resp);
	    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	        
	    {
			ArticleDTO aDTO = new ArticleDTO();
			aDTO.setNumero(req.getParameter("numeroArticle"));
			aDTO.setNom(req.getParameter("nomArticle"));
			aDTO.setPrix(Double.valueOf(req.getParameter("prixArticle")));
			service.create(aDTO);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	    }

}
