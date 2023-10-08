<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />

		<div id="wrapper">
			<div id="content">
				<div class="blog-content">

					<h4>${blogMap.postMap[0].postTitle} </h4>
					<p>
						${blogMap.postMap[0].postContents }
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach var="post" items="${blogMap.postMap}">
						<li>
							<a href="${pageContext.request.contextPath}/${blogVo.blogId}/${blogVo.categoryNo}/${post.postNo}" >${post.postTitle}</a>
							<span style="float: right;">
							<fmt:parseDate value="${post.postRegDate}" var="parsedDate" pattern="yyyy-MM-dd" />
							<fmt:formatDate value="${parsedDate}" pattern="yyyy/MM/dd" />
							</span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
<%--				<img src="${pageContext.request.contextPath}/assets/images/zzalang2.jpg" style="width: 100%; margin-top: 20px;">--%>
					<img src="${pageContext.request.contextPath}${blogMap['mainMap'].blogImage }" style="width: 100%; margin-top: 20px;">

			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach var="category" items="${blogMap.categoryMap}">
					<li>
						<a href="${pageContext.request.contextPath}/${blogVo.blogId}/${category.categoryNo}">
								${category.categoryName}</a>
					</li>
				</c:forEach>
			</ul>
		</div>

		<c:import url="/WEB-INF/views/includes/footer.jsp" />

	</div>
</body>
</html>