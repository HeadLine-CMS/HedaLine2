package mashen.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mashen.model.AdminUser;
import mashen.service.AdminService;

@Controller
@RequestMapping("admin1")
public class AdminAction {
	@Resource(name = "adminService")
	private AdminService as;
//	private AdminUser adminuser = new AdminUser();

	@RequestMapping("/reg")
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
	public ModelAndView login(String name) {
//		name="33";
		List<AdminUser> l=as.AdminSelect(name);
		for (AdminUser a : l) {
			System.out.println(a.getPassword()+"="+a.getPassword());
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		return mv;
	}
}
