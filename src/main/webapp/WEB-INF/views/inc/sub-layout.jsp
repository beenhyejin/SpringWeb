<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width,initial-scale=1"> -->
<title></title>
<c:set var="path" value="" />
 <link href="${ctx}/resource/css/<tiles:getAsString name="path" />/layout.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/resource/js/lib/notepubs/web-editor/editor.css" type="text/css" rel="stylesheet" />
</head>
<body>
	${pageContext.request.contextPath}
	<!-- header 부분 -->
	<tiles:insertAttribute name="header" />
	<!-- --------------------------- <visual> --------------------------------------- -->
	<!-- visual 부분 -->
	<tiles:insertAttribute name="visual" />
	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- --------------------------- aside --------------------------------------- -->
			<!-- aside 부분 -->
			<tiles:insertAttribute name="aside" />
			<!-- --------------------------- main --------------------------------------- -->
			
			<!-- content 부분 -->
			<tiles:insertAttribute name="main" />
			
		</div>
	</div>
	<!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer" />
</body>
</html>