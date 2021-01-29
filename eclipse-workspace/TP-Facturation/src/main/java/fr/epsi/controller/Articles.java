package fr.epsi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;


@SuppressWarnings("serial")
public class Articles extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
			List<Article> articles = new ArrayList<Article>();
			
			articles.add(new Article("00001","article1", 10));
			articles.add(new Article("00002","article1",20));
		
			req.setAttribute("articles", articles);
		
		   this.getServletContext().getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	    }

}
