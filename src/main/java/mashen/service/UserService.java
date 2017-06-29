package mashen.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import mashen.dao.UserDao;
import mashen.model.User;

@Service("userService")
public class UserService implements IUSerService {
	@Resource(name = "userDao")
	private UserDao dao;

	public int add(User user) {

		return dao.add(user);
	}

	public int delete(String account) {

		return dao.delete(account);
	}

	public int update(User user) {

		return dao.update(user);
	}

	public List<User> selectByName(String name) {

		return dao.selectByName(name);
	}

	public boolean check(User user) {

		return false;
	}

	public List<User> selectAll() {
		
		return dao.selectAll();
	}

}
