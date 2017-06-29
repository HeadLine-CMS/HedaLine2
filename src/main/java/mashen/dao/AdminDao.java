package mashen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mashen.model.AdminUser;
import mashen.model.Article;

@Repository
public interface AdminDao {
	public void AdminAdd(AdminUser adminuser);
	public void AdminUpdate(AdminUser adminuser);
	public List<AdminUser> AdminSelect(String name);

}
