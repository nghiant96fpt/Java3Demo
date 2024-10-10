<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
</head>
<body>

	<div class="container">
		<div class="table-responsive">
			<table class="table table-primary">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Tên</th>
						<th scope="col">Ảnh</th>
						<th scope="col">Hành động</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categories}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td><img
								src="${pageContext.request.contextPath}/assets/images/${item.image}"
								style="width: 100px; height: 100px" /></td>
							<td>
								<div class="row">
								<!-- category-form?id=1 -->
								<!-- http://localhost:8080/Java3Demo/ == ${pageContext.request.contextPath} -->
									<a class="btn btn-primary me-2 w-auto"
										href="${pageContext.request.contextPath}/category-form?id=${item.id}"> Sửa </a>
									<form action="${pageContext.request.contextPath}/delete-category"
										method="post">
										<input type="hidden" name="id" value="${item.id}"/>
										<button type="submit" class="btn btn-danger me-2 w-auto"> Xoá </button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>
</html>