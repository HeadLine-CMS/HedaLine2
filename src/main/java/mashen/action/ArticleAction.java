package mashen.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mashen.model.Article;
import mashen.service.InfArticleService;

@Controller
@RequestMapping("/article")
public class ArticleAction {
	
	@Resource(name="articleService")
	private InfArticleService service;
	
	/**
	 * 增加文章
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Article article){
		Article a = new Article();
		a.setTitle(article.getTitle());
		a.setContent(article.getContent());
		a.setHeadName(article.getHeadName());
		a.setTitleImg(article.getTitleImg());
		a.setHeadImg(article.getHeadImg());
		a.setGenre(article.getGenre());
		service.addArticle(a);
		return "index";
	} 
	
	/**
	 * 根据id删除文章
	 * @param article
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(Article article){
		Article a = new Article();
		a.setId(article.getId());
		service.deleteArticle(a);
		return "index";
	}
	
	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Article article){
		Article a = new Article();
		a.setTitle(article.getTitle());
		a.setContent(article.getContent());
		a.setTitleImg(article.getTitleImg());
		a.setGenre(article.getGenre());
		service.updateArticle(a);
		return "index";
	}
	
	/**
	 * 根据标题查询
	 * @return
	 */
	@RequestMapping("/selectByTitle")
	public String selectByTitle(){
		List<Article> list = service.selectByTitle("");
		for (Article article : list) {
			System.out.println(article);
		}
		return "index";
	}
	
}
