<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input {
		width: 200px;
		height: 30px;
		margin: 10px
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="POST">
		<input value="${username}" placeholder="Tên tài khoản" type="text" name="username"/>
		<input value="${password}" placeholder="Mật khẩu" type="password" name="password"/>
		<button type="submit">Đăng nhập</button>
	</form>
</body>
</html>