<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<style>
	#imgList {
		width: 1000px;
		margin: 50px auto;
		overflow: hidden;
	}
	.filelist {
		float: left;
		margin: 0 20px 10px 0;
		width: 180px;
	}
	.filelist p {
		margin: 5px; 
	}
	.filelist img {
		width: 100%;
		height: 100px;
	}
	.filelist .oriname {
		display: inline-block;
	}
	.filelist button {
		float: right;
		margin-top: 5px;
	}
	#bigImg {
		margin: 50px auto;
		width: 1000px;
		position: relative;
	}
	#bigImg > img {
		width: 100%;
	}
	.closeImg {
		position: absolute;
		right: 10px;
		top: 10px;
	}
	.closeImg img {
		width: 35px;
		border-radius: 10px;
	}
	#paging {
		text-align: center;
	}
	.pagination li {
		list-style: none;
		margin-right: 10px;
		display: inline-block;
	}
	.pagination li a {
		color: black;
		text-decoration: none;
	}
	.active {
		font-weight: bold;
		font-size: 1.1em;
	}
	.active a {
		color: #4285f4 !important;
	}
</style>

	<section>
		<div id="imgList">
			<c:forEach var="board" items="${list}">
				<div class="filelist">
					<p><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${board.regdate}"/></p>
					<img src="displayFile?filename=${board.file}" class="th_img" data-file="${board.file}">
					<p class="oriname">${board.originfile}</p>
					<c:if test="${board.writer == Auth.userid}">
						<button class="delBtn" data-bno="${board.bno}">삭제</button>
					</c:if>
				</div>
			</c:forEach>
		</div>
		<div id="paging">
			<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li><a href="list?page=${pageMaker.startPage-1}">&laquo;</a></li>
				</c:if>
				<c:forEach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					<li ${pageMaker.cri.page == idx ? 'class="active"' : ''}><a href="list?page=${idx}">${idx}</a></li>
				</c:forEach>
				<c:if test="${pageMaker.next}">
					<li><a href="list?page=${pageMaker.endPage+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
		<div id="bigImg"></div>
		
		<script>
			$(document).on("click", ".th_img", function() {
				$("#bigImg").empty();
				$("#imgList").hide();
				$("#paging").hide();
				
				var fileName = $(this).attr("data-file");
				var originFilename = fileName.substring(0, 12) + fileName.substring(14);
				
				$img = $("<img>").attr("src", "displayFile?filename="+originFilename);
				
				$("#bigImg").append($img);
				$div_img2 = $("<div>").addClass("closeImg");
				$img2 = $("<img>").attr("src", "${pageContext.request.contextPath}/resources/images/close3.png");
				
				$div_img2.append($img2);
				$("#bigImg").append($img).append($div_img2);
				
				$(document).on("click", ".closeImg", function() {
					$("#bigImg").empty();
					$("#imgList").show();
					$("#paging").show();
				})
			})
			
			$(document).on("click", ".delBtn", function() {
				var result = confirm("삭제하시겠습니까?");
				var bno = $(this).attr("data-bno");
				var writer = "${Auth.userid}";
				
				if(result == true) {
					$.ajax({
						url : "${pageContext.request.contextPath}/board/delete",
						type : "post",
						data : {"bno":bno},
						dataType: "json",
						success : function(res) {
							console.log(res);
							
							$("#imgList").empty();
							
							/* <div class="filelist">
								<p><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${board.regdate}"/></p>
								<img src="displayFile?filename=${board.file}" class="th_img" data-file="${board.file}">
								<p class="oriname">${board.originfile}</p>
								<c:if test="${board.writer == Auth.userid}">
									<button class="delBtn" data-bno="${board.bno}">삭제</button>
								</c:if>
							</div> */
							
							$(res).each(function(i, obj) {
								var regdate = new Date(obj.regdate);
								
								$div = $("<div>").addClass("filelist");
								$regdate = $("<p>").text(regdate.getFullYear()+"년"+("00" + (regdate.getMonth() + 1)).slice(-2)+"월"+("00" + regdate.getDate()).slice(-2)+"일");
								$img = $("<img>").attr("src", "displayFile?filename="+obj.file).attr("data-file", obj.file).addClass("th_img");
								$oriname = $("<p>").text(obj.originfile).addClass("oriname");
								$button = $("<button>").text("삭제").addClass("delBtn").attr("data-bno", obj.bno);
								
								if(obj.writer == writer) {
									$div.append($regdate).append($img).append($oriname).append($button);
								}else {
									$div.append($regdate).append($img).append($oriname);
								}
								
								$("#imgList").append($div);
							})
						}
					})
				}else {
					return false;
				}
			})
		</script>
	</section>
</html>