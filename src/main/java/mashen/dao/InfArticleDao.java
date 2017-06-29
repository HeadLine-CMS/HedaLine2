package mashen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mashen.model.Article;

@Repository("articleDao")
public interface InfArticleDao {
	
	public void addArticle(Article article);
	
	public void deleteArticle(Article article);
	
	public void updateArticle(Article article);
	
	public List<Article> selectByTitle(String title);
	public List<Article> selectArticleByCheck();
}
