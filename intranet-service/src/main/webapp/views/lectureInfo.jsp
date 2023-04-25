<%@page import="lecture.Lecture"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lecture.controller.LectureDao"%>
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
<title>[교수탭] 수업계획서 작성</title>
</head>
<c:set var="scData" value="${list }" />

<body>
	<section>
		<h4 class="p_h4">강의리스트 > 수업계획서 작성/정정</h4>
		<table>
			<tr>
				<th>강의코드</th>
				<th>강의명</th>
				<th>전공</th>
				<th>대학</th>
				<th>이수구분</th>
				<th>수업계획서</th>
			</tr>
			<c:choose>
				<c:when test="${empty list }">
					<td colspan="6"><span>개설된 강의리스트가 없습니다.</span></td>
				</c:when>
				<c:when test="${not empty list }">
					<c:forEach items="${list}" var="lecture">
						<tr>
							<td>${lecture.classCode }</td>
							<td>${lecture.className }</td>
							<td>${lecture.major }</td>
							<td>${lecture.department }</td>
							<td>${lecture.classification }</td>
							<td><input type="button" value="수정"
								onclick="location.href='modifyLectureInfo?classCode=${lecture.classCode }'"></td>
						</tr>
					</c:forEach>
		</table>
		</c:when>
		</c:choose>
	</section>
</body>
</html>