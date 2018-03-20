package com.newlecture.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.controller.notice.ListController;


//annotation 지우기.
public class DispatcherController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		/*
		PrintWriter out = response.getWriter();
	      
	      out.printf("getRequestURL : %s<br />\n", request.getRequestURL());
	      out.printf("getRequestURI : %s<br />\n", request.getRequestURI());
	      out.printf("getContextPath : %s<br />\n", request.getContextPath());//getContextPath : /webprj 이 주소를 떼내기 위해서
	      out.printf("getMethod : %s<br />\n", request.getMethod());
	      out.printf("getQueryString : %s<br />\n", request.getQueryString());
	      */
		
	        /*getRequestURL : http://localhost/webprj/*.htm
	    	  getRequestURI : /webprj.htm
	    	  getContextPath : /webprj //이 주소를 떼내기 위해서 밑에 세줄.
	    	  getMethod : GET
	    	  getQueryString : null
	        */
	      
		
		String ctxPath = request.getContextPath();//webprj
		String requestUrl = request.getRequestURI();//webprj/notice.list.htm
		requestUrl = requestUrl.replace(ctxPath,"");//.htm??
		
		String viewUrl =null;
		
		/*
		String[] urls = new String[] {"/index.htm","/notice/list.htm"}; 
		Controller[] controllers = new Controller[] {new IndexController(),new ListController()};
		*/
		String pathUrl = "/WEB-INF/mapper.properties";
		
		
		//물리경로로 바꾸기
		String pathSystem = request
								.getServletContext()
								.getRealPath(pathUrl);
		
		FileInputStream fis = new FileInputStream(pathSystem);
		
		Properties properties = new Properties();
		properties.load(fis);
		
		
		//Map<String,Controller> urlMap = (Map)properties;//형변환
		Map<String,Controller> urlMap = new HashMap<>();
		
		for(Object key : properties.keySet()) {
			   
			   try {
			      String url = String.valueOf(key);
			      String className = String.valueOf(properties.get(key));
			      Controller controller = (Controller)Class.forName(className).newInstance();
			      urlMap.put(url, controller);
			      
			   } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			   }   
			}
		
		
		/*Map<String,Controller> urlMap = new HashMap<>();

			urlMap.put("/index.htm",new IndexController());//키, 값
			urlMap.put("/notice/list.htm",new ListController());
		*/
			
		/*Properties properties = new Properties();
			properties.putAll(urlMap);
			properties.store(fos, null);//출력, 주석 outputStream,comment
			properties.load(fis);//파일입력 inStream
			*/
			
			//맵의 키, 값으로 바로 풀 수 있음.
		Controller controller = urlMap.get(requestUrl);//controller클래스를가져오는꼴임. 그래서 500에러남./위에꺼 try,catch필요
		 
			if(controller != null) {
				viewUrl = urlMap.get(requestUrl).service(request, response);
				request
				.getRequestDispatcher(viewUrl)
				.forward(request, response);
			}
			else
				response.sendRedirect("/error404");
			
	
		/*	
			for(String url: urlMap.keySet()) {
				if(url.equals(requestUrl)) {
					viewUrl = urlMap.get(url).service(request, response);//urlMap.get(url):controller부분.
					request
					.getRequestDispatcher(viewUrl)
					.forward(request, response);
				
				break;
				}
			}
			if(viewUrl == null)	
				response.sendRedirect("/error404");
	
			*/

		/*
		for(int i=0;requestUrl.equals(urls[i]);i++) {//가운데거 참이되면 실행,다음되면 거짓이 됨. 만날때까지돔
			viewUrl = controllers[i].service(request, response);//object를 형변환해야함->인터페이스로!
			request
			.getRequestDispatcher(viewUrl)
			.forward(request, response);
		}
		if(viewUrl == null)	
			response.sendRedirect("/error404");
		*/
		
		
		/*
		if(requestUrl.equals("/index.htm")) {
			viewUrl = new IndexController().service(request, response);
			request
			.getRequestDispatcher(viewUrl)
			.forward(request, response);
		}
		else if(requestUrl.equals("/notice/list.htm")) {
			viewUrl = new ListController().service(request, response);
			request
			.getRequestDispatcher(viewUrl)
			.forward(request, response);
		}
		else	
			response.sendRedirect("/error404");
		*/
				
		
		/*request.getRequestURL();
		request.getRequestURI();
		request.getContextPath();
		request.getMethod();
		request.getQueryString();
		*/
		
		/*String viewUrl="";
		if("index라는 요청이 들어오면")
			viewUrl=new IndexController().service(request, response);
		
		request
		.getRequestDispatcher("viewUrl")
		.forward(request, response);
		
		*/
		//response.getWriter().print("오키염");
		
		/*
		request.setAttribute("model", "MVC");
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		*/
	}
		
}
