package mashen.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mashen.dao.InfArticleDao;
import mashen.model.Article;

@Service("articleService")
public class ArticleService implements InfArticleService {
	
	@Resource(name="articleDao")
	private InfArticleDao dao;

	/**
	 * 增加文章
	 */
	public void addArticle(Article article) {
		dao.addArticle(article);
	}
	
	/**
	 * 删除文章
	 */
	public void deleteArticle(Article article) {
		dao.deleteArticle(article);
	}
	
	/**
	 * 修改文章
	 */
	public void updateArticle(Article article) {
		dao.updateArticle(article);
	}
	
	/**
	 * 根据标题模糊查询
	 */
	public List<mashen.model.Article> selectByTitle(String title) {
		List<Article> list = dao.selectByTitle(title);
		return list;
	}

	public List<Article> selectArticleByCheck() {
		return dao.selectArticleByCheck();
	}
	public void updateArticleByCheck(String title){
		dao.updateArticleByCheck(title);
	}
	

}
