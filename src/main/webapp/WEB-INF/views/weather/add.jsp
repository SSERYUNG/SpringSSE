<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>날씨 정보 입력</h1>
	<form action="./add" method="post">
	<div>
		<label>도시명</label>
		<input type="text" name="city">
		
	</div>
	<div>
		<label> 기온</label>
		<input type="text" name="gion">
	</div>
	<div>
		<label> 습도</label>
		<input type="text" name="huminity">
	</div>
	<div>
		<label> 날씨</label>
		<input type="text" name="status">
	</div>
	

	<button type="submit">등록</button>
	
	
	
	</form>
</body>
</html>