<%@page import="department.Department"%>
<%@page import="department.controller.DepartmentDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info Change</title>
</head>
<c:import url="header" />
<link rel="stylesheet" href="../resources/masterUser.css">
<body>

	<section class="masterUser">
		<h2>유저정보수정</h2>
		<form method="POST" action="masterUserUpdate">
			<input type="text" name="userCode" required> <input
				type="submit" value="검색하기">
		</form>
	</section>
</body>
</html>