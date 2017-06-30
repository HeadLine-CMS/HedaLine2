package mashen.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@RequestMapping("/register")
	public ModelAndView reg(AdminUser adminuser) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		System.out.println(adminuser.getName() + adminuser.getAccount() + adminuser.getPassword());
		if (adminuser.getName() == "" || adminuser.getAccount() == "" || adminuser.getPassword() == ""
				|| adminuser.getPassword().trim().equals("") || adminuser.getName().trim().equals("")
				|| adminuser.getAccount().trim().equals("")) {
			mv.addObject("success", "注册失败");
			return mv;
		}
		List<AdminUser> l = as.AdminSelectName();
		boolean so = false;
		for (AdminUser ll : l) {
			System.out.println(ll.getName()+"|||"+adminuser.getName());
			if (ll.getName().equals(adminuser.getName())) {
				so=true;
			}
		}
		System.out.println(so);
		if(!so){
			as.AdminAdd(adminuser);
			mv.addObject("success", "注册成功");
			return mv;
		}
		mv.addObject("success", "账号存在");
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
	public ModelAndView login(HttpServletRequest req, AdminUser user) {
		ModelAndView mv = new ModelAndView();
		
		String name = null;
		String pw = null;
		String account=null;
		List<AdminUser> l = null;
		if (user.getName() != "" && user.getName() != null) {
			l = as.AdminSelect(user.getName());
			for (AdminUser a : l) {
				name = a.getName();
				pw = a.getPassword();
				account=a.getAccount();
			}
			if (user.getName().equals(name) && user.getPassword().equals(pw)) {
				mv.addObject("success", "成功");
				req.getSession().setAttribute("account",account);
				System.out.println(account+"|");
				mv.setViewName("admin/index");
				return mv;
			} else {
				mv.addObject("success", "账号或者密码错误！");
				mv.setViewName("admin/register");
				return mv;
			}
		} else {
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
