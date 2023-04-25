<%@page import="major.Major"%>
<%@page import="major.controller.MajorDao"%>
<%@page import="user.User"%>
<%@page import="user.controller.UserDao"%>
<%@page import="department.Department"%>
<%@page import="department.controller.DepartmentDao"%>
<%@page import="java.util.ArrayList"%>
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
	<c:if test="${empty user || empty department || empty major }">
		<c:redirect url="service?command=userUpdate&userCode=${param.userCode }" />
	</c:if>
	
	<section>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="masterUserUpdate">
			<h3>기본정보</h3>
			<table>
				<tr>
					<td>학번</td>
					<td><input name="userCode" type="number"
						value="${user.userCode }" required></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input name="password" type="password"
						value="${user.userPassword }" readonly></td>
				</tr>
				<tr>
					<td>성명(한글)*</td>
					<td><input name="userName" type="text"
						value="${user.userName }" required></td>
				</tr>
				<tr>
					<td>직업</td>
					<td><input name="userType" type="text"
						value="${user.userType }" required></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input name="birthDate" type="date"
						placeholder="dd-mm-yyyy" min="1990-01-01"
						value="${user.birthDate }"></td>
				</tr>
				<tr>
					<td>성별*</td>
					<td><input type="radio" name="gender" value="남"
						${user.gender == "남" ? 'checked' : ""}> <label for="men">남</label>
						<input type="radio" name="gender" value="여"
						${user.gender == "여" ? 'checked' : ""}> <label for="women">여</label>
					</td>
				</tr>
				<tr>
					<td>휴대폰*</td>
					<td><input name="phone" type="text" value="${user.phone }"
						pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required></td>
				</tr>
				<tr>
					<td>이메일*</td>
					<td><input type="email" name="email" value="${user.email }"
						pattern="[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.]+[a-zA-Z]+[.]*[a-zA-Z]*"
						size="20" required></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addressCode"
						id="sample6_postcode" value="${user.addressCode }"
						placeholder="우편번호"> <input type="button"
						onclick="sample6_execDaumPostcode()" value="우편번호 찾기"> <br>
						<input type="text" id="sample6_address" name="address"
						value="${user.address }" placeholder="주소"> <br> <input
						type="text" id="sample6_detailAddress" placeholder="상세주소">
						<input type="text" id="sample6_extraAddress" placeholder="참고항목">
						<script
							src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
					</td>
				</tr>
				<tr>
					<td>은행명</td>
					<td><input name="bankOffice" type="text"
						value="${user.bankName }"></td>
				</tr>
				<tr>
					<td>계좌번호</td>
					<td><input name="account" type="text"
						value="${user.accountNum }"></td>
				</tr>
				<tr>
					<td>예금주</td>
					<td><input name="accountName" type="text"
						value="${user.accountName }"></td>
				</tr>
			</table>

			<h3>입학정보</h3>
			<table>
				<tr>
					<td>입학일자</td>
					<td><input name="admissionDate" type="date"
						placeholder="dd-mm-yyyy" min="1990-01-01" value="${user.admDate }"></td>
				</tr>
				<tr>
					<td>입합전형</td>
					<td><select name="admissionType">
							<option ${user.admType == null ? 'selected="selected"' : '' }>선택하기</option>
							<option ${user.admType == '정시' ? 'selected="selected"' : '' }>정시</option>
							<option ${user.admType == '수시' ? 'selected="selected"' : '' }>수시</option>
					</select></td>
				</tr>
			</table>
			<h3>소속/전공</h3>
			<table>
				<tr>
					<td>소속학부</td>
					<td>${user.depName }</td>
					<td><select id="department" name="department"
						onchange="optionChange();" required>
							<option value="">학부선택</option>
							<c:forEach items="${department }" var="department">
								<option value="${department.depCode }">${department.depName }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>주전공</td>
					<td>${user.mainMajor }</td>
					<td><select id="mainMajor" name="mainMajor" required>
							<option value="">학과선택</option>
					</select></td>
				</tr>
				<tr>
					<td>복수전공</td>
					<td>${user.subMajor }</td>
					<td><select id="subMajor" name="subMajor">
							<option value="">학과선택</option>
							<c:forEach items="${major }" var="major">
								<option value="${major.majorName }">${major.majorName }</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>

			<h3>졸업사항</h3>
			<table>
				<tr>
					<td>졸업일자</td>
					<td><input name="graduate" type="date"
						placeholder="dd-mm-yyyy" min="1990-01-01"
						value="${user.graduate }"></td>
				</tr>
				<tr>
					<td>졸업학위</td>
					<td><input type="text" name="degree"
						value="${user.graduate != null ? '학사' : '' }"></td>
				</tr>
				<tr>
					<td>이수학기</td>
					<td><input type="text" name="semester"
						value="${user.semester }"></td>
				</tr>
			</table>
			<input type="submit" value="수정하기"> <a
				href="../service?command=masterUserDelete&userCode=${user.userCode }">삭제하기</a>
		</form>
	</section>
	<script src="../resources/addressAPI.js"></script>
	<script src="../resources/userUpdate.js"></script>
</body>
</html>