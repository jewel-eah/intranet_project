<%@page import="lecture.Lecture"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lecture.controller.LectureDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/professorInfo.css">
<c:import url="header" />
<title>[교수탭] 수업계획서 정정</title>
</head>
<c:if test="${empty lecture }">
	<c:redirect
		url="service?command=modifyLectureInfoCheck&classCode=${param.classCode }" />
</c:if>
<body>
	<section>
		<c:forEach items="${lecture}" var="lecture">
			<h4>강의명 : ${lecture.className }</h4>
			<form method="POST" action="../service">
				<input type="hidden" name="command" value="modifyLectureInfo">
				<input type="hidden" name="classCode" value="${lecture.classCode }">
					<p>
					<textarea rows="15" cols="50" type="text" id="information" name="information"
						value="${lecture.information }">${lecture.information}</textarea>
				</p>
				<input type="submit" value="저장">
			</form>
		</c:forEach>
	</section>
</body>
</html>