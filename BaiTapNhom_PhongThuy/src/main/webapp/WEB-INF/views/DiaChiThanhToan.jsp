<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Friends</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/8.11.8/sweetalert2.all.js"></script>
<link rel="stylesheet" href="">
<style>
body {
	background: #f2f2f2 !important;
	font-size: 14px !important;
	color: #707070 !important;
}

.hide {
	display: none;
}

.show {
	display: block;
}

.data-list {
	max-height: 300px;
	background: #f5f5f5;
	padding: 10px;
	border-radius: 5px !important;
	overflow-y: scroll;
}

ul {
	list-style-type: none;
	display: inline-block;
	padding: 0px;
}

.edit {
	font-size: 15px;
	color: blue;
}
.container{
	margin-top:40px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">ĐỊA CHỈ THANH TOÁN</h1>
		<div class="row shadow-lg p-3 mb-5 bg-white rounded" style="">
			<div class="col-md-6">
				<h6 class="text-center">THÔNG TIN TÀI KHOẢN</h6>
				<div class="form-group">
					<label for="ho"><h6>HỌ</h6> </label> <input type="text"
						id="ho" placeholder="" class="form-control" value="${nguoi.ho}" disabled="disabled">
				</div>

				<div class="form-group">
					<label for="ten"><h6>TÊN</h6></label> <input type="text"
						id="ten" placeholder="" class="form-control" value="${nguoi.ten}" disabled="disabled">
				</div>

				<div class="form-group">
					<label for=email><h6>EMAIL</h6></label> <input type="text" disabled="disabled"
						id="email" placeholder="" class="form-control" value="${nguoi.email}">
				</div>

				<div class="form-group">
					<label for="sdt"><h6>SỐ ĐIỆN THOẠI</h6></label> <input type="text" disabled="disabled"
						id="sdt" placeholder="" class="form-control" value="${nguoi.sdt}"> 
				</div>
				<button id="getL" type="button"
					class="btn btn-success col-md-12 hide" >GET
					LIST FRIENDS</button>

			</div>
			<div class="col-md-6">

				<h6 class="text-center">ĐỊA CHỈ THANH TOÁN</h6>
				<div class="data-list"></div>
				<p id="total" class="text-center"></p>

				<button id="btn_down" type="button"
					class="btn btn-success col-md-12">Download</button>

			</div>


		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>