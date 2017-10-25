<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<main class="main" ng-controller="notice-controller">
			<h2 class="main title">고객문의</h2>
			
			<div class="breadcrumb">
				<h3 class="hidden">경로</h3>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>고객문의</li>
				</ul>
			</div>
			
			<div class="search-form margin-top first align-right">
				<h3 class="hidden">고객문의  검색폼</h3>
				<form class="table-form">
					<fieldset>
						<legend class="hidden">고개문의 검색 필드</legend>
						<label class="hidden">검색분류</label> 
						<select name="t">
							<option selected="selected" value="TITLE">제목</option>
							<option value="WRITER">작성자</option>
						</select> 
						<label class="hidden">검색어</label> 
						<input type="text" name="q" /> 
						<input class="btn btn-search" type="submit" value="검색" />
					</fieldset>
				</form>
			</div>
						
			<div class="notice margin-top">
				<h3 class="hidden">고객문의 목록</h3>
				<table class="table">
					<thead>
						<tr>
							<th class="w60">번호</th>
							<th class="expand">제목</th>
							<th class="w100">작성자</th>
							<th class="w100">작성일</th>
							<th class="w60">조회수</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="n" items="${list}">
					<tr>
						<td>${n.id}</td>
						<td class="title indent"><a href="question/${n.id}">JSP란 무엇인가JSP란 무엇인가JSP란 무엇인가JSP란 무엇인가JSP란 무엇인가JSP란 무엇인가JSP란 무엇인가JSP란 무엇인가JSP란 무엇인가JSP란 무엇인가</a></td>
						<td>newlec</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd" value="2017-02-28"/>		
						</td>
						<td>12</td>
					</tr>
					<tr>
						<td></td>
						<td colspan="4" class="title indent text-align-left"><a href="question/${n.id}/answer"  class="re text-strong text-orange">답변이</a></td>						
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="indexer margin-top align-right">
				<h3 class="hidden">현재 페이지</h3>
				<div><span class="text-orange text-strong">1</span> / 3 pages</div>
			</div>
			
			<div class="margin-top text-align-right">
				<a href="question/reg" class="btn btn-ask">문의하기</a>
			</div>

			<div class="margin-top align-center pager">
				<new:pager />
			</div>
		</main>
		