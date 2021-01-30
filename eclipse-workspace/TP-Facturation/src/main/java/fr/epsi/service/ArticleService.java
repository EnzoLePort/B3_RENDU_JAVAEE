package fr.epsi.service;

import java.util.List;

import fr.epsi.dto.ArticleDTO;

public interface ArticleService {
	
	void create(ArticleDTO a);
	
	public List<ArticleDTO> getArticles();

}
