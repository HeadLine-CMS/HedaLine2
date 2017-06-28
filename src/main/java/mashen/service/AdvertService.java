package mashen.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mashen.dao.AdvertDao;
import mashen.model.Advert;

@Service("AdvertService")
public class AdvertService {
	
	@Resource(name="advertDao")
	private AdvertDao advertDao; 
	
	public void addAdvert(Advert advert){
		advertDao.add(advert);
	}
}
