<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Store</title>
    <!-- Fontawesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <!--Bootstrap 4.3.1-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!--CSS-->
    
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/contact.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
	<script src="/js/product.js"> </script>


</head>

<body>
    
    <jsp:include page="menu.jsp" />
    
    
    <section class="banner">
        <div id="carouselId" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselId" data-slide-to="0" class="active"></li>
                <li data-target="#carouselId" data-slide-to="1"></li>
                <li data-target="#carouselId" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/www/banner_1.jpg" alt="First slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Golden</h3>
                        <p>SHOP NOW</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/www/banner_2.jpg" alt="Second slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Golden</h3>
                        <p>SHOP NOW</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/www/banner_3.jpg" alt="Third slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Golden</h3>
                        <p>SHOP NOW</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselId" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselId" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </section>
    <section class="categories margin-t-50 margin-b-50">
        <div class="container">
            <h1 style="text-align:center;color:green">All Feng Shui</h1><br><br>
			 <h4 style="text-align:left;color:gray">Search by:</h4>
			<div class="row" id="products" >
				<div class="col-md-12" id="timLoai">
			 
				<div class="card">
					<ul class="nav justify-content-start">
					  <li class="nav-item">
						<a class="nav-link disabled" href="#" style="margin-right:10px">Loai San Pham:</a>
					  </li>
					  <li class="nav-item">
						<a class="nav-link" href="#">Normal</a>
					  </li>
					  <li class="nav-item">
						<a class="nav-link" href="#">VIP</a>
					  </li>
					  
						</ul>
					</div>
				</div>
				<div class="col-md-12" id="timNCC">
			 
				<div class="card">
					<ul class="nav justify-content-start">
					  <li class="nav-item">
						<a class="nav-link disabled" href="#" style="margin-right:10px">Nha cung cap:</a>
					  </li>
					  <li class="nav-item">
						<a class="nav-link" href="#">Ngoc Vang IC</a>
					  </li>
					  <li class="nav-item">
						<a class="nav-link" href="#">Golden Feng</a>
					  </li>
					  
						</ul>
					</div>
				</div>
				<div class="col-md-12" id="timNuocSX">
			 
				<div class="card">
					<ul class="nav justify-content-start">
					  <li class="nav-item">
						<a class="nav-link disabled" href="#" style="margin-right:10px">Nuoc san xuat:</a>
					  </li>
					  <li class="nav-item">
						<a class="nav-link" href="#">Viet Nam</a>
					  </li>
					  <li class="nav-item">
						<a class="nav-link" href="#">Trung Quoc</a>
					  </li>
					  
						</ul>
					</div>
				</div>
			</div>
            <h3 style="text-align:left;color:gray">Feng Shui Normal</h3>
			
			
			
            <div class="row" id="products1">
			
                <div class="col-md-3" id="product1">
                    <div class="card">
                        <img class="card-img-top img-src" src="www/(39).jpg" style="width:80%" />
                        <hr>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="card-title productName">Gay Ngoc Nhu Y
                                    </h5>
                                </div>
                                <div class="col-md-2">
                                    <i class="far fa-heart"></i>
                                </div>
                            </div>

                            <p class="card-text productPrice">1,999,000 VND</p>
                        </div>
                    </div>

                </div>
                <div class="col-md-3" id="product2">
                    <div class="card">
                        <img class="card-img-top img-src" src="www/(49).jpg" style="width:80%" />
                        <hr>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="card-title productName">Phat Di Lac
                                    </h5>
                                </div>
                                <div class="col-md-2">
                                    <i class="far fa-heart"></i>
                                </div>
                            </div>

                            <p class="card-text productPrice">1,700,000 VND</p>
                        </div>
                    </div>

                </div>
                <div class="col-md-3" id="product3">
                    <div class="card">
                        <img class="card-img-top img-src" src="www/(44).jpg" style="width:80%" />
                        <hr>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="card-title productName">Ngua Phong Thuy
                                    </h5>
                                </div>
                                <div class="col-md-2">
                                    <i class="far fa-heart"></i>
                                </div>
                            </div>

                            <p class="card-text productPrice">1,490,000 VND</p>
                        </div>
                    </div>

                </div>
                <div class="col-md-3" id="product4">
                    <div class="card">
                        <img class="card-img-top img-src" src="www/(73).jpg" style="width:80%" />
                        <hr>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="card-title productName">Coc Ngam Tien
                                    </h5>
                                </div>
                                <div class="col-md-2">
                                    <i class="far fa-heart"></i>
                                </div>
                            </div>

                            <p class="card-text productPrice">2,199,000 VND</p>
                        </div>
                    </div>

                </div>
            </div>
			<h3 style="text-align:left;color:gray">Feng Shui VIP</h3>
			<div class="row" id="products2">
                <div class="col-md-3" id="product5">
                    <div class="card">
                        <img class="card-img-top img-src" src="www/(61).jpg" style="width:80%" />
                        <hr>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="card-title productName">Phat Di Lac Vang
                                    </h5>
                                </div>
                                <div class="col-md-2">
                                    <i class="far fa-heart"></i>
                                </div>
                            </div>

                            <p class="card-text productPrice">1,999,000 VND</p>
                        </div>
                    </div>

                </div>
                <div class="col-md-3" id="product6">
                    <div class="card">
                        <img class="card-img-top img-src" src="www/(47).jpg" style="width:80%" />
                        <hr>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="card-title productName">Dragon Golden Feng Shui
                                    </h5>
                                </div>
                                <div class="col-md-2">
                                    <i class="far fa-heart"></i>
                                </div>
                            </div>

                            <p class="card-text productPrice">1,700,000 VND</p>
                        </div>
                    </div>

                </div>
                <div class="col-md-3" id="product7">
                    <div class="card">
                        <img class="card-img-top img-src" src="www/(74).jpg" style="width:80%" />
                        <hr>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="card-title productName">Coc Ngam Tien Vang
                                    </h5>
                                </div>
                                <div class="col-md-2">
                                    <i class="far fa-heart"></i>
                                </div>
                            </div>

                            <p class="card-text productPrice">1,490,000 VND</p>
                        </div>
                    </div>

                </div>
                <div class="col-md-3" id="product8">
                    <div class="card">
                        <img class="card-img-top img-src" src="www/(50).jpg" style="width:80%" />
                        <hr>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="card-title productName">Ba Thoi Vang
                                    </h5>
                                </div>
                                <div class="col-md-2">
                                    <i class="far fa-heart"></i>
                                </div>
                            </div>

                            <p class="card-text productPrice">2,199,000 VND</p>
                        </div>
                    </div>

                </div>
            </div>
		</div>
			
	</section>
	
	<jsp:include page="footer.jsp" />
	
    <!--JQuery for Bootstrap-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
	<script src="js/product.js"></script>
</body>

</html>