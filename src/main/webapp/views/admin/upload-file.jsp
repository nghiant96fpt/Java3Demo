<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/upload-file"
		method="POST"
		enctype="multipart/form-data">
		<div>
			<label>Ten</label>
			<input name="name" type="text" placeholder="Ten"/>
		</div>
		
		<div>
			<label>Anh</label>
			<input accept="image/*" name="image" type="file" placeholder="Anh"/>
		</div>
		
		<div>
			<button type="submit">Luu anh</button>
		</div>
	</form>
</body>
</html>