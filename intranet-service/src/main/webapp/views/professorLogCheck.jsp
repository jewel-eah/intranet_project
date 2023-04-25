<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/professor.css">
<c:import url="header" />
<title>비밀번호 확인</title>
</head>
<body>
	<section>
		<h4>개인정보 수정 > 비밀번호 확인</h4><br>
			<form id="p_form" method="POST" action="../service" >
				<input type="hidden" name="command" value="passwordCheck"> 
				<input type="hidden" id="presentPassword" value="${log.userPassword }">
				<input type="hidden" id="userCode" value="${log.userCode }">
				<label for="userPassword">비밀번호</label><br>
				<input type="password" id="userPassword" name="userPassword"><br>
				<div>
					<input type="button" value="비밀번호 확인" onclick="checkPassword(form)">
				</div>
			</form>
	</section>
	<script src="../resources/checkPassword.js"></script>
</body>
</html>