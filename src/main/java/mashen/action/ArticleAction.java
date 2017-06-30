package mashen.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mashen.model.Article;
import mashen.service.InfArticleService;

@Controller
@RequestMapping("article")
public class ArticleAction {
	
	@Resource(name="articleService")
	private InfArticleService service;
	
	/**
	 * 增加文章
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(MultipartFile file,Article article){
		//调用文件上传
		String filename = upload(file);
		System.out.println(filename);
		
		Article a = new Article();
		a.setTitle(article.getTitle());
		a.setContent(article.getContent());
		a.setHeadName(article.getHeadName());
		a.setTitleImg(filename);
		a.setHeadImg(article.getHeadImg());
		a.setGenre(article.getGenre());
		
		//System.out.println(a.getGenre());
		
		service.addArticle(a);
		return "index";
	} 
	
	/**
	 * 标题图片保存
	 * @param file
	 * @return
	 */
	public static String upload(MultipartFile file){
		System.out.println("开始");
		//文件保存位置
		String path = "E://mashen";
		//获取文件名字
		String filename = file.getOriginalFilename();
		//String titleImg = (path+"/"+filename);
		File targetFile = new File(path,filename);
		//创建
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		//保存
		try {
			file.transferTo(targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
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
	public String selectByTitle(String title,HttpServletRequest request){
		List<Article> list = service.selectByTitle(title);
		request.setAttribute("list", list);
		return "index";
	}
	
	
	/**
	 * 查询全部
	 */
	@RequestMapping("/selectAll")
	public String selectAll(ModelMap map){
		List<Article> articles = service.selectAll();
		for (Article article : articles) {
			System.out.println(article);
		}
		map.addAttribute("articles",articles);
		return "home";
	}
	
}
