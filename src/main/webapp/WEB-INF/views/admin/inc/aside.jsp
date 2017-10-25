<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
         <aside class="aside">
            <h1>ADMIN PAGE</h1>

            <nav class="menu text-menu first margin-top">
               <h1>마이페이지</h1>
               <ul>
                  <li><a href="${ctx}/admin/index">관리자홈</a></li>                  
                  <li><a href="${ctx}/teacher/index">선생님페이지</a></li>
                  <li><a href="${ctx}/student/index">수강생페이지</a></li>
               </ul>
            </nav>
                     

            <nav class="menu text-menu">
               <h1>회원관리</h1>
               <ul>
                  <li><a href="${ctx}/admin/member/all">가입회원</a></li>
                  <li><a href="${ctx}/admin/member/role">역할그룹</a></li>
                  <li><a href="${ctx}/admin/member/admin">관리자</a></li>
                  <li><a href="${ctx}/admin/member/teacher">선생님</a></li>
                  <li><a href="${ctx}/admin/member/seller">판매담당자</a></li>
               </ul>
            </nav>
            
            <nav class="menu text-menu">
               <h1>공지관리</h1>
               <ul>
                  <li><a href="">메인슬라이드</a></li>
                  <li><a href="">공지사항</a></li>
                  <li><a href="">팝업공지</a></li>                  
               </ul>
            </nav>
            
            

            
         </aside>