<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/url1" method="post">
		<!-- send data => /url2  -->
		<button type="submit" formaction="/url2">Button A</button>
		<button type="submit" formaction="/url3">Button B</button>
		<button type="submit">Button C</button>
		
		<button type="submit" formmethod="get">Button D</button>
		<button 
			type="submit" 
			formmethod="post" 
			formaction="/url2"
		>
			Button E
		</button>
	</form>
</body>
</html>