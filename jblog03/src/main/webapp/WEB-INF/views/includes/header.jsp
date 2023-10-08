<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
  <h1 style="text-align: center;">
    <a href="${pageContext.request.contextPath}/${blogVo.blogId}" style="color: #F0F0F0;">${blogVo.blogTitle}</a>
  </h1>


  <ul>
    <c:choose>

    <c:when test="${empty authUser}">
      <!-- 비로그인 상태일 때 표시할 내용 -->
      <li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
    </c:when>
    <c:otherwise>
      <!-- 로그인 상태일 때 표시할 내용 -->
      <li><a href="${pageContext.request.contextPath}/${blogVo.blogId}/admin/basic">블로그 관리</a></li>
      <li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
      <li><a href="${pageContext.request.contextPath}/${authUser.id}">내블로그</a></li>
    </c:otherwise>
    </c:choose>
  </ul>
</div>