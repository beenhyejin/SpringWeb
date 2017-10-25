<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<main class="main" ng-controller="notice-controller">
			<h2 class="main title">공지사항</h2>
			
			<div class="breadcrumb">
				<h3 class="hidden">경로</h3>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ul>
			</div>
			
			<div class="search-form margin-top first align-right">
				<h3 class="hidden">공지사항 검색폼</h3>
				<form class="table-form">
					<fieldset>
						<legend class="hidden">공지사항 검색 필드</legend>
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
				<h3 class="hidden">공지사항 목록</h3>
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
						<td class="title indent"><a href="notice/${n.id}">${n.title}</a></td>
						<td>newlec</td>
						<td>
							${n.regDate }
							<!-- <fmt:formatDate pattern="yyyy-MM-dd" value="2017-02-28"/>	 -->	
						</td>
						<td>12</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="indexer margin-top align-right">
				<h3 class="hidden">현재 페이지</h3>
				<div><span class="text-orange text-strong">1</span> / 3 pages</div>
			</div>
			
			<div>
				<a href = "notice/reg">등록하기</a>
			</div>

			<div class="margin-top align-center pager">
				<new:pager />
			</div>
		</main>
		