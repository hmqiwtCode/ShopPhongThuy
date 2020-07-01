<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Địa chỉ thanh toán</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/8.11.8/sweetalert2.all.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/thanhphan.css">
</head>
<body>
	<div class="container">
		<div class="row shadow-lg p-3 mb-2 bg-white rounded">
			<div class="col-md-12">
				<h5 class="text-center">HÌNH THỨC THANH TOÁN</h5>
			</div>
		</div>
		<div class="row shadow-lg p-3 mb-5 bg-white rounded" style="">
			<%-- <div class="col-md-6">
				<h6 class="text-center">THÔNG TIN TÀI KHOẢN</h6>
				<div class="form-group">
					<label for="ho"><h6>HỌ</h6> </label> <input type="text" id="ho"
						placeholder="" class="form-control" value="${nguoi.ho}"
						disabled="disabled">
				</div>

				<div class="form-group">
					<label for="ten"><h6>TÊN</h6></label> <input type="text" id="ten"
						placeholder="" class="form-control" value="${nguoi.ten}"
						disabled="disabled">
				</div>

				<div class="form-group">
					<label for=email><h6>EMAIL</h6></label> <input type="text"
						disabled="disabled" id="email" placeholder="" class="form-control"
						value="${nguoi.email}">
				</div>

				<div class="form-group">
					<label for="sdt"><h6>SỐ ĐIỆN THOẠI</h6></label> <input type="text"
						disabled="disabled" id="sdt" placeholder="" class="form-control"
						value="${nguoi.sdt}">
				</div>
				<button id="getL" type="button"
					class="btn btn-success col-md-12 hide">GET LIST FRIENDS</button>

			</div> --%>


			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h6>Hình thức thanh toán</h6>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">
							<p>Giao hàng trực tiếp</p>
							<p class="text-success">
								Ước tính ngày giao: <strong>${date}</strong>
							</p> <c:forEach var="lsp" items="${listItemInCart}">
								<div class="card">
									<div class="card-header">
										<strong>Sản phẩm</strong>
									</div>
									<ul class="list-group list-group-flush">
										<li class="list-group-item">Số lượng : ${lsp.soLuong} *
											${lsp.tenSanPham} <img alt="" width="20%" height="20%"
											src="${pageContext.request.contextPath}/resources/imguploads/${lsp.urlHinh}">
										</li>
										<li class="list-group-item">Giao tiêu chuẩn : 5000đ</li>

									</ul>
								</div>
								<p></p>
							</c:forEach>
						</li>

					</ul>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h6>THÔNG TIN GIAO HÀNG</h6>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">
							<div class="card">
								<div class="card-header">Địa chỉ</div>
								<ul class="list-group list-group-flush">
									<li class="list-group-item">${nguoi.ho} ${nguoi.ten}</li>
									<li class="list-group-item">Dapibus ac facilisis in</li>
									<li class="list-group-item">Vestibulum at eros</li>
								</ul>
							</div>

						</li>

					</ul>
				</div>

			</div>







		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</body>
</html>