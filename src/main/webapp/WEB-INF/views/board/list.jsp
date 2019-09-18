<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container {
		width: 1000px;
		margin: 0 auto;
	}
	header {
		border-bottom: 1px solid #ccc;
	}
	header img {
		width: 150px;
		height: 40px;
	}
</style>
</head>
<body>
	<div id="container">
		<header>
			<img alt="google" src="${pageContext.request.contextPath}/resources/images/google.png">
		</header>
		<section>
			<div>
				<c:forEach var="board" items="${list}">
					<p><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></p>
					<p>${board.file}</p>
				</c:forEach>
			</div>
		</section>
	</div>
</body>
</html>