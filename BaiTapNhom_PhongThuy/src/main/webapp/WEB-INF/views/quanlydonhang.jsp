<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>INFO</title>
<!-- Fontawesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<!--Bootstrap 4.3.1-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!--CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/contact.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/general.css">


</head>

<body>
	<jsp:include page="menu.jsp" />
	<br />
	<br />
	<br />
	<br />
	<section class="cartorder">
		<div class="container">
			<h1 style="text-align: center; color: green">Đơn hàng của bạn</h1>
			<div class="row" id="tt">
				<div class="col-md-3">
					<ul id="ulcart">
						<li><img width="80%" height="80%"
							src="http://via.placeholder.com/550x550/ffb366/ffffff?text=${nguoi.ho} ${nguoi.ten}"
							style="border-radius: 100%" id="hinhavatar2" />
							<div class="h4">${nguoi.ho}${nguoi.ten}</div> <br></li>
						<li><img
							src="https://img.icons8.com/ios/30/000000/guest-male.png" /> <a
							href="${pageContext.request.contextPath}/thongtincanhan">Thông tin cá nhân</a></li>
						<br>
						<li><img
							src="https://img.icons8.com/ios/30/000000/purchase-order.png" />
							<a href="${pageContext.request.contextPath}/quanlydonhang">Quản
								lý đơn hàng</a></li>
						<br>
						<li><img
							src="https://img.icons8.com/ios/30/000000/export.png" /> <a
							href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
					</ul>
				</div>
				
				<div class="col-md-9">

					<div class="inner">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Mã đơn hàng</th>
									<th>Ngày mua</th>
									<th>Sản phẩm</th>
									<th>Tổng tiền</th>
									<th>Trạng thái đơn hàng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="listSP" items="${nguoi.listhoadon}">
									<tr>
										<td><a href="/sales/order/view/450100533">${listSP.mahd}</a></td>
										<td>${listSP.ngaylap}</td>
										<td>
										<c:forEach var="cthd" items="${listSP.listcthd}">
												
													<ul>
														<li>${cthd.sanpham.tensp}</li>
														
													</ul>
												
										</c:forEach>
										</td>
										<td>
											<c:forEach var="cthd" items="${listSP.listcthd}">
												
													<ul>
														<li><fmt:formatNumber type="number" pattern="###,###"
												value="${cthd.soluong * cthd.dongia}" /> đ</li>
														
													</ul>
												
										</c:forEach>
										</td>
										<td>Giao hàng thành công</td>
									</tr>

								</c:forEach>


							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</section>
	<br>
	<jsp:include page="footer.jsp" />
	<!--JQuery for Bootstrap-->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/diachi.js"></script>

</body>

</html>