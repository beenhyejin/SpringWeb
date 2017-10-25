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
<title>공지사항목록</title>

<link href="${ctx}/resource/css/layout.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/resource/css/<tiles:getAsString name="css"/>" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<tiles:insertAttribute name="header" />
	<!-- --------------------------- <body> --------------------------------------- -->

	<!-- content 부분 -->
	<tiles:insertAttribute name="main" />	
	
	<!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer" />
</body>
</html>