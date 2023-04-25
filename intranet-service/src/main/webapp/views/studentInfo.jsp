<%@page import="user.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.controller.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info</title>
<link rel="stylesheet" href="../resources/studentInfo.css">
</head>
<c:import url="header" />
<body>
	<section class="studentInfo">
		<h2>학생정보</h2>
		<h3>학생정보</h3>
		<table>
			<tr>
				<td>학번</td>
				<td>${log.userCode }</td>
			</tr>
			<tr>
				<td>성명(한글)</td>
				<td>${log.userName }</td>
			</tr>
			<tr>
				<td>학부</td>
				<td>${log.depName }</td>
			</tr>
			<tr>
				<td>학과(전공)</td>
				<td>${log.mainMajor }</td>
			</tr>
			<tr>
				<td>학과(복수전공)</td>
				<td>${log.subMajor != null ? log.subMajor : ""}</td>
			</tr>
			<tr>
				<td>이수학기</td>
				<td>${log.semester }</td>
			</tr>
			<tr>
				<td>학년</td>
				<td>${log.semester / 2  + 1}</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${log.gender }</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>${log.phone }</td>
			</tr>
			<tr>
				<td>졸업여부</td>
				<td>${log.graduate != null ? "YES" : "NO" }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${log.email }</td>
			</tr>
		</table>

		<hr />
		<h3>기본정보</h3>
		<table>
			<tr>
				<td>성명(한글)</td>
				<td>${log.userName }</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${log.birthDate }</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${log.gender }</td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td>${log.phone }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${log.email }</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>${log.addressCode }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${log.address }</td>
			</tr>
			<tr>
				<td>은행명</td>
				<td>${log.bankName }</td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td>${log.accountNum }</td>
			</tr>
			<tr>
				<td>예금주</td>
				<td>${log.accountName }</td>
			</tr>
		</table>
		<hr />

		<h3>입학정보</h3>
		<table>
			<tr>
				<td>입학일자</td>
				<td>${log.admDate }</td>
			</tr>
			<tr>
				<td>입학전형</td>
				<td>${log.admType }</td>
			</tr>
		</table>
		<hr />

		<h3>소속/전공</h3>
		<table>
			<tr>
				<td>소속학부</td>
				<td>${log.depName }</td>
			</tr>
			<tr>
				<td>주전공</td>
				<td>${log.mainMajor }</td>
			</tr>
			<tr>
				<td>복수전공</td>
				<td>${log.subMajor != null ? log.subMajor : ""}</td>
			</tr>
		</table>
		<hr />

		<h3>졸업사항</h3>
		<table>
			<tr>
				<td>졸업일자</td>
				<td>${log.graduate != null ? log.graduate : ''}</td>
			</tr>
			<tr>
				<td>졸업학위</td>
				<td>${log.graduate != null ? log.degree : ''}</td>
			</tr>
		</table>
	</section>
</body>
</html>