<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="header" />
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/community.css">
<title>Community</title>
</head>
<body>
	<section>
		<div class="container">
			<h1>E Z E N 광장</h1>
			<div>
				<table border="1">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody id="contents-container"></tbody>
				</table>
			</div>
		</div>
		<div class="pagination">
			<a id="prev" href='?page=1'>이전</a>
			<div id="pageNum-container"></div>
			<a id="next" href='?page=1'>다음</a>
		</div>
		<div class="button"><input type="button" value="글쓰기" onclick="location.href='writeBoard'"></div>
	</section>
	<script src="../resources/communityList.js"></script>
</body>
</html>