<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	rel="stylesheet">
</head>
<body>
<body>
	<div class="container">
		<div class="text-center">
			<div>
				<p class="m-1">Welcome:</p>
				<h2>${pageContext.request.userPrincipal.name}</h2>
			</div>
			<form action="<c:url value="/j_spring_security_logout" />"
				method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<button type="submit" class="btn btn-danger">
					<i class="fa-solid fa-right-from-bracket"></i>
				</button>
			</form>
			<hr>
			<a href="admin/category"
				class="text-dark fw-bold text-decoration-none">Category</a> | <a
				href="admin/product" class="text-dark fw-bold text-decoration-none">Product</a>
			<hr>
			<c:if test="">
				
			</c:if>
			<c:choose>
				<c:when test="${!(empty param.f)}">
					<jsp:include page="admin/${param.f}.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
					<h5>thống kê sô liệu</h5>
				</c:otherwise>
			</c:choose>
		</div>


	</div>
</body>
</body>

</html>