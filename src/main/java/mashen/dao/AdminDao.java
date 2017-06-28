package mashen.dao;

import org.springframework.stereotype.Repository;

import mashen.model.AdminUser;

@Repository
public interface AdminDao {
	public void AdminAdd(AdminUser adminuser);
}
