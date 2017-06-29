package mashen.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mashen.model.AdminUser;
import mashen.model.Article;
import mashen.service.AdminService;
import mashen.service.InfArticleService;

@Controller
@RequestMapping("admin1")
public class AdminAction {
	@Resource(name = "articleService")
	private InfArticleService service;
	@Resource(name = "adminService")
	private AdminService as;
	// private AdminUser adminuser = new AdminUser();

	@RequestMapping("/register")
	public ModelAndView reg(AdminUser adminuser) {
		as.AdminAdd(adminuser);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(AdminUser adminuser) {
		as.AdminUpdate(adminuser);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req,AdminUser user) {
		if (user.getName() != "" || user.getPassword() != "") {
			List<AdminUser> l = as.AdminSelect(user.getName());
			String name = null;
			String pw = null;
			for (AdminUser a : l) {
				name = a.getName();
				pw = a.getPassword();
			}
			System.out.println(name + "/" + pw);
			if (user.getName().equals(name) && user.getPassword().equals(pw)) {
				//req.set
				ModelAndView mv = new ModelAndView();
				mv.setViewName("admin/register");
				mv.addObject("success", "成功");
				return mv;
			} else {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("admin/register");
				mv.addObject("success", "账号或者密码错误！");
				return mv;
			}
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("admin/register");
			return mv;
		}
	}

	@RequestMapping("/selectArticle")
	public ModelAndView selectArticle() {
		List<Article> l = service.selectArticleByCheck();
		for (Article a : l) {
			System.out.println(a.getTitle());
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		return mv;
	}

	@RequestMapping("/updateArticle")
	public ModelAndView updateArticle(String title) {
		title = "ttt";
		service.updateArticleByCheck(title);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		return mv;
	}
}
