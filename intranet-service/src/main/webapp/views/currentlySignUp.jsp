<%@page import="currentlySignUp.CurrentlySignUp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="currentlySignUp.controller.CurrentlySignUpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/professor.css">
<c:import url="header" />
<title>수강신청현황 조회/철회</title>
</head>

<c:set var="currentlylist" value="${currentlylist }" />

<body>
	<section>
		<table id="mylist">
			<form method="POST" action="../service">
				<input type="hidden" name="command" value="deleteClass"> <input
					type="hidden" name="classCode" value="${currentlist.classCode}">
				<tr>
					<th>이수구분</th>
					<th>강의코드</th>
					<th>강의명</th>
					<th>전공</th>
					<th>대학</th>
					<th>교수명</th>
					<th>강의실</th>
					<th>학점</th>
					<th>철회</th>
				</tr>
				<c:choose>
					<c:when test="${empty currentlylist }">
						<td colspan="9"><span>수강신청한 현황이 없습니다.</span></td>
					</c:when>
					<c:when test="${not empty currentlylist }">
						<c:forEach items="${currentlylist}" var="currentlist">
							<tr>
								<td>${currentlist.classification }</td>
								<td>${currentlist.classCode }</td>
								<td>${currentlist.className }</td>
								<td>${currentlist.major }</td>
								<td>${currentlist.department }</td>
								<td>${currentlist.userName }</td>
								<td>${currentlist.classroom }</td>
								<td>${currentlist.credit }</td>
								<td><input type="button" name="dropclass" value="철회"
									onclick="deleteRow(this)"></td>
							</tr>
						</c:forEach>
			</form>
		</table>
		</c:when>
		</c:choose>
	</section>
	<script src="../resources/currentlySignUp.js"></script>
</body>
</html>