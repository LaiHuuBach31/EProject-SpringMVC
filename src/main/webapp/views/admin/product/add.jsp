<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-lg-8" style="margin: 0 auto;">
			<h3 class="p-3 text-center">Add Product</h3>
			<form:form action="insertProduct" method="POST"
				modelAttribute="product" enctype="multipart/form-data">
				<div class="row">
					<div class="col-lg-7">
						<div class="form-group">
							<label><strong>Product Name</strong></label>
							<form:input type="text" path="productName"
								class="form-control mt-2" />
							<form:errors cssClass="text-danger font-weight-bold"
								path="productName"></form:errors>
						</div>
						<div class="form-group">
							<label><strong>Description</strong></label>
							<form:textarea path="description" class="form-control mt-2"
								rows="10" />
							<form:errors cssClass="text-danger font-weight-bold"
								path="description"></form:errors>
						</div>
					</div>
					<div class="col-lg-5">
						<div class="form-group">
							<label><strong>Category</strong></label>
							<form:select path="category.categoryId" class="form-control mt-2">
								<c:forEach items="${listCategory}" var="c">
									<form:option value="${c.categoryId}">${c.categoryName}</form:option>
								</c:forEach>
							</form:select>
							<form:errors cssClass="text-danger font-weight-bold" path=""></form:errors>
						</div>
						<div class="form-group">
							<label><strong>Price</strong></label>
							<form:input type="text" path="price" class="form-control mt-2" />
							<form:errors cssClass="text-danger font-weight-bold" path="price"></form:errors>
						</div>
						<div class="form-group">
							<label><strong>Image</strong></label>
							<form:input type="file" path="image" class="form-control mt-2" />
							<form:errors cssClass="text-danger font-weight-bold" path="image"></form:errors>
						</div>
						<div class="form-group mt-3 mb-3">
							<label><strong>Product Status</strong></label>
							<div>
								<div class="form-check form-check-inline">
									<form:radiobutton class="form-check-input mt-2"
										path="productStatus" value="1" checked="checked" />
									<label class="form-check-label">Active</label>
								</div>
								<div class="form-check form-check-inline">
									<form:radiobutton class="form-check-input mt-2"
										path="productStatus" value="0" />
									<label class="form-check-label">Hidden</label>
								</div>
							</div>
						</div>		
					</div>
				</div>
				<button type="submit" class="btn btn-primary mt-3">Add</button>
			</form:form>
		</div>
	</div>
</body>
</html>