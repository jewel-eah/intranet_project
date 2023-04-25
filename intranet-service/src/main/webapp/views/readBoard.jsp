<%@page import="user.controller.UserDao"%>
<%@page import="user.User"%>
<%@page import="board.Board"%>
<%@page import="board.controller.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/readBoard.css">
<meta charset="UTF-8">
<c:import url="header" />
</head>

<c:if test="${empty board }">
	<c:redirect
		url="service?command=readBoard&writeCode=${param.writeCode }" />
</c:if>

<body>
	<section>
		<div class="container">
			<h2>
				제목 : ${board.title }<br>작성자 : ${name }
			</h2>
			<p>${board.contents }</p>
			<div class="p">
				<p>수정일 : ${board.getModDate().toString().split(" ")[0]}</p>
			</div>

			<div class="button">
				<c:if test="${board.userCode == log.userCode }">
					<input type="button" value="수정"
						onclick="location.href='modifyBoard?writeCode=${board.writeCode }'">
					<input type="button" value="삭제"
						onclick="location.href='../service?command=deleteBoard&writecode=${board.writeCode }' ">
				</c:if>
				<input type="button" value="뒤로가기"
					onclick="location.href='community'">
			</div>


		</div>
	</section>

</body>
</html>