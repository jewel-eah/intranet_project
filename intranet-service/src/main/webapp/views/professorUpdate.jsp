<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/professorInfo.css">
<script src="../resources/updateSuccess.js"></script>
<c:import url="header" />
<title>[교수탭] 개인정보수정</title>
</head>
<body>
	<c:if test="${empty log }">
	<c:redirect
		url="service?command=professorUpdateCheck" />
</c:if>
	
	<section>
		<h4 class="title">개인정보 > 개인정보 수정</h4>
		<br>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="professorInfoUpdate">
			<h4>이름 *</h4>
			<input type="text" id="userName" name="userName"
				value="${log.userName }" readonly>
			<h4>아이디 *</h4>
			<input type="text" id="userCode" name="userCode"
				value="${log.userCode }" readonly>
			<h4>비밀번호 *</h4>
			<input type="text" id="userPassword" name="userPassword"
				value="${log.userPassword }">
			<h4>연락처 *</h4>
			<input type="text" id="phone" name="phone"  value="${log.phone }"
						pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required>
			<h4>이메일 *</h4>
			<input type="email" id="email" name="email" value="${log.email }"
				pattern="[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.]+[a-zA-Z]+[.]*[a-zA-Z]*" size="20" required>
			<h4>주소</h4>
			<div class="postCode">
			<input class="p_Code" type="text" name="addressCode" id="addressCode"
				value="${log.addressCode }" placeholder="우편번호">
				<input id="pc_button" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
			</div>
			<br>
			<input type="text" name="address" id="address"
				value="${log.address }" placeholder="주소"> <br> <input
				type="text" id="sample6_detailAddress" placeholder="상세주소"> <input
				type="text" id="sample6_extraAddress" placeholder="참고항목">
			<script	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<input type="button" value="저장" onclick="professorUpdateInfo(form)">
		</form>
	</section>
	<script src="../resources/professorUpdateInfo.js"></script>
	<script src="../resources/addressAPI2.js"></script>
</body>
</html>