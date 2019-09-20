<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<style>
	form {
		margin: 50px auto;
		width: 450px;
	}
	form > div {
		margin-bottom: 5px;
	}
	form label {
		width: 150px;
		float: left;
		line-height: 37px;
	}
	.reg, .error {
		display: none;
		color: red;
		font-size: 0.8em;
		margin-left: 150px;
	}
	input[type="text"], input[type="password"] {
		padding: 10px;
		border-radius: 5px;
		border: 1px solid #aaa;
	}
	button, input[type="submit"] {
		background-color: #4285f4;
		border: #4285f4;
		border-radius: 5px;
		color: white;
		padding: 8px 15px;
	}
	#submit_btn {
		margin-left: 150px;
	}
	input[type="submit"] {
		padding: 10px 30px;
		margin-top: 10px;
	}
</style>

<script>
	var check = false;
	$(function() {
		$("#idCheck").click(function(e) {
			e.preventDefault();
			
			var id = $("input[name='userid']").val();

			$.ajax({
				url : "${pageContext.request.contextPath}/login/idcheck",
				type : "post",
				data : {"userid":id},
				dataType: "text",
				success : function(res) {
					console.log(res);
					
					if(res == "yes") {
						alert("이미 존재하는 아이디 입니다");
						$("input[name='userid']").val("");
					}else {
						alert("사용가능한 아이디 입니다.");
						check = true;
					}
				}
			})
		})
		
		$("#f1").submit(function() {
			$(".reg").css("display", "none");
			$(".error").css("display", "none");
			
			var reg_id = /^[a-z][a-z0-9]{6,15}$/i;
			var reg_name = /^[가-힣]{2,5}$/;
			var reg_pw = /^[a-z][a-z0-9!@#$%]{7,14}$/i;
			var reg_email = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;
			var reg_tel = /^(010|011|016|017|018)?[0-9]{3,4}?[0-9]{4}$/;
			
			
			if($("input[name='userid']").val() == "" || reg_id.test($("input[name='userid']").val()) == false) {
			$("input[name='userid']").nextAll(".reg").css("display", "block");
				return false;
			}
			
			if($("input[name='userpw']").val() == "" || reg_pw.test($("input[name='userpw']").val()) == false) {
				$("input[name='userpw']").nextAll(".reg").css("display", "block");
				return false;
			}
			
			if($("input[name='userpwCheck']").val() == "") {
				$("input[name='userpwCheck']").nextAll(".reg").css("display", "block");
				return false;
			}
			
			if($("input[name='userpw']").val() != $("input[name='userpwCheck']").val()) {
				$("input[name='userpwCheck']").nextAll(".error").css("display", "block");
				return false;
			}
			
			if($("input[name='username']").val() == "" || reg_name.test($("input[name='username']").val()) == false) {
				$("input[name='username']").nextAll(".reg").css("display", "block");
				return false;
			}
			
			if($("input[name='email']").val() == "" || reg_email.test($("input[name='email']").val()) == false) {
				$("input[name='email']").nextAll(".reg").css("display", "block");
				return false;
			}
			
			if($("input[name='tel']").val() == "" || reg_tel.test($("input[name='tel']").val()) == false) {
				$("input[name='tel']").nextAll(".reg").css("display", "block");
				return false;
			}
			
			if(check == false) {
				alert("아이디 중복체크를 해주세요.");
				return false;
			}
			
			alert("회원가입에 성공하였습니다. 로그인해주세요");
		})
	})
</script>

	<section>
		<form action="join" method="post" id="f1">
			<div>
				<label>아이디</label>
				<input type="text" name="userid">
				<button id="idCheck">중복 체크</button>
				<span class="reg">6~15자리로 입력해 주세요</span>
			</div>
			<div>
				<label>비밀번호</label>
				<input type="password" name="userpw">
				<span class="reg">8~20자리로 입력해 주세요</span>
			</div>
			<div>
				<label>비밀번호확인</label>
				<input type="password" name="userpwCheck">
				<span class="reg">비밀번호와 일치하게 입력해 주세요</span>
				<span class="error">비밀번호가 일치하지 않습니다</span>
			</div>
			<div>
				<label>이름</label>
				<input type="text" name="username">
				<span class="reg">한글 입력하세요</span>
			</div>
			<div>
				<label>email</label>
				<input type="text" name="email">
				<span class="reg">이메일을 다시 입력하세요</span>
			</div>
			<div>
				<label>전화번호</label>
				<input type="text" name="tel">
				<span class="reg">전화번호를 다시 입력하세요</span>
			</div>
			<div id="submit_btn">
				<input type="submit" value="회원가입">
			</div>
		</form>
	</section>
	
</body>
</html>