<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/writeBoard.css">
<c:import url="header" />
</head>
<body>
	<section>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="writeBoard">
			<div class="container">
			<h1>글 쓰 기</h1>
			<div>
				<input type="text" name="title" id="title"
					value="${not empty param.title ? param.title : ''}" placeholder="제목">
			</div>
			<br>
			<div class="contents">
				<textarea name="content" id="content" placeholder="내용">${not empty param.content ? param.content : ''}</textarea>
			</div>

			<input type="button" value="올리기" onclick="checkValues(form)">
			</div>
		</form>
	</section>
	<script type="text/javascript" src="../resources/writeBoard.js"></script>
</body>
</html>