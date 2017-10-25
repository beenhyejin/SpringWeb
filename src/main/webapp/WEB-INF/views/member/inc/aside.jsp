<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<c:set var="url">${requestScope['javax.servlet.forward.request_uri']}</c:set>
<c:set var="isNotice">${fn:indexOf(url, "notice")>0?'current':''}</c:set>
<c:set var="isQuestion">${fn:indexOf(url, "question")>0?'current':''}</c:set>
<c:set var="isGuide">${fn:indexOf(url, "guide")>0?'current':''}</c:set>

			<aside class="aside">
				<h1>고객센터</h1>

				<nav class="menu text-menu first margin-top">
					<h1>고객센터메뉴</h1>
					<ul>
						<li class="${isNotice}"><a class="active"  href="${ctx}/customer/notice">공지사항</a></li>
						<li class="${isQuestion}"><a href="${ctx}/customer/question">고객문의</a></li>
						<li class="${isGuide}"><a href="${ctx}/customer/guide">학습안내</a></li>
					</ul>
				</nav>

				<nav class="menu">
					<h1>추천사이트</h1>
					<ul>
						<li><img src="${ctx}/resource/images/answeris.png" alt="앤서이즈" /></li>
						<li><a href="http://www.notepubs.com"><img src="${ctx}/resource/images/notepubs.png" alt="노트펍스" /></a></li>
						<li><img src="${ctx}/resource/images/microsoft.png" alt="마이크로소프트" /></li>
					</ul>
				</nav>

				<!-- <nav class="menu">
					<h1>협찬광고</h1>
					<ul>
		                <li style="width:181px;overflow:hidden;">                            
                                             
		                </li>  
                        <li style="width:181px;overflow:hidden;">                            
                                               
		                </li>
                    </ul>					
				</nav> -->
				
								
			</aside>