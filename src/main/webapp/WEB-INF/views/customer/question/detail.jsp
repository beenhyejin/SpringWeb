<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<main>
		<h2 class="main title">고객문의</h2>
		
		<div class="breadcrumb">
			<h3 class="hidden">breadlet</h3>
			<ul>
				<li>home</li>
				<li>고객센터</li>
				<li>고객문의</li>
			</ul>
		</div>
		
		<div class="margin-top first">
				<h3 class="hidden">고객문의 내용</h3>
				<table class="table">
					<tbody>
						<tr>
							<th>제목</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">${n.title}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td class="text-align-left text-indent" colspan="3"><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regDate}"/>	</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${n.writer}</td>
							<th>조회수</th>
							<td>${n.hit}</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3"><c:forEach var="f" items="${files}"
									varStatus="s">
									<a href="../download?f=${f.src}">${f.src}</a>
									<c:if test="${!s.last}">,</c:if>
								</c:forEach></td>
						</tr>
						<tr class="content">
							<td colspan="4"><c:forEach var="f" items="${files}"
									varStatus="s">
									<img src="upload/${f.src}" />
								</c:forEach> ${n.content}<br />adf<br />dddd</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="margin-top text-align-center">
				<a class="btn btn-list" href="../question">목록</a>
			</div>
			
			<div class="margin-top">
				<table class="table border-top-default">
					<tbody>
						<c:if test="${empty prev}">
						<tr>
							<th>이전글</th>
							<td colspan="3" class="text-align-left text-indent">이전글이 없습니다.</td>
						</tr>
						</c:if>
						<c:if test="${not empty prev}">
						<tr>
							<th>이전글</th>
							<td colspan="3"  class="text-align-left text-indent"><a class="text-blue text-strong" href="${prev.id}">${prev.title}</a></td>
						</tr>
						</c:if>
						<c:if test="${empty next}">
						<tr>
							<th>다음글</th>
							<td colspan="3"  class="text-align-left text-indent">다음글이 없습니다.</td>
						</tr>
						</c:if>
						<c:if test="${not empty next}">
						<tr>
							<th>다음글</th>
							<td colspan="3"  class="text-align-left text-indent"><a class="text-blue text-strong" href="${prev.id}">${next.title}</a></td>
						</tr>
						</c:if>
					</tbody>
				</table>
			</div>			
			
	</main>