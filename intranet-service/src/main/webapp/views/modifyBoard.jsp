<%@page import="board.Board"%>
<%@page import="board.controller.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/modifyBoard.css">
<c:import url="header" />
</head>

<c:if test="${empty board }">
	<c:redirect
		url="service?command=modifyBoardCheck&writeCode=${param.writeCode }" />
</c:if>

<body>
	<section>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="modifyBoard"> <input
				type="hidden" name="writeCode" value="${board.writeCode }">
			<h1>수정하기</h1>
			<div>
				<input type="text" name="title" id="title" value="${board.title }"
					placeholder="제목">
			</div>
			<br>
			<div>
				<textarea name="content" id="content" placeholder="내용">${board.contents }</textarea>
			</div>

			<input type="button" value="수정하기" onclick="checkValues(form)">
		</form>
	</section>
	<script type="text/javascript" src="../resources/modifyBoard.js"></script>
</body>
</html>