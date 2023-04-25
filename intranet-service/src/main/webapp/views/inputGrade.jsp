<%@page import="SCData.SCData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.controller.UserDao"%>
<%@page import="lecture.controller.LectureDao"%>
<%@page import="SCData.controller.SCDataDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/professor.css">
<c:import url="header" />
<title>[교수탭] 성적입력</title>
</head>
<c:set var="scData" value="${scData }" />
<body>
	<section class="list">
		<h4 class="p_h4">강의목록 > 성적입력/정정</h4>
				<table class="lecturelist">
					<form method="POST" action="../service">
						<input type="hidden" name="command" value="inputGrade"> <input
							type="hidden" id="classCode" name="classCode"
							value="${param.classCode }">
					<tr>
						<th>학생코드</th>
						<th>이름</th>
						<th>전공</th>
						<th>성적</th>
						<th>성적입력/정정</th>
						<th></th>
					</tr>
		<c:choose>
			<c:when test="${empty scData }">
				<td colspan="6"><span>수강중인 학생이 없습니다.</span></td>
			</c:when>
			<c:when test="${not empty scData }">
					<c:forEach items="${scData }" var="scData">
						<tr id="${scData.userCode }">
							<td id="userCode">${scData.userCode }</td>
							<td id="userName">${scData.userName }</td>
							<td id="major">${scData.major }</td>
						<c:choose>
							<c:when test="${scData.grade eq '4.5' }">
								<td id="grade">A+</td>
							</c:when>
							<c:when test="${scData.grade eq '4.0' }">
								<td id="grade">A</td>
							</c:when>
							<c:when test="${scData.grade eq '3.5' }">
								<td id="grade">B+</td>
							</c:when>
							<c:when test="${scData.grade eq '3.0' }">
								<td id="grade">B</td>
							</c:when>
							<c:when test="${scData.grade eq '2.5' }">
								<td id="grade">C+</td>
							</c:when>
							<c:when test="${scData.grade eq '2.0' }">
								<td id="grade">C</td>
							</c:when>
							<c:when test="${scData.grade eq '1.5' }">
								<td id="grade">D+</td>
							</c:when>
							<c:when test="${scData.grade eq '1.0' }">
								<td id="grade">D</td>
							</c:when>
						<c:otherwise>
								<td id="grade">F</td>
							</c:otherwise>
						</c:choose>
							<td id="select-grade"><select id="score" name="score">
								<option value="" ${score eq '' ? 'selected="selected"' : ''}></option>
   								<option value="4.5" ${scData.grade eq '4.5' ? 'selected="selected"' : ''}>4.5</option>
   								<option value="4.0" ${scData.grade eq '4.0' ? 'selected="selected"' : ''}>4.0</option>
   								<option value="3.5" ${scData.grade eq '3.5' ? 'selected="selected"' : ''}>3.5</option>
   								<option value="3.0" ${scData.grade eq '3.0' ? 'selected="selected"' : ''}>3.0</option>
   								<option value="2.5" ${scData.grade eq '2.5' ? 'selected="selected"' : ''}>2.5</option>
   								<option value="2.0" ${scData.grade eq '2.0' ? 'selected="selected"' : ''}>2.0</option>
   								<option value="1.5" ${scData.grade eq '1.5' ? 'selected="selected"' : ''}>1.5</option>
   								<option value="1.0" ${scData.grade eq '1.0' ? 'selected="selected"' : ''}>1.0</option>
   								<option value="0.0" ${scData.grade eq '0.0' ? 'selected="selected"' : ''}>0.0</option>
							</select></td>
							<td><input class="modify" type="button" value="수정"></td>
						</tr>
					</c:forEach>
					</form>
				</table>
			</c:when>
		</c:choose>
	</section>
	<script type="text/javascript" src="../resources/inputGrade.js"></script>

</body>
</html>