package mashen.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mashen.dao.AdminDao;
import mashen.model.AdminUser;

@Service
public class AdminService {
	@Resource(name="adminDao")
	private AdminDao dao;
	public void AdminAdd(AdminUser adminuser){
		dao.AdminAdd(adminuser);
	}
}
