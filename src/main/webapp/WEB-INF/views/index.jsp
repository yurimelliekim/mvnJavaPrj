<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" 
	content="width=device-width, initial-scale=1,
    minimum-scale=1
    ,user-scalable=1">

<title>Insert title here</title>
<link href="resources/css/Style.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<%-- 안녕하세요. ${model} --%>

<!-- 여기부터 마이스타일로 -->

	<header class="header">
		<h1>책 제목</h1>
		<nav class="main-menu">
			<h1 class="hidden">메인메뉴</h1>
			<ul>
				<li><a href=""><img src="resources/images/ic_dehaze_black_24dp_1x.png"/></a></li>
				<li><a href=""><img src="resources/images/ic_search_black_24dp_1x.png"/></a></li>
				
			</ul>
		</nav>
	</header>
	<main class="main">
		<section class="note-list">
			<h1 class="hidden">노트목록</h1>
			<ul class="">
			<c:forEach begin="0" end="9">
				<li>
					<div>노트 제목</div>
					<div>노트 내용 동해물과 백두산이 마르고 닳도록 
						하느님이 보우하사 우리나라만세~
					</div>
					<div><span>분류</span> <span>2018-03-22 15:23</span></div>
				</li>
			</c:forEach>	
			</ul>		
		</section>
	</main>
	
	
	
</body>
</html>