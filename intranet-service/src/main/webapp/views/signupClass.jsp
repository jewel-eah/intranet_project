<%@page import="currentlySignUp.CurrentlySignUp"%>
<%@page import="currentlySignUp.controller.CurrentlySignUpDao"%>
<%@page import="signUpClass.controller.SignUpClassDao"%>
<%@page import="signUpClass.SignUpClass"%>
<%@page import="user.controller.UserDao"%>
<%@page import="user.User"%>
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
<link rel="stylesheet" href="../resources/signupClass.css">
<title>예비수강신청 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<c:if test="${empty list }">
	<c:redirect
		url="service?command=signUpCheckClass" />
</c:if>
<body>	
	
<header>
	<h2>수강신청</h2>
</header>

<nav>
<%-- 학생정보칸 --%>
	<table border = "1">
		<tr>
			<th>이름</th>
			<td>${log.userName }</td>
		</tr>
		<tr>
			<th>학번</th>
			<td>${log.userCode }</td>
		</tr>
		<tr>
			<th>학부</th>
			<td>${log.depName }</td>
		</tr>
		<tr>
			<th>주전공</th>
			<td>${log.mainMajor }</td>
		</tr>
		<tr>
			<th>부전공</th>
			<td>${log.subMajor != null ? log.subMajor : ""}</td>
		</tr>
		<tr>
			<th>이수학기</th>
			<td>${log.semester }</td>
		</tr>
		<tr>
			<th>학년</th>
			<td>${log.semester / 2  + 1 }</td>
		</tr>
	</table>
	
	<div>
		<input type="button" class="backspace" value="포탈사이트로 돌아가기" onclick="location.href='portalsite'">
	</div>
</nav>

<section class="lectureList">
	<h3>신청가능목록</h3>
	<div>
		<table id="selectedSubject">
			<tr class="category">
				<th>이수구분</th>
				<th>강의명</th>
				<th>전공</th>
				<th>대학</th>
				<th>교수명</th>
				<th>강의실</th>
				<th>학점</th>
				<th>신청</th>
			</tr>
			<c:forEach items="${list}" var="lecture">
				<tr>
					<td id="classification">${lecture.classification }</td>
					<td id="classname">${lecture.className }</td>
					<td id="major">${lecture.major }</td>
					<td id="department">${lecture.department }</td>
					<td id="professorname">${lecture.professorName }</td>
					<td id="classroom">${lecture.classroom }</td>
					<td id="credit">${lecture.credit }</td>
					<td><input type="button" class="signUp" value="추가" data-classname="${lecture.classification }, ${lecture.className }, ${lecture.major }, ${lecture.department }, ${lecture.professorName}, ${lecture.classroom }, ${lecture.credit }"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</section>

<section class="myList">
	<form method="POST" action="../service">
		<input type="hidden" name="command" value="signupClass">
		<div class="text">
			<h3>수강신청내역</h3>
		</div>
		<div class="determine">
			<input type="submit" class="lectureEnroll" value="수강신청하기">
		</div>
		<table id="signupList">
			<tr name="standard" id="standard">
				<th>이수구분</th>
				<th>강의명</th>
				<th>전공</th>
				<th>대학</th>
				<th>교수명</th>
				<th>강의실</th>
				<th>학점</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${currentlylist}" var="currentSignUp">
			<tr name="currentlySignUpList" id="currentlySignUpList">
				<td><input type="text" name="myclassification" value="${currentSignUp.classification }" readonly></td>
				<td><input type="text" name="myclassname" value="${currentSignUp.className }" readonly></td>
				<td><input type="text" name="mymajor" value="${currentSignUp.major }" readonly></td>
				<td><input type="text" name="mydepartment" value="${currentSignUp.department }" readonly></td>
				<td><input type="text" name="myusername" value="${currentSignUp.userName }" readonly></td>
				<td><input type="text" name="myclassroom" value="${currentSignUp.classroom }" readonly></td>
				<td><input type="text" name="mycredit" value="${currentSignUp.credit }" readonly></td>
			</tr>
			</c:forEach>
		</table>
	</form>
</section>
	<script src="../resources/signupClass.js"></script>
</body>
</html>