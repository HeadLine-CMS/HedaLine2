package mashen.action;

import java.util.List;

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

	// 注册
	@RequestMapping("/register")
	public ModelAndView register(User user) {
		System.out.println("daole");
		ModelAndView mv = new ModelAndView();
		if (user.getHeadname() != null && !"".equals(user.getHeadname()) && user.getHeadpassword() != null
				&& !"".equals(user.getHeadpassword())) {
			service.add(user);
			System.out.println(user);
			mv.addObject("hint", user.getHeadname());
		} else {
			mv.addObject("hint", "未成功");
		}
		mv.setViewName("success");
		return mv;
	}

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(String account) {
		System.out.println("daole2");
		service.delete(account);
		ModelAndView mv = new ModelAndView();
		mv.addObject("hint", "已删除" + account);
		mv.setViewName("success");
		return mv;
	}
	//查询
	@RequestMapping("/select")
	public ModelAndView select(String name) {
		System.out.println("daole3");
		List<User> list;
		ModelAndView mv = new ModelAndView();
		if (name != null && !"".equals(name)) {
			list = service.selectByName(name);
			for (User user : list) {
				System.out.println(user);
			}
			mv.addObject("list", list);
		} else {
			list = service.selectAll();
			for (User user : list) {
				System.out.println(user);
			}
			mv.addObject("list", list);
		}
		mv.setViewName("success");
		return mv;
	}

}
