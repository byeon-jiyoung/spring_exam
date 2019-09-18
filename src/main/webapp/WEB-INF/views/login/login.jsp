<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<img alt="google" src="${pageContext.request.contextPath}/resources/images/google.png">
	</header>
	<section>
		<form>
			<input type="text" name="userid">
			<input type="text" name="userpw">
			<input type="submit" value="로그인">
		</form>
	</section>
</body>
</html>