package com.newlecture.controller.note;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*import com.newlecture.controller.Controller;*/

public class DetailController implements Controller{

	/*@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		 request.setAttribute("model", "new data");
			
		 return "/WEB-INF/views/note/detail.jsp";
	}
*/
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/note/detail.jsp");
		mv.addObject("model", "new data");
		
		return mv;
	}

	
	
	
}
