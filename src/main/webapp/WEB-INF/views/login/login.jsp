<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<style>
	form {
		margin: 100px auto;
		width: 300px;
	}
	form > div {
		margin-bottom: 10px;
	}
	form label {
		width: 100px;
		float: left;
		line-height: 37px;
	}
	input[type="text"], input[type="password"] {
		padding: 10px;
		border-radius: 5px;
		border: 1px solid #aaa;
	}
	#submit_btn {
		margin-left: 100px;
	}
	input[type="submit"] {
		background-color: #4285f4;
		border: #4285f4;
		border-radius: 5px;
		color: white;
		padding: 10px 30px;
		margin-top: 10px;
	}
	form a {
		color: #4285f4;
		text-decoration: none;
		font-size: 0.9em;
	}
</style>

	<section>
		<form action="loginPost" method="post">
			<div>
				<label>아이디</label>
				<input type="text" name="userid">
			</div>
			<div>
				<label>비밀번호</label>
				<input type="password" name="userpw">
			</div>
			<div id="submit_btn">
				<input type="submit" value="로그인">
			</div>
			<a href="${pageContext.request.contextPath}/login/join">※ 회원가입 하시겠습니까?</a>
		</form>
		
		<c:if test="${error == 'notMatch'}">
			<script>
				setTimeout(function(){
					alert("아이디와 비밀번호가 일치하지 않습니다.");
				}, 100); 
			</script>
			<%
				session.removeAttribute("error");
			%> 
		</c:if>
   
	</section>
	
</body>
</html>