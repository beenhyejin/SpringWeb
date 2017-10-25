<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>등록 페이지</h1>
	<form action="notice-reg" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>공지사항 수정정보 필드</legend>
			<table border="1">
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" value="${n.title}" /></td>
					</tr>					
					<tr>
						<td>첨부파일</td>
						<td><input type="file" name="file" /></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input type="file" name="file" /></td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="content" rows="20" cols="60">${n.content}</textarea>

						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<input type="submit" value="등록" />
				<a href="notice">취소</a>				
			</div>
		</fieldset>
	</form>
</body>
</html>





