package com.newlecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("index")//대상이 클래스가아니라 함수임!함수명은 마음대로
	public String index() {//하지만, 통일시키는게 보기편함.
		
		return "index";///WEB-INF/views/index.jsp, dispatcher-servlet에서 설정을 해놔서
	}
}
