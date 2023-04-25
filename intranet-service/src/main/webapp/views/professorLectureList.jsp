<%@page import="lecture.Lecture"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lecture.controller.LectureDao"%>
<%@page import="javax.imageio.plugins.tiff.GeoTIFFTagSet"%>
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
<title>[교수탭] 진행중인 강의 목록</title>
</head>

<c:set var="lecture" value="${lecture }" />

<body>
	<section class="list">
		<h4 class="p_h4">담당중인 강좌리스트</h4>
		<table class="lecturelist">
			<tr>
				<th>강의코드</th>
				<th>강의명</th>
				<th>전공</th>
				<th>대학</th>
				<th>이수구분</th>
				<th>교수명</th>
				<th>성적입력</th>
			</tr>
			<c:choose>
				<c:when test="${empty lecture }">
					<td colspan="7"><span>담당중인 강좌리스트가 없습니다.</span></td>
				</c:when>
				<c:when test="${not empty lecture }">
					<c:forEach items="${lecture}" var="lecture">
						<tr>
							<td>${lecture.classCode }</td>
							<td>${lecture.className }</td>
							<td>${lecture.major }</td>
							<td>${lecture.department }</td>
							<td>${lecture.classification }</td>
							<td>${log.userName}</td>
							<td><input type="button" value="성적입력"
								onclick="location.href='../service?command=updateGrade&classCode=${lecture.classCode}'"></td>
						</tr>
					</c:forEach>
		</table>
		</c:when>
		</c:choose>
	</section>
</body>
</html>