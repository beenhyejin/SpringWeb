<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<h2>수정 페이지</h2>
	<form action="notice-edit" method="post">
		<fieldset>
			<legend>공지사항 수정정보 필드</legend>
			<table border="1">
				<tbody>
					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text" name="title" value="${n.title}" /></td>
					</tr>
					<tr>
						<td>작성일</td>
						<td colspan="3">${n.regDate}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${n.writer}</td>
						<td>조회수</td>
						<td>${n.hit}</td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td colspan="3">
						<c:forEach var="f" items="${files}">
							<span>${f.src}</span>
							<a href="notice-file-del?code=${f.code}&ncode=${n.code}">[X]</a>
						</c:forEach>
						</td>
					</tr>
					<tr>
						<td colspan="4"><textarea name="content" rows="20" cols="60">${n.content}</textarea>

						</td>
					</tr>
				</tbody>
			</table>
			<div>				
				<input type="hidden" name="code" value="${n.code}" />
				<input type="submit" value="저장" />
				<a href="notice-detail?code=${n.code}">취소</a>				
			</div>
		</fieldset>
	</form>





