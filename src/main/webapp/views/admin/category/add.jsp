<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-lg-6" style="margin: 0 auto;">
			<h3 class="p-3 text-center">Add Category</h3>
			<form:form action="insertCategory" method="POST" modelAttribute="category">
				<div class="form-group">
					<label><strong>Category Name</strong></label>
					<form:input type="text" path="categoryName" class="form-control mt-2" />
					<form:errors cssClass="text-danger font-weight-bold" path="categoryName"></form:errors>
				</div>
				<div class="form-group mt-3 mb-3">
					<label><strong>Category Status</strong></label>
					<div>
						<div class="form-check form-check-inline">
							<form:radiobutton class="form-check-input mt-2" path="categoryStatus" value="1" checked="checked"/>
							<label class="form-check-label">Active</label>
						</div>
						<div class="form-check form-check-inline">
							<form:radiobutton class="form-check-input mt-2" path="categoryStatus" value="0" />
							<label class="form-check-label">Hidden</label>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Add</button>
			</form:form>
		</div>
	</div>
</body>
</html>