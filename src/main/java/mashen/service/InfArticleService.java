package mashen.service;

import java.util.List;
import mashen.model.Article;

public interface InfArticleService {
	
	public void addArticle(Article article);
	
	public void deleteArticle(Article article);
	
	public void updateArticle(Article article);
	
	public List<Article> selectByTitle(String title);
	public List<Article> selectArticleByCheck();
	public void updateArticleByCheck(String title);
	
	public List<Article> selectAll(); 
}
