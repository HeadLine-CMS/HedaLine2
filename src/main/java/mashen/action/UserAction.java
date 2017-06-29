package mashen.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mashen.model.User;
import mashen.service.UserService;

@Controller
// @RequestMapping("user")
public class UserAction {
	@Resource(name = "userService")
	private UserService service;

	@RequestMapping("/login")
	public String add() {
		User user = new User();
		user.setHeadname("test008");
		user.setHeadaccount("666");
		// int a=1/0;
		service.add(user);
		return "user/index";
	}

	@RequestMapping("/register")
	public ModelAndView register(User user) {
		if (user.getHeadname() != null && !user.getHeadname().equals(user.getHeadname())
				&& user.getHeadpassword() != null && !user.getHeadpassword().equals(user.getHeadpassword())) {
			service.add(user);
			
		}
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
