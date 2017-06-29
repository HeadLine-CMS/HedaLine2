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
		List<AdminUser> l=as.AdminSelect("a");
		for (AdminUser g : l) {
			System.out.println(g.getName()+"===");
		}
		System.out.println("l"+"222");
//		as.AdminAdd(adminuser);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(AdminUser adminuser) {
		as.AdminUpdate(adminuser);
		ModelAndView mv = new ModelAndView();
		System.out.println("11");
		mv.setViewName("admin/login");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, AdminUser user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		String name = null;
		String pw = null;
		List<AdminUser> l = null;
		if (user.getName() != "" || user.getPassword() != "") {
			l = as.AdminSelect(user.getName());
			for (AdminUser a : l) {
				name = a.getName();
				pw = a.getPassword();
			}
		}
		if (user.getName().equals(name) && user.getPassword().equals(pw)) {
			mv.addObject("success", "成功");
			req.getSession().setAttribute("name", name);
			req.getSession().setAttribute("admin", l);
			return mv;
		} else {
			mv.addObject("success", "账号或者密码错误！");
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
