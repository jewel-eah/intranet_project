<%@page import="user.User"%>
<%@page import="user.controller.UserDao"%>
<%@page import="lecture.Lecture"%>
<%@page import="lecture.controller.LectureDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="header" />
<link rel="stylesheet" href="../resources/showLectureInfo.css">
<title>강의계획서 조회</title>
</head>
<body>
	<section>
		<h2>학생메뉴 > 강의계획서조회(학생용) > 강의계획서</h2>
		<h3>강의명 : ${lecture.className }</h3>
		<h4>
			담당교수명 :
			${professorName }</h4>
		<h5>학수번호 : ${lecture.classCode } / 학과 : ${lecture.major }</h5><br>
		<p>  강의내용 <br><br> ${lecture.information }</p>
		<input type="button" value="뒤로가기"
			onclick="location.href='lectureInfoForStudent'">
	</section>
</body>
</html>