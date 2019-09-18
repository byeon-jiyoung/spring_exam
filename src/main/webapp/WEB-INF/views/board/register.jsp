<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* #imgWrap {
		border: 1px solid black;
		width: 500px;
	} */
	#imgWrap img {
		width: 200px;
		float: left;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<form action="register" method="post" enctype="multipart/form-data">
		<div>
			<label>Files</label>
			<input type="file" name="imgFiles" multiple="multiple" id="file">
		</div>
		<input type="submit">
	</form>
	<div id="imgWrap"></div>
	
	<!-- <script>
		$("#file").change(function() {
			var reader = new FileReader();
			
			reader.onload = function(e) { //밑에 reader.~~ 파일을 다 읽으면 여기로 이동해서 실행해라
				var $img = $("<img>").attr("src", e.target.result);
				$("#imgWrap").append($img);
			}
			
			reader.readAsDataURL($(this)[0].files[0]);
								//$(this)[0] => 자바스크립트객체로변함
		})
	</script> -->
</body>
</html>