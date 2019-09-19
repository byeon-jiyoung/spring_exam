<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	header {
		border-bottom: 1px solid #ccc;
		overflow: hidden;
		padding: 0 20px;
	}
	header > img {
		width: 150px;
		height: 40px;
	}
	#head_icon {
		float: right;
	}
	#head_icon img {
		width: 30px;
		margin-right: 10px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<header>
		<img alt="google" src="${pageContext.request.contextPath}/resources/images/google.png">
		<div id="head_icon">
			<img src="${pageContext.request.contextPath}/resources/images/user-login-person-512.png" id="login_img">
			<img src="${pageContext.request.contextPath}/resources/images/plus-256.png">
			<img src="${pageContext.request.contextPath}/resources/images/_square_menu_four-256.png">
			<%-- <img src="${pageContext.request.contextPath}/resources/images/add_user-2-256.png"> --%>
		</div>
	</header>
	
	<script>
		$("#login_img").click(function() {
			location.href = "${pageContext.request.contextPath}/login/login";
		})
	</script>
