<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/login.css">
<title>Insert title here</title>
</head>
<body>
	<section class="collegename">
	<div class="system-text">
		<p>이젠대학교 통합정보시스템
	</div>
	<div class="image">
		<img src="https://www.snu.ac.kr/webdata/kor/gallery/thumb/4cez9c0zb5dz7c2z7b5z762z427z3b3zdf5z200z98.jpg">
	</div>
	<div class="name">
		<p class="login-text">EZEN UNIVERSITY</p>
		<p>Login</p>
	</div>
	</section>
	<section class="login">
		<form method="POST" action="../service">
		<input type="hidden" name="command" value="login">
		<table class="info">
			<tr>
				<th>ID</th>
				<td><input type="text" id="userCode" name="userCode" placeholder="아이디" required></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" id="userPassword" name="userPassword" placeholder="비밀번호" required onkeydown="if (event.keyCode == 13) checkValues(this.form)"></td>
				<td><input type="button" value="로그인" onclick="checkValues(form)"></td>
			</tr>
		</table>
		</form>
		
		<div class="caution">
			<p>창이 넘어가지 않을 시에는 브라우저를 재시작하고 시도해 주세요</p>
			<p> ※ 통합정보시스템은 인터넷익스플로어 9, 10과 Chrome에 최적화되어 있습니다.
			<p><a href="https://www.google.co.kr/chrome/?brand=JJTC&gclid=CjwKCAjw0N6hBhAUEiwAXab-TRtCjWkviDW6P-ymOpPh6yEFIk1WGoBerERxKR9PTFZi3w8uj-3AmxoCnUwQAvD_BwE&gclsrc=aw.ds">※ Chrome 다운로드</a>
		</div>
	</section>
	
	<script src="../resources/login.js"></script>
</body>
</html>