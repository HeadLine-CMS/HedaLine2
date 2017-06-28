package mashen.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mashen.model.Advert;
import mashen.service.AdvertService;
@Controller
@RequestMapping("advert")
public class AdvertAction {
	
	@Resource(name="AdvertService")
	private AdvertService advertService;
	
	@RequestMapping("/add")
	public ModelAndView add(Advert advert){
		
		advert.setImg("img");
		advert.setLink("link");
		ModelAndView mo = new ModelAndView();
		mo.setViewName("index");
		mo.addObject("a", advert.getImg());
		return mo;
		
		
	}
}
