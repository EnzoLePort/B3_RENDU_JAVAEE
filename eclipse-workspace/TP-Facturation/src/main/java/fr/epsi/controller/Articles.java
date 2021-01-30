package fr.epsi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.dto.ArticleDTO;
import fr.epsi.entite.Article;
import fr.epsi.service.ArticleService;

@SuppressWarnings("serial")
public class Articles extends HttpServlet{
	
	@EJB
	private ArticleService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
			List<Article> articles = new ArrayList<Article>();
			
			//articles.add(new Article("00001","article1", 10));
			//articles.add(new Article("00002","article1",20));
			
			List<ArticleDTO> articlesDTO = service.getArticles();
			
			for(ArticleDTO articleDTO : articlesDTO) {
				Article article = new Article();
				article.setNumero(articleDTO.getNumero());
				article.setNom(articleDTO.getNom());
				article.setPrix(articleDTO.getPrix());
				articles.add(article);
			}
		
			req.setAttribute("articles", articles);
		
		   this.getServletContext().getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	    }

}
