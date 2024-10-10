<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link  rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/category-form"
		method="post"
		enctype="multipart/form-data">
		
		<input type="hidden" name="id" value="${cat == null ? '' : cat.id}"/>
		
		<div>
			<label>Tên danh mục</label>
			<input value="${cat.name}" name="name" type="text" placeholder="Tên danh mục"/>
		</div>
		<div>
			<label>Ảnh danh mục</label>
			<input type="file" accept="image/*" name="image"/>
		</div>
		<div>
			<button type="submit">${cat == null ? 'Thêm danh mục' : 'Sửa danh mục'}</button>
		</div>
	</form>
</body>
</html>