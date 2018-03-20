package com.newlecture.controller.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.controller.Controller;



public class ListController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		 request.setAttribute("model", "new data");
			
		 return "/WEB-INF/views/note/list.jsp";
	}

	
	
}