package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ArticleDAO;
import fr.epsi.dao.ArticleDAOImpl;
import fr.epsi.dto.ArticleDTO;
import fr.epsi.entite.Article;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ArticleServiceImpl implements ArticleService {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public void create(ArticleDTO a) {
		
		System.out.println("--------ArticleServiceImpl---------------------");
		System.out.println("a.getNumero() : "+a.getNumero());
		System.out.println("a.getNom() : "+a.getNom());
		System.out.println("a.getPrix()");
		System.out.println(a.getPrix());
		System.out.println();
		System.out.println();

		Article article = new Article();
		article.setNumero(a.getNumero());
		article.setNom(a.getNom());
		article.setPrix(a.getPrix());
		ArticleDAO dao = new ArticleDAOImpl(em, utx);
		
		dao.create(article);
		
	}

}
