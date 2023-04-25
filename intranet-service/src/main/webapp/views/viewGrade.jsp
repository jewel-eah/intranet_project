<%@page import="SCData.SCData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SCData.controller.SCDataDao"%>
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
<title>[학생] 성적조회 (전체)</title>
</head>


<c:set var="scData" value="${scData }" />

<body>
	<section>
		<h4 class="p_h4">성적조회</h4>
		<table>
			<tr>
				<th>강의명</th>
				<th>이수구분</th>
				<th>성적</th>
			</tr>
			<c:choose>
				<c:when test="${empty scData }">
					<td colspan="3"><span>수강중인 강의가 없습니다.</span></td>
				</c:when>
				<c:when test="${not empty scData }">
					<c:forEach items="${scData}" var="scData">
						<tr>
							<td>${scData.className }</td>
							<td>${scData.classification }</td>
							<c:choose>
								<c:when test="${scData.grade eq '4.5'}">
									<td id="score">A+</td>
								</c:when>
								<c:when test="${scData.grade eq '4.0'}">
									<td id="score">A</td>
								</c:when>
								<c:when test="${scData.grade eq '3.5'}">
									<td id="score">B+</td>
								</c:when>
								<c:when test="${scData.grade eq '3.0'}">
									<td id="score">B</td>
								</c:when>
								<c:when test="${scData.grade eq '2.5'}">
									<td id="score">C+</td>
								</c:when>
								<c:when test="${scData.grade eq '2.0'}">
									<td id="score">C</td>
								</c:when>
								<c:when test="${scData.grade eq '1.5'}">
									<td id="score">D+</td>
								</c:when>
								<c:when test="${scData.grade eq '1.0'}">
									<td id="score">D</td>
								</c:when>
								<c:when test="${empty scData.grade }">
									<td id="score">미등록</td>
								</c:when>
								<c:otherwise>
									<td id="score">F</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
		</table>
		</c:when>
		</c:choose>
	</section>
</body>
</html>