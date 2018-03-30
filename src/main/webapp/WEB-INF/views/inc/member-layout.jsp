<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 절대경로로바꾸려고 -->
 <c:set var="root" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html lang ="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" 
		content="width=device-width, initial-scale=1,
	    minimum-scale=1
	    ,user-scalable=1">

<title>Insert title here</title>
<link href="${root}/resources/css/Style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<!-- header -->
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<!-- main -->
	<tiles:insertAttribute name="main"></tiles:insertAttribute>
	<!-- footer -->
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	
</body>
</html>