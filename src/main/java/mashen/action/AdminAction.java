package mashen.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mashen.model.AdminUser;
import mashen.service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminAction {
	@Resource(name = "adminService")
	private AdminService as;
//	private AdminUser adminuser = new AdminUser();

	@RequestMapping("/reg")
	public ModelAndView reg(AdminUser adminuser) {
		
		adminuser.setName("111");
		as.AdminAdd(adminuser);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/register");
		return mv;
	}
}