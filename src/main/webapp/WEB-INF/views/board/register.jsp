<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<style>
	#registerForm1 {
		width: 700px;
		margin: 50px auto;
		margin-bottom: 0;
		position: relative;
	}
	input[type="submit"] {
		display: none;
		float: right;
	}
	#imgWrap {
		width: 700px;
		height: 500px;
		margin: 10px auto;
		border: 1px solid #ccc;
		overflow: scroll;
	}
	#imgWrap img {
		width: 200px;
		height: 150px;
		float: left;
	}
</style>

	<section>
		<form action="register" method="post" enctype="multipart/form-data" id="registerForm1">
			<input type="hidden" name="writer" value="${Auth.userid}">
			<input type="file" name="imgFiles" multiple="multiple" id="file">
			<input type="submit" value="추가">
			<div id="imgWrap"></div>
		</form>
		
		<script>
			$("#file").change(function() {
				for(var i=0; i<$(this)[0].files.length; i++) {
					var reader = new FileReader();
					
					reader.onload = function(e) { //밑에 reader.~~ 파일을 다 읽으면 여기로 이동해서 실행해라
						var $img = $("<img>").attr("src", e.target.result);
						$("#imgWrap").append($img);
					}
					
					reader.readAsDataURL($(this)[0].files[i]);
										//$(this)[0] => 자바스크립트객체로변함
				}
				
				$("input[type='submit']").css("display", "inline");
			})
			
			$("#registerForm1").submit(function() {
				if($("#file").val() == "") {
					alert("파일을 선택하세요");
					return false;
				}
			})
		</script>
	</section>
</body>
</html>