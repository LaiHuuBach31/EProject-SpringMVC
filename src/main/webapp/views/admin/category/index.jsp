<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Category</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-lg-6" style="margin: 0 auto;">
			<h3 class="p-3 text-center">List Category</h3>
			<a href="category/addCategory" class="btn btn-success mb-3">Add
				new</a>
			<form class="row g-3" method="get">
				<div class="col-auto">
					<input type="text" class="form-control" name="keyWord">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-warning mb-3">
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</div>
			</form>
			<c:if test="${!empty success}">
				<div class="alert alert-primary" role="alert">
					<strong>${success}</strong>
				</div>
			</c:if>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">INDEX</th>
						<th scope="col">CATEGORY NAME</th>
						<th scope="col">CATEGORY STATUS</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="cate" varStatus="loop">
						<tr>
							<td scope="row">${loop.count}</td>
							<td>${cate.categoryName}</td>
							<td>${cate.categoryStatus ? 'Active' :'Hiden'}</td>
							<td style="text-align: right;"><a
								href="category/editCategory/${cate.categoryId}"
								class="btn btn-primary"><i class="fa-solid fa-pen-to-square"></i></a>
								<a href="category/deleteCategory/${cate.categoryId}"
								class="btn btn-danger"><i class="fa-solid fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${count > 5}">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<c:choose>
							<c:when test="${empty param.keyWord}">
								<c:forEach begin="1" end="${totalPage}" var="t">
									<li class="page-item"><a class="page-link"
										href="?pageNo=${t}">${t}</a></li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach begin="1" end="${totalPage}" var="t">
									<li class="page-item"><a class="page-link"
										href="?keyWord=${param.keyWord}&pageNo=${t}">${t}</a></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</c:if>
		</div>
	</div>
</body>
</html>