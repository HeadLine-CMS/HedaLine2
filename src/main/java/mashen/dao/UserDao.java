package mashen.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import mashen.model.User;
@Repository("userDao")
public interface UserDao {
	//新增数据
	public int add(User user);
	//删除数据
	public int delete(String accounty);
	//修改数据
	public int update(User user);
	//查询数据
	public List<User> select(String name);
	//注册及登陆验证
	public boolean check(User user);

}
