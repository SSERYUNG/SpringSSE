<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/table.css" rel="stylesheet">
</head>
<body>
	<h1>날씨 정보</h1>
	<table class ="tbl">
	<thead>
		<tr>
		<th>번호</th>
			<th>도시</th>
			<th>온도</th>
			<th>상태</th>
			<th>습도</th>
		</tr>
	</thead>
	
	<tbody>	
	<c:forEach items="${requestScope.list }" var="weather">
			<tr>
			<td>${pageScope.weather.num}</td>
				<td><a href="./detail?num=${pageScope.weather.num}">${pageScope.weather.city}</a></td>
				<td> ${pageScope.weather.gion }</td>
				<td> ${pageScope.weather.status}</td>
				<td> ${pageScope.weather.huminity}</td>
			</tr>
		
			</c:forEach>
	</tbody>
	</table>
		<div>
		<a href="./add">날씨 정보 추가</a>
		</div>
	
</body>
</html>