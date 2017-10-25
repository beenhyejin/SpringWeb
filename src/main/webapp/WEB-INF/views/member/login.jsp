<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
    
<main>
	<form action="${path}/login" method="post">
		<label>아이디 :</label><input type="text" name="username"/><br/>
		<label>비밀번호 :</label><input type="text" name="password"/><br/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		<input type ="submit" value="로그인">
	</form>
</main>