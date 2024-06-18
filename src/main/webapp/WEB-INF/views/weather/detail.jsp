<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>도시 날씨 정보</h1>
		<h3>${requestScope.dto.city }</h3>
	<h3>${requestScope.dto.num }</h3>
	<h3>${requestScope.dto.gion }</h3>
	<h3>${requestScope.dto.status }</h3>
	<h3>${requestScope.dto.huminity }</h3>
		
		
		<form id="frm" action="./delete" method="POST">
			<input id="num" type="hidden" name="num" value="${requestScope.dto.num }" >
		</form>
		
	
		<button type="submit"  id="btn">DELETE</button>
		<button type="submit"  id="up">UPDATE</button>
		
		<script type="text/javascript">
		const frm=document.getElementById('frm');
		const btn=document.getElementById('btn');
		const up=document.getElementById('up');
		up.addEventListener('click',function(){
			//method를 get으로 변경
			frm.setAttribute("method","get");
			frm.setAttribute("action","update");
			frm.submit();
			alert("클릭됨");
		})
		
		btn.addEventListener('click',function(){
			frm.submit();
			alert("클릭됨");
		})
		
		</script>
</body>
</html>