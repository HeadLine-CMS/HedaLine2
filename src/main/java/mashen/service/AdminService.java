package mashen.service;

import java.util.List;

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
	public void AdminUpdate(AdminUser adminuser){
		dao.AdminUpdate(adminuser);
	}
	public List<AdminUser> AdminSelect(String name){
		return dao.AdminSelect(name);
	}
}
