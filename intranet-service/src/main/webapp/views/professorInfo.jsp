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
<title>[교수탭] 교수종합정보조회</title>
</head>
<body>
	<section>
		<h4 class="p_h4">교수종합정보 > 기본정보</h4>
		<table class="p_table">
			<tr>
				<th>교수번호</th>
				<td>${log.userCode }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${log.userName }</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${log.birthDate }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${log.gender }</td>
			</tr>
			<tr>
				<th>소속학부</th>
				<td>${log.depName }</td>
			</tr>
			<tr>
				<th>담당전공</th>
				<td>${log.mainMajor }</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${log.phone }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${log.email }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${log.address }</td>
			</tr>
		</table>
	</section>
</body>
</html>