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
	<div class="container">
		<div class="col-lg-4" style="margin: 0 auto;">
			<h1 class="text-center">Login</h1>
			<span style="color: red">${error}</span>
			<form action="<c:url value='j_spring_security_login' />"
				method="post">
				<div class="mb-3">
					<label class="form-label"><strong>UserName</strong></label> <input
						type="text" class="form-control" name="userName">
				</div>
				<div class="mb-3">
					<label class="form-label"><strong>Password</strong></label> <input
						type="password" class="form-control" name="password">
				</div>
				<div class="mb-3">
					<button type="submit" class="btn btn-primary mb-3">Login</button>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
	</div>
</body>
</html>