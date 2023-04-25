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
<title>Create Department</title>
<link rel="stylesheet" href="../resources/createDepartment.css">
</head>
<c:import url="header" />
<body>
	<c:if test="${empty department }">
		<c:redirect url="service?command=selectDepartment" />
	</c:if>

	<c:forEach items="${department }" var="department">
		<c:set var="depCode" value="${department.depCode + 1 }" />
	</c:forEach>

	<section>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="createDepartment">
			<h3>학부</h3>
			<p>학부생성</p>
			<div>
				<input type="text" name="depCode" value="${depCode}" readonly>
				<input type="text" name="depName" placeholder="학부입력" required>
				<input type="submit" value="등록하기">
			</div>
		</form>
	</section>
</body>
</html>