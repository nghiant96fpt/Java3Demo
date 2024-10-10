<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/user/header.jsp"%>

	<div style="padding: 20px">
		<h1>Profile page</h1>
		<h1>${param.name}</h1>
	</div>

	<%@ include file="/views/user/footer.jsp"%>
</body>
</html>