<%@page import="major.Major"%>
<%@page import="major.controller.MajorDao"%>
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
<title>Create Major</title>
<link rel="stylesheet" href="../resources/createMajor.css">
</head>
<c:import url="header" />
<body>
	<c:if test="${empty department || empty rNum}">
		<c:redirect url="service?command=getMajorCode" />
	</c:if>

	<section>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="createMajor">
			<h3>학과</h3>
			<div>
				<p>학부생성</p>
				<select name="department" required>
					<option value="">학부선택</option>
					<c:forEach items="${department }" var="department">
						<option value="${department.depCode }">${department.depName }</option>
					</c:forEach>
				</select>
				<p>전공작성</p>
				<input type="text" name="majorName" required> <input
					type="number" name="majorCode" value='${rNum }' readonly> <input
					type="submit" value="등록하기">
			</div>
		</form>
	</section>
</body>
</html>