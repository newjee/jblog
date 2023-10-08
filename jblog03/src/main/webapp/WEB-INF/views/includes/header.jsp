<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
  <h1 style="text-align: center;">
    <a href="${pageContext.request.contextPath}/${blogVo.blogId}" style="color: #F0F0F0;">${blogVo.blogTitle}</a>
  </h1>
  <ul>
    <li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
    <li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
<%--    비로그인상태 처리--%>
    <li><a href="${pageContext.request.contextPath}/${blogVo.blogId}/admin/basic">블로그 관리</a></li>
  </ul>
</div>