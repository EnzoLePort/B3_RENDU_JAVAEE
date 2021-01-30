package fr.epsi.service;

import java.util.ArrayList;
import java.util.List;

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

		Article article = new Article();
		article.setNumero(a.getNumero());
		article.setNom(a.getNom());
		article.setPrix(a.getPrix());
		ArticleDAO dao = new ArticleDAOImpl(em, utx);
		
		dao.create(article);
		
	}

	public List<ArticleDTO> getArticles() {
		List<ArticleDTO> articlesDTO = new ArrayList<ArticleDTO>();
		ArticleDAO dao = new ArticleDAOImpl(em, utx);
		
		List<Article> articles = dao.getArticles();
		
		for(Article article : articles) {
			ArticleDTO articleDTO = new ArticleDTO();
			articleDTO.setNumero(article.getNumero());
			articleDTO.setNom(article.getNom());
			articleDTO.setPrix(article.getPrix());
			articlesDTO.add(articleDTO);
		}
		
		return articlesDTO;
	}
	
	

}
