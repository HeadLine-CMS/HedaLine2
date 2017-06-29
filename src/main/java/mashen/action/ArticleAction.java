package mashen.action;

import java.util.List;

import javax.annotation.Resource;

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
	public String add(){
		Article article = new Article();
		article.setTitle("test");
		article.setContent("999999");
		service.addArticle(article);
		return "index";
	} 
	
	@RequestMapping("/delete")
	public String delete(){
		Article article = new Article();
		article.setId(26);
		service.deleteArticle(article);
		return "index";
	}
	
	@RequestMapping("/update")
	public String update(){
		Article article = new Article();
		article.setId(26);
		article.setTitle("qwert");
		article.setContent("你好");
		article.setGenre("娱乐");
		service.updateArticle(article);
		return "index";
	}
	
	@RequestMapping("/selectByTitle")
	public String selectByTitle(){
		List<Article> list = service.selectByTitle("");
		for (Article article : list) {
			System.out.println(article);
		}
		return "index";
	}
	
}
