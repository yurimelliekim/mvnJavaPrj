package com.newlecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//안씀
public interface Controller {

	
	//서비스함수만들기
	String service(HttpServletRequest request, HttpServletResponse response);
	
	
}
