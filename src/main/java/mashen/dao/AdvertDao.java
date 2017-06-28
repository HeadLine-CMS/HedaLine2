package mashen.dao;


import org.springframework.stereotype.Repository;

import mashen.model.Advert;

@Repository("advertDao")
public interface AdvertDao {
	public void add(Advert advert);
	
	public void delete(int id);
	
	public void upadte(Advert advert);
	
	public void select(int id);

}
