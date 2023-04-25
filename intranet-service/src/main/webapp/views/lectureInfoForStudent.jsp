<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="header" />
<link rel="stylesheet" href="../resources/lectureInfoForStudent.css">
<title>강의계획서조회(학생용)</title>
</head>
<body>
	<section>
	<form action="../service">
		<input type="hidden" name="command" value="showLectureInfo">
		<h2>학생메뉴 > 강의계획서조회(학생용)</h2>
		<h3>강의 계획서 조회하기</h3>
		<input type="text" name="className" placeholder="강의명을 입력하세요.">
		<input type="submit" value="검색하기">
	</form>
	</section>
</body>
</html>