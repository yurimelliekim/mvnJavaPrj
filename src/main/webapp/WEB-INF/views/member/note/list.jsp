<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 여기부터 마이스타일로 -->


	<main class="main">
		<section class="note-list">
		ddddd
			<h1 class="hidden">노트목록</h1>
			<ul class="">
			<c:forEach var="note" items="${notes}">
				<li>
					
					<div><a href="">${note.title}</a></div>
					<div>
						${note.content}
					</div>
					<div><span>분류</span> <span>${note.regDate}</span></div>
				</li>
			</c:forEach>	
			</ul>		
		</section>
	</main>
	
	
	
