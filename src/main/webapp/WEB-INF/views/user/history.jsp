<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<c:if test="${not empty message}">
    <script>
        window.addEventListener("load", function () {
            alert("${message}");
        });
    </script>
</c:if>
<!-- Topbar Start -->
<div class="container-fluid">
    <div class="row bg-secondary py-2 px-xl-5">
        <div class="col-lg-6 d-none d-lg-block">
            <div class="d-inline-flex align-items-center">
                <a class="text-dark" href="">FAQs</a>
                <span class="text-muted px-2">|</span>
                <a class="text-dark" href="">Help</a>
                <span class="text-muted px-2">|</span>
                <a class="text-dark" href="">Support</a>
            </div>
        </div>
        <div class="col-lg-6 text-center text-lg-right">
            <div class="d-inline-flex align-items-center">
                <a class="text-dark px-2" href="">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-twitter"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-instagram"></i>
                </a>
                <a class="text-dark pl-2" href="">
                    <i class="fab fa-youtube"></i>
                </a>
            </div>
        </div>
    </div>
    <div class="row align-items-center py-3 px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a href="" class="text-decoration-none">
                <h1 class="m-0 display-6 font-weight-semi-bold"><span
                        class="text-primary font-weight-bold border px-3 mr-1">S</span>SkinStore</h1>
            </a>
        </div>
        <div class="col-lg-6 col-6 text-left">
            <form action="">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for products">
                    <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-3 col-6 text-right">
            <a href="" class="btn border">
                <i class="fas fa-heart text-primary"></i>
                <span class="number">0</span>
            </a>
            <a href="/user/cart" class="btn border">
                <i class="fas fa-shopping-cart text-primary"></i>
                <span class="number">${countCart}</span>
            </a>
        </div>
    </div>
</div>
<!-- Topbar End -->


<!-- Navbar Start -->
<div class="container-fluid">
    <div class="row border-top px-xl-5">
        <div class="col-lg-12">
            <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                <a href="" class="text-decoration-none d-block d-lg-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span
                            class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mr-auto py-0">
                        <a href="/user/home" class="nav-item nav-link">Shop</a>
                        <a href="/user/cart" class="nav-item nav-link">Shopping Cart</a>
                        <a href="/user/history" class="nav-item nav-link">History</a>
                    </div>
                    <div class="navbar-nav ml-auto py-0">
                        <a href="/login" class="nav-item nav-link">Login</a>
                        <a href="/register" class="nav-item nav-link">Register</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<!-- Navbar End -->

<!-- Cart Start -->
<div class="container-fluid pt-3">
    <div class="row px-xl-5">
        <div class="col-lg-12 table-responsive mb-5">
            <table class="table table-bordered text-center" id="dataTable" width="100%" cellspacing="0">
                <thead class="bg-secondary text-dark">
                <tr>
                    <th>Ma HD</th>
                    <th>Ngay dat</th>
                    <th>Ngay thanh toan</th>
                    <th>Ngay ship</th>
                    <th>Ngay nhan</th>
                    <th>Khach hang</th>
                    <th>SDT</th>
                    <th>Trang thai</th>
                    <th>Chuc nang</th>
                </tr>
                </thead>
                <tbody class="align-middle">
                <c:forEach items="${data.content}" var="order" varStatus="stt">
                    <tr>
                        <td class="align-middle">${order.ma}</td>
                        <td class="align-middle">${order.ngayTao}</td>
                        <td class="align-middle">${order.ngayThanhToan}</td>
                        <td class="align-middle">${order.ngayShip}</td>
                        <td class="align-middle">${order.ngayNhan}</td>
                        <td class="align-middle">${order.nguoiNhan}</td>
                        <td class="align-middle">${order.sdt}</td>
                        </td>
                        <td class="align-middle">
                            <c:if test="${order.trangThai == 1}">
                                <p class="bg-dark text-white p-2">Cho xac nhan</p>
                            </c:if>
                            <c:if test="${order.trangThai == 2}">
                                <p class="bg-success text-white p-2">Xac nhan thanh toan</p>
                            </c:if>
                            <c:if test="${order.trangThai == 3}">
                                <p class="bg-success text-white p-2">Dang giao hang</p>
                            </c:if>
                            <c:if test="${order.trangThai == 4}">
                                <p class="bg-success text-white p-2">Da nhan duoc hang</p>
                            </c:if>
                            <c:if test="${order.trangThai == 0}">
                                <p class="bg-danger text-white p-2">Da huy</p>
                            </c:if>
                        </td>
                        <td>
                            <div class="text-center">
                                <a href="/user/history/detail/${order.id}" class="btn btn-warning">Xem chi tiet</a>
                                <c:if test="${order.trangThai == 1}">
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#modalUpdate_${order.id}">
                                        Huy don hang
                                    </button>
                                </c:if>
                                <c:if test="${order.trangThai == 3}">
                                    <a href="/user/history/status-4/${order.id}"
                                       type="button" class="btn btn-info">Da nhan duoc hang</a>
                                </c:if>
                                <div class="modal fade" id="modalUpdate_${order.id}"
                                     data-bs-backdrop="static" data-bs-keyboard="false"
                                     tabindex="-1" aria-labelledby="staticBackdropLabel"
                                     aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header bg-danger">
                                                <h5 class="modal-title text-white"
                                                    id="staticBackdropLabel">Xac nhan huy don hang?</h5>
                                                <button type="button" class="btn"
                                                        data-bs-dismiss="modal" aria-label="Close">
                                                    <i class="fa-solid fa-xmark fs-5 text-white"></i>
                                                </button>
                                            </div>
                                            <div class="modal-footer">
                                                <a href="/user/history/status/${order.id}"
                                                   type="button" class="btn btn-info">OK</a>
                                                <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Cancel
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="row mt-5" style="margin-left: 320px">
    <ul class="pagination justify-content-center">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <c:forEach var="index" begin="0" end="${ data.totalPages - 1 }">
            <li class="page-item mx-1"><a
                    class="page-link ${ index==page?'bg-info text-white':'' }"
                    href="/user/history?page=${ index }">${ index + 1 }</a></li>
        </c:forEach>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</div>
<!-- Cart End -->

<!-- Footer Start -->
<div class="container-fluid bg-secondary text-dark mt-5 pt-5">
    <div class="row px-xl-5 pt-5">
        <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
            <a href="" class="text-decoration-none">
                <h1 class="mb-4 display-5 font-weight-semi-bold"><span
                        class="text-primary font-weight-bold border border-white px-3 mr-1">S</span>SkinStore</h1>
            </a>
            <p>Healthy skin starts with a commitment to a regular skin care regimen, using high quality skin care and
                facial products every day. While we often think of the face first when it comes to caring for the skin,
                the skin on the body also needs attention.</p>
            <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Trinh Van Bo, Ha Noi, VietNam</p>
            <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>info@example.com</p>
            <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+0123 456 789</p>
        </div>
        <div class="col-lg-8 col-md-12">
            <div class="row">
                <div class="col-md-4 mb-5">
                    <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-dark mb-2" href="home.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                        <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                        <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop
                            Detail</a>
                        <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping
                            Cart</a>
                        <a class="text-dark mb-2" href="checkout.html"><i
                                class="fa fa-angle-right mr-2"></i>Checkout</a>
                        <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-dark mb-2" href="home.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                        <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                        <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop
                            Detail</a>
                        <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping
                            Cart</a>
                        <a class="text-dark mb-2" href="checkout.html"><i
                                class="fa fa-angle-right mr-2"></i>Checkout</a>
                        <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <h5 class="font-weight-bold text-dark mb-4">Newsletter</h5>
                    <form action="">
                        <div class="form-group">
                            <input type="text" class="form-control border-0 py-4" placeholder="Your Name"
                                   required="required"/>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control border-0 py-4" placeholder="Email"
                                   required="required"/>
                        </div>
                        <div>
                            <button class="btn btn-primary btn-block border-0 py-3" type="submit">Subscribe Now</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->


<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="/lib/easing/easing.min.js"></script>
<script src="/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Template Javascript -->
<script src="/js/main.js"></script>
</body>

</html>