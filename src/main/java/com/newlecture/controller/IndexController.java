package com.newlecture.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//annotation지우고
public class IndexController implements Controller{//http~지우고

	
 	public String service(HttpServletRequest request, HttpServletResponse response){

	 
	 request.setAttribute("model", "new data");
	
	 
	
	 
	 
	 
	 return "/WEB-INF/views/index.jsp";
	 
	
	 
}	
	
	
	
	
	/*
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		*/
		
		
		/*response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();*/
		
		//out.println("Hello Maven");
		
		/*
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);	
		*/
		
		
		/*
		request.setAttribute("model", "MVC");
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		*/
		
		
	}
		

