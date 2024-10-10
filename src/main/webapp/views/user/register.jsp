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
	<form action="${pageContext.request.contextPath}/register"
		method="post"
		enctype="multipart/form-data">
		<div>
			<label>Ten tai khoan</label>
			<input name="username" type="text" placeholder="Ten tai khoan"/>
		</div>
		<div>
			<label>Mat khau</label>
			<input name="password" type="password" placeholder="Mat khau"/>
		</div>
		<div>
			<label>Email</label>
			<input name="email" type="email" placeholder="Mat khau"/>
		</div>
		<div>
			<label>Gioi tinh</label>
			<label>
				<input checked name="gender" value="0" type="radio" class="auto"/>
				Nam
			</label>
			<label>
				<input name="gender" value="1" type="radio" class="auto"/>
				Nu
			</label>
		</div>
		<div>
			<label>Nganh hoc</label>
			<select name="subject">
				<option value="-1" selected>-----Chon nganh hoc------</option>
				<option value="0">PTPM (Java)</option>
				<option value="1">PTPM (C#)</option>
				<option value="2">LTW (Back-End)</option>
				<option value="3">LTW (Front-End)</option>
			</select>
		</div>
		<div>
			<label>So thich</label>
			<label>
				<input name="hobbies" value="1" type="checkbox" class="auto"/>
				Xem phim
			</label>
			<label>
				<input name="hobbies" value="2" type="checkbox" class="auto"/>
				Lap trinh
			</label>
			<label>
				<input name="hobbies" value="3" type="checkbox" class="auto"/>
				Du lich
			</label>
		</div>
		
		<div>
			<label>Mo ta ban than</label>
			<textarea name="bio"></textarea>
		</div>
		
		<div>
			<label>Anh ca nhan</label>
			<input type="file" accept="image/*" multiple/>
		</div>
		
		<div>
			<button type="submit">Dang ky</button>
		</div>
	</form>
	
	<img style="width: 100px; height: 100px" src="${pageContext.request.contextPath}/assets/images/image3.webp"/>
</body>
</html>