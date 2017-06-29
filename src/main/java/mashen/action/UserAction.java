package mashen.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mashen.model.User;
import mashen.service.UserService;

@Controller
@RequestMapping("user")
public class UserAction {
	@Resource(name = "userService")
	private UserService service;

	// 注册
	@RequestMapping("/register")
	public ModelAndView register(User user) {
		System.out.println("register");
		ModelAndView mv = new ModelAndView();
		if (user.getHeadaccount() != null && !"".equals(user.getHeadaccount()) && user.getHeadpassword() != null
				&& !"".equals(user.getHeadpassword())) {
			if (service.check(user.getHeadaccount()) != null) {
				mv.addObject("hint", "账号已存在");
			} else {
				service.add(user);
				mv.addObject("hint", user.getHeadaccount()+"注册成功");
			}
		} else {
			mv.addObject("hint", "请输入账号和密码");
		}
		mv.setViewName("success");
		return mv;
	}

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(String account) {
		System.out.println("delete");
		service.delete(account);
		ModelAndView mv = new ModelAndView();
		mv.addObject("hint", "已删除" + account);
		mv.setViewName("success");
		return mv;
	}

	// 查询
	@RequestMapping("/select")
	public ModelAndView select(String account) {
		System.out.println("select");
		List<User> list;
		ModelAndView mv = new ModelAndView();
		if (account != null && !"".equals(account)) {
			list = service.selectByAccount(account);
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

	// 更新
	@RequestMapping("/update")
	public ModelAndView update(User user) {
		System.out.println("update");
		System.out.println(user.getHeadname());
		service.update(user);
		ModelAndView mv = new ModelAndView();
		mv.addObject("hint", "已更新" + user.getHeadname());
		mv.setViewName("success");
		return mv;
	}

	// 登陆校验
	@RequestMapping("/login")
	public ModelAndView login(String account, String password) {
		System.out.println("login");
		ModelAndView mv = new ModelAndView();
		if (account != null && !"".equals(account)) {
			if (service.check(account) != null) {
				User user = service.check(account);
				if (user.getHeadaccount().equals(account) && user.getHeadpassword().equals(password)) {
					System.out.println("122");
					mv.addObject("hint", "登陆成功");
				} else {
					mv.addObject("hint", "密码错误");
				}
			} else {
				mv.addObject("hint", "账号不存在");
			}
		} else {
			mv.addObject("hint", "请输入账号");
		}
		mv.setViewName("success");
		return mv;
	}

}
