<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<header id="header">
	<div>
		<img class="hamburger-button"
			src="${ctx}/resource/images/ic_menu_black_24dp_1x.png" />
	</div>
	<div class="content-container">
		<!-- ---------------------------<header>--------------------------------------- -->

		<h1 id="logo">
			<a href="${ctx}/index"> 
				<img src="${ctx}/resource/images/logo.png" alt="뉴렉처 온라인" />
				<%-- <picture>
					<source media="(min-width: 960px)" srcset="${ctx}/resource/images/logo.png">
					<img src="${ctx}/resource/images/logo-sm.png" alt="뉴렉처 온라인" /> 
				</picture> --%>
			</a>
		</h1>

		<section>
			<h1 class="hidden">헤더</h1>

			<nav id="main-menu">
				<h1>메인메뉴</h1>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">뉴렉과정</a></li>
					<li><a href="">강좌선택</a></li>
				</ul>
			</nav>

			<div class="sub-menu">
				<section id="search-form">
					<h1>강좌검색 폼</h1>
					<form>
						<fieldset>
							<legend>과정검색필드</legend>
							<label>과정검색</label> <input type="text" value="" /> <input
								type="submit" value="검색" />
						</fieldset>
					</form>
				</section>

				<nav id="acount-menu">
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><a href="${ctx}/index">HOME</a></li>
						
						<security:authorize access="!hasRole('ROLE_USER')">
							<li><a href="${ctx}/member/login">로그인</a></li>
						</security:authorize>
						<%-- <c:if test="${empty pageContext.request.userPrincipal}">
							<li><a href="${ctx}/member/login">로그인</a></li>
						</c:if> --%>
						<security:authorize access="hasRole('ROLE_USER')">
						<li>
							<form action="${ctx}/logout" method="post">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type="submit" value="로그아웃"/>
							</form>
						</li>
							<%-- li><a href="${ctx}/logout">
							<security:authentication property="name"/>님 로그아웃</a></li> --%>
						</security:authorize>
						<%-- <c:if test="${not empty pageContext.request.userPrincipal}">
							<li><a href="${ctx}/j_spring_security_logout"> ${pageContext.request.userPrincipal.name}님 로그아웃
									<security:authentication property="name"/>님 로그아웃
							</a></li>
						</c:if> --%>

						<li><a href="${ctx}/member/agree">회원가입</a></li>
					</ul>
				</nav>

				<nav id="member-menu" class="linear-layout">
					<h1 class="hidden">고객메뉴</h1>
					<ul class="linear-layout">
						<li><a href="${ctx}/member/home"><img
								src="${ctx}/resource/images/txt-mypage.png" alt="마이페이지" /></a></li>
						<li><a href="${ctx}/customer/notice"><img
								src="${ctx}/resource/images/txt-customer.png" alt="고객센터" /></a></li>
					</ul>
				</nav>

			</div>
		</section>

	</div>
	<div class="search-button">
		<img src="${ctx}/resource/images/ic_search_black_24dp_1x.png" />
	</div>
	<div class="more-vert-button">
		<img src="${ctx}/resource/images/ic_more_vert_black_24dp_1x.png" />
	</div>
</header>
<script src="${ctx}/resource/js/header.js"></script>