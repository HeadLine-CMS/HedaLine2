package mashen.action;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import mashen.model.Colu;
import mashen.service.ColuService;

@Controller
public class ColuAction {
	@Resource(name="coluService")
	private ColuService coluService;
	
	@RequestMapping("/addColu.do")
	public ModelAndView add(Colu colu){
		ModelAndView mav=new ModelAndView();
		if(colu!=null){
			coluService.addColu(colu);
			mav.addObject("msg", "增加成功！");
		}else {
			mav.addObject("msg", "错误操作！");
		}
		List<Colu> list=coluService.selectAll();
		mav.addObject("coluList", list);
		mav.setViewName("coluAdmin");
		return mav;
	}
	
	@RequestMapping("/deleteColu.do")
	public ModelAndView delete(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		if(request!=null){
			int id=Integer.parseInt(request.getParameter("id").toString());
			coluService.deleteColu(id);
			mav.addObject("msg", "删除成功！");
			
		}else{
			mav.addObject("msg", "删除失败！");
		}
		List<Colu> list=coluService.selectAll();
		mav.addObject("coluList", list);
		mav.setViewName("coluAdmin");
		return mav;
	}
	@RequestMapping("/forUpdateColu.do")
	public ModelAndView forUpdate(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		int id=Integer.parseInt(request.getParameter("id").toString());
		Colu colu=coluService.selectById(id);
		String file=colu.getImg();
		String fileName=file.substring(file.lastIndexOf("\\")+1);
		String fileUrl=request.getContextPath()+"/colu/"+fileName;
		mav.addObject("fileUrl",fileUrl);
		mav.addObject("colu", colu);
		mav.setViewName("coluUpdate");
		return mav;
	}
	
	
	@RequestMapping(value="/updateColu.do",method=RequestMethod.POST)
	public ModelAndView update(Colu colu,HttpServletRequest request,MultipartFile file){
		ModelAndView mav=new ModelAndView();
		String path=request.getSession().getServletContext().getRealPath("colu");
		String fileName=file.getOriginalFilename();
		File targer=new File(path,fileName);
		String name=path+"\\"+fileName;
		System.out.println(name);
		colu.setImg(name);
		colu.setCreated(getTime());
		System.out.println(colu);
		if(file!=null){
			if(!targer.exists()){
				targer.mkdirs();
			}
		}
		try {
			file.transferTo(targer);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(colu!=null&&!colu.getUrl().equals("")){
			coluService.updateColu(colu);
			System.out.println("更新成功！");
			mav.addObject("msg", "更新成功！");
		}
		List<Colu> list=coluService.selectAll();
		System.out.println(request.getContextPath()+"/colu/"+fileName);
		mav.addObject("fileUrl", request.getContextPath()+"/colu/"+fileName);
		mav.addObject("coluList", list);
		mav.setViewName("coluAdmin");
		return mav;
	}
	
	@RequestMapping("/selectColu.do")
	public ModelAndView select(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		if(request!=null){
			int id=Integer.parseInt(request.getParameter("coluId").toString());
			Colu colu=coluService.selectById(id);
			if(colu!=null){
				mav.addObject("colu", colu);
			}else {
				mav.addObject("msg", "没有此用户！");
			}
		}else {
			mav.addObject("msg", "错误操作！");
		}
		List<Colu> list=coluService.selectAll();
		mav.addObject("coluList", list);
		mav.setViewName("coluAdmin");
		return mav;
	}
	@RequestMapping("/selectAllColu.do")
	public ModelAndView selectAll(){
		ModelAndView mav=new ModelAndView();
		List<Colu> list=coluService.selectAll();
		System.out.println(list);
		mav.addObject("coluList", list);
		mav.setViewName("coluAdmin");
		
		return mav;
	}
	public static String getTime(){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date=format.format((new Date(System.currentTimeMillis())));
		return date;
	}
}
