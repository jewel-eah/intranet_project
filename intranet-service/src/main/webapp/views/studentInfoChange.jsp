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
<title>Student Info Change</title>
<link rel="stylesheet" href="../resources/studentInfo.css">
</head>
<c:import url="header" />
<body>
	<section class="studentInfoChange">
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="studentUpdate">
			<h3>기본정보</h3>
			<table>
				<tr>
					<td>성명(한글)*</td>
					<td><input name="userName" type="text" value=${log.userName }
						required></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input name="birthDate" type="text"
						value=${log.birthDate }></td>
				</tr>
				<tr>
					<td>성별*</td>
					<td><input type="radio" name="gender" value="남"
						${log.gender == "남" ? 'checked' : ""}> <label for="men">남</label>
						<input type="radio" name="gender" value="여"
						${log.gender == "여" ? 'checked' : ""}> <label for="women">여</label>
					</td>
				</tr>
				<tr>
					<td>휴대폰*</td>
					<td><input name="phone" type="text" value="${log.phone }"
						pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required></td>
				</tr>
				<tr>
					<td>이메일*</td>
					<td><input type="email" name="email" value="${log.email }"
						pattern="[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.]+[a-zA-Z]+[.]*[a-zA-Z]*"
						size="20" required></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addressCode" id="sample6_postcode" value="${log.addressCode }"
						placeholder="우편번호"> 
						<input type="button"
						onclick="sample6_execDaumPostcode()" value="우편번호 찾기"> <br>
						<input type="text" name="address" id="sample6_address" value="${log.address }" placeholder="주소">
						<br> 
						<input type="text" id="sample6_detailAddress"
						placeholder="상세주소"> <input type="text"
						id="sample6_extraAddress" placeholder="참고항목"> <script
							src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
					</td>
				</tr>
				<tr>
					<td>은행명</td>
					<td><input name="bankOffice" type="text"
						value=${log.bankName }></td>
				</tr>
				<tr>
					<td>계좌번호</td>
					<td><input name="account" type="text" value="${log.accountNum }"></td>
				</tr>
				<tr>
					<td>예금주</td>
					<td><input name="accountName" type="text"
						value=${log.accountName }></td>
				</tr>
			</table>
			<input type="submit" value="수정하기">
		</form>
		<script src="../resources/addressAPI.js"></script>
	</section>
</body>
</html>