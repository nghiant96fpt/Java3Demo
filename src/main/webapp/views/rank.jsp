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
	.error{
		color: red
	}
</style>
</head>
<body>
	<h1>Diem thi cuoi mon Java 3 - SD19303</h1>
	<form action="${pageContext.request.contextPath}/rank"
		method="post">
		<div>
			<label>Diem SV</label>
			<input value="${point}" name="point" type="number" step="0.0001" placeholder="Diem sinh vien"/>
			<c:if test="${error != null}">
				<p class="error">${error}</p>
			</c:if>
		</div>
		
		<div>
			<button type="submit">Xep loai</button>
		</div>
		
		
		<c:if test="${error == null && point != null}">
			<c:choose>
				<c:when test="${point >= 8}">
					<h1>Gioi</h1>
				</c:when>
				<c:when test="${point >= 6.5}">
					<h1>Kha</h1>
				</c:when>
				<c:when test="${point >= 5}">
					<h1>TB</h1>
				</c:when>
				<c:otherwise>
					<h1>Rot mon</h1>
				</c:otherwise>
			</c:choose>
		</c:if>
	</form>
</body>
</html>














