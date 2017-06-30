package mashen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mashen.model.Colu;
@Repository("coluDao")
public interface ColuDao {
	//添加轮播图
	public void add(Colu colu);
	
	//删除轮播图
	public void delete(int id);
	
	//更新轮播图
	public void update(Colu colu);
	
	//根据ID获取轮播图
	public Colu select(int id);
	
	//获取所有轮播图
	public List<Colu> selectAll();
}
