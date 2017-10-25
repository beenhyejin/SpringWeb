<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
	
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
		
		<form method="post">
		<div class="margin-top first">
				<h3 class="hidden">고객문의 내용</h3>
				<table class="table">
					<tbody>
						<tr>
							<th>제목</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">
								<input name="title" type="text" />
							</td>
						</tr>
						<tr>
							<th>구분</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">
								<select name="category">
									<option>수강신청</option>
									<option>동영상</option>
								</select>
							</td>
						</tr>
						<!-- <tr>
							<th>첨부파일</th>
							<td></td>
						</tr> -->
						<tr class="content">
							<td colspan="4" class="stretch-child">
								<textarea name="content" class="notepubs note"></textarea>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			
			<div class="margin-top text-align-center">
				<input type="submit" class="btn btn-write" value="등록" />
				<a class="btn btn-cancel" href="../question">취소</a>
			</div>
			</form>
						
	</main>
	<script src="/JSPNewlecture/resource/js/lib/notepubs/web-editor/note-editor/editor.js"></script>
	<script>
	var editor = new Editor("${ctx}/resource/js/lib/notepubs/web-editor/note-editor/", ".btn-write");
		
	</script>	