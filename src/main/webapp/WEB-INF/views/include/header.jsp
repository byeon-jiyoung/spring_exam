<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	header {
		border-bottom: 1px solid #ccc;
		overflow: hidden;
		padding: 10px 20px;
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
	#logintext {
		margin-right: 10px;
		font-size: 0.9em;
	}
	#username {
		font-weight: bold;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<header>
		<img alt="google" src="${pageContext.request.contextPath}/resources/images/google.png">
		<div id="head_icon">
			<c:if test="${Auth != null}">
				<span id="logintext">[<span id="username">${Auth.username}</span>]님 반갑습니다.</span>
				<img src="${pageContext.request.contextPath}/resources/images/logout.png" id="logout_img">
				<img src="${pageContext.request.contextPath}/resources/images/plus.png" id="board_register">
				<img src="${pageContext.request.contextPath}/resources/images/menu.png" id="board_list">
			</c:if>
			<c:if test="${Auth == null}">
				<img src="${pageContext.request.contextPath}/resources/images/login.png" id="login_img">
				<%-- <img src="${pageContext.request.contextPath}/resources/images/plus.png" id="board_register">
				<img src="${pageContext.request.contextPath}/resources/images/menu.png"> --%>
			</c:if>
		</div>
	</header>
	
	<script>
		$("header > img").click(function() {
			location.href = "${pageContext.request.contextPath}/";
		})
	
		$("#login_img").click(function() {
			location.href = "${pageContext.request.contextPath}/login/login";
		})
		
		$("#logout_img").click(function() {
			var result = confirm("로그아웃 하시겠습니까?");
			
			if(result == true) {
				location.href = "${pageContext.request.contextPath}/login/logout";
			}
		})
		
		$("#board_register").click(function() {
			location.href = "${pageContext.request.contextPath}/board/register";
		})
		
		$("#board_list").click(function() {
			location.href = "${pageContext.request.contextPath}/board/list";
		})
	</script>
