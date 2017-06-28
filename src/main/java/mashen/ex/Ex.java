package mashen.ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class Ex implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String msg = ex.getMessage();
		System.out.println(msg);
		request.setAttribute("errorMsg", msg);
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		//
		return model;
	}

}
