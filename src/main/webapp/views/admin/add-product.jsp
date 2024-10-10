<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input {
		width: 200px;
		height: 30px;
	}
	div {
		width: 100vw;
		margin-bottom: 16px;
	    display: flex;
	    flex-direction: column;
	    padding-left: 100px
	}
	label{
		margin-bottom: 8px;
	}
	.auto {
		width: auto;
		height: auto;
	}
	select {
		width: 200px;
		height: 30px;
	}
	textarea{
		width: 200px;
	}
	button{
		width: 200px
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/add-product"
		method="post"
		enctype="multipart/form-data">
		<div>
			<label>Tên sản phẩm</label>
			<input name="name" type="text" placeholder="Ten san pham"/>
		</div>
		<div>
			<label>Giá </label>
			<input name="price" type="number" placeholder="Gia san pham"/>
		</div>
		
		<div>
			<label>Mô tả sản phẩm </label>
			<input name="decs" type="text" placeholder="Gia san pham"/>
		</div>
		<div>
			<label>Danh muc san pham</label>
			<select name="category">
				<option value="-1" selected>-----Chon danh muc------</option>
				<c:forEach items="${cat}" var="item">
					<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>Ảnh sản phẩm </label>
			<input multiple type="file" accept="image/*" name="image"/>
		</div>
		<div>
			<button type="submit">Them san pham</button>
		</div>
	</form>
</body>
</html>