<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="../resources/grid.css">
<title>통합정보시스템</title>
</head>

<body>
	<header class="header1">
		<h2>
			<a href="portalsite">통합정보시스템</a>
		</h2>
	</header>
	<header class="header2">
		<h2>
			<a>${log.userType }메뉴</a>
		</h2>
		<h2>
			<a href="community">커뮤니티</a>
		</h2>
		<h2>
			<a>웹메일</a>
		</h2>
		<h2>
			<a>도움말</a>
		</h2>
	</header>
	<header class="logout">
		<h2>
			<a href="../service?command=logout">로그아웃</a>
		</h2>
	</header>
	<c:choose>
		<c:when test="${log.userType.equals('학생') }">
			<nav>
				<ul class="menu">
					<h4>학생메뉴</h4>
					<li>학적정보</li>
					<ul>
						<li><a href="professorLogCheck">개인정보수정</a></li>
						<li><a href="studentInfo">학생종합정보</a></li>
					</ul>
					<li>수업수강</li>
					<ul>
						<li><a href="signupClass">수강신청</a></li>
						<li><a href="lectureInfoForStudent">수업계획서조회(학생용)</a></li>
						<li><a href="../service?command=currentlySignUpCheck">>수강신청현황</a></li>
					</ul>
					<li>성적</li>
					<ul>
						<li><a href="../service?command=viewGrade">성적조회(전체)</a></li>
					</ul>
				</ul>
			</nav>
		</c:when>

		<c:when test="${log.userType.equals('교수') }">
			<nav>
				<ul class="menu">
					<h4>교수메뉴</h4>
					<li>교수정보</li>
					<ul>
						<li><a href="professorLogCheck">개인정보수정</a></li>
						<li><a href="professorInfo">교수종합정보</a></li>
					</ul>
					<li>수업수강</li>
					<ul>
						<li><a href="../service?command=professorLectureList">강의목록</a></li>
						<li><a href="../service?command=lectureInfo">수업계획서작성/정정</a></li>
					</ul>
				</ul>
			</nav>
		</c:when>
		<c:when test="${log.userType.equals('관리자') }">
			<nav>
				<ul class="menu">
					<h4>관리자메뉴</h4>
					<li>유저관리</li>
					<ul>
						<li><a href="masterUserCreate">유저추가</a></li>
						<li><a href="masterUser">유저정보수정</a></li>
					</ul>
					<li>학부/학과</li>
					<ul>
						<li><a href="createDepartment">학부</a></li>
						<li><a href="createMajor">학과</a></li>
					</ul>
				</ul>
			</nav>
		</c:when>
	</c:choose>
</body>
</html>