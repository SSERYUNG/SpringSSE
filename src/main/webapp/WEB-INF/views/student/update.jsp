<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>�л� ���� ����</h1>

	<form action="./update" method="post">
		<div>
			<label for="name">�̸�</label> <input type="hidden" id="name"
				name="num" value="${requestScope.st.num}"> <input
				type="text" id="name" name="name" value="${requestScope.st.name}">


		</div>

		<div>
			<label for="kor">���� ����</label> <input type="text" id="kor" name="kor"
				value="${requestScope.st.kor}">


		</div>


		<div>
			<label for="eng">���� ����</label> <input type="text" id="eng" name="eng"
				value="${requestScope.st.eng}">


		</div>

		<div>
			<label for="math">���� ����</label> <input type="text" id="math"
				name="math" value="${requestScope.st.math}">


		</div>

		<button type=submit>���� �Ϸ�</button>
	</form>


</body>
</html>