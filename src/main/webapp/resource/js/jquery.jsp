<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	window.addEventListener("load", function() {
		// DOM 객체들
		var chButton = document.getElementById("ch-button");
		//jQuery  객체로 바꾸는 방법1.	jQuery함수 이용하기
		var chButton = jQuery(_chButton);
		//2.jQuery  객체로 바꾸는 방법 $함수이용하기
		var chButton = $(_chButton);		
		//3.	jQuery 객체로 바꾸는 방법3 : CSS Selector 이용하기
		var chButton = $("#ch-button");
		
		chButton.onclick = function(){
		};
	});
</script>
</head>
<body>
	<!-- 노드 순환 예제 -->
	<input id="ch-button" type="button" value="배경색 변경" />
	<div>
		<div>1</div>
		<div id="p">
			<div>2</div>
		</div>
		<div>3</div>
	</div>
</body>
</html>