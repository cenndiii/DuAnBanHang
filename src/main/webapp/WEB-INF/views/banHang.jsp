<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .col-8, .col-4 {
            background-color: #b1bfbd;
            border-radius: 10px;
        }

    </style>
</head>
<body>
<div class="">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="/home/hien-thi">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="/thuoc-tinh/hien-thi">Thuoc tinh</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="/danh-muc/hien-thi">Danh muc</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/san-pham/hien-thi">San pham</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="/ctsp/hien-thi">Chi tiet san pham</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/khach-hang/hien-thi">Khach hang</a>
        </li>
        <li class="nav-item">
            <a class="nav-link "  href="/hdct/hien-thi">Hoa don chi tiet</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/ban-hang/hien-thi">Ban Hang</a>
        </li>
    </ul>
</div>
<div class=" row">
    <div class="col-8">
        <h2>${error}</h2>
        <div class="product p-1">
            <h3>San pham</h3>
            <table class="table table-hover">
                <thead>
                <th>San pham</th>
                <th>Mau sac</th>
                <th>Size</th>
                <th>Gia</th>
                <th>So luong ton</th>
                <th>Hanh dong</th>
                </thead>
                <tbody>
                <c:forEach items="${listCtsp}" var="ctsp">
                    <tr>
                        <td>${ctsp.sanPham.tenSanPham}</td>
                        <td>${ctsp.mauSac.tenMau}</td>
                        <td>${ctsp.size.tenSize}</td>
                        <td>${ctsp.giaBan}</td>
                        <td>${ctsp.soLuongTon}</td>
                        <td>

                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal${ctsp.id}">
                                Them
                            </button>
                            <form action="/ban-hang/getSoLuong" method="post">

                                <div class="modal fade" id="exampleModal${ctsp.id}" tabindex="-1"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Nhap so luong</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>

                                            <div class="modal-body">
                                                <input type="hidden" name="id" value="${ctsp.id}">
                                                <input type="text" class="form-control" name="soLuongMua">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                    Dong
                                                </button>
                                                <button type="submit" class="btn btn-primary">Xac nhan</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="cart p-1">
            <h3>Gio hang</h3>
            <table class="table table-hover">
                <thead>
                <th>San pham</th>
                <th>Mau sac</th>
                <th>Size</th>
                <th>Gia</th>
                <th>So luong mua</th>
                <th>Tong tien</th>
                <th>Hanh dong</th>
                </thead>
                <tbody>
                <c:forEach items="${listCart}" var="ctsp">
                    <tr>
                        <td>${ctsp.tenSanPham}</td>
                        <td>${ctsp.tenMau}</td>
                        <td>${ctsp.tenSize}</td>
                        <td>${ctsp.giaBan}</td>
                        <td>
                                ${ctsp.soLuong}
                        </td>
                        <td>${ctsp.soLuong * ctsp.giaBan}</td>
                        <td>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#suaSoLuong${ctsp.id}">
                                Sua so luong
                            </button>
                            <form action="/ban-hang/sua-sl" method="post">

                                <div class="modal fade" id="suaSoLuong${ctsp.id}" tabindex="-1"
                                     aria-labelledby="exampleModalLabel2" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="exampleModalLabel2">Nhap so luong</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>

                                            <div class="modal-body">
                                                <input type="hidden" name="id" value="${ctsp.id}">
                                                <input type="text" class="form-control" name="soLuongMua">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                    Dong
                                                </button>
                                                <button type="submit" class="btn btn-primary">Xac nhan</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <a href="/ban-hang/xoa-gioHang/${ctsp.id}" class="btn btn-danger">Xoa </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="bill col-4 p-1">
        <a href="/ban-hang/add-hoaDon" class="btn btn-success">Tao hoa don</a>
        <table class="table table-hover">
            <thead>
            <th>Id</th>
            <th>Ngay tao</th>
            <th>Trang thai</th>
            <th>Hanh dong</th>
            </thead>
            <tbody>
            <c:forEach items="${listHoaDon}" var="hoaDon">
                <tr>
                    <td>${hoaDon.id}</td>
                    <td>${hoaDon.ngayTao}</td>
                    <td>${hoaDon.trangThai}</td>
                    <td>
                        <a href="/ban-hang/chon-hd/${hoaDon.id}" class="btn btn-primary" >Chon</a>
<%--                        <form action="/ban-hang/thanh-toan" method="post">--%>

<%--                            <div class="modal fade" id="chonHoaDon${hoaDon.id}" tabindex="-1"--%>
<%--                                 aria-labelledby="exampleModalLabel1" aria-hidden="true">--%>
<%--                                <div class="modal-dialog">--%>
<%--                                    <div class="modal-content">--%>
<%--                                        <div class="modal-header">--%>
<%--                                            <h1 class="modal-title fs-5" id="exampleModalLabel1">Thong tin hoa don</h1>--%>
<%--                                            <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
<%--                                                    aria-label="Close"></button>--%>
<%--                                        </div>--%>

<%--                                        <div class="modal-body">--%>
<%--                                            <label for="" class="label-control">Id hoa don</label>--%>
<%--                                            <input type="text" name="id" value="${hoaDon.id}" class="form-control"--%>
<%--                                                   readonly>--%>
<%--                                            <label for="" class="label-control">Khach hang</label>--%>
<%--                                            <select name="khachHang">--%>
<%--                                                <option value="">Khong co</option>--%>
<%--                                                <c:forEach items="${listKhachHang}" var="kh">--%>
<%--                                                    <option value="${kh.id}">${kh.hoTen}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select><br>--%>
<%--                                            <label for="" class="label-control">Ngay tao</label>--%>
<%--                                            <input type="datetime-local" name="ngayTao" value="${hoaDon.ngayTao}"--%>
<%--                                                   readonly><br>--%>
<%--                                            <label for="" class="label-control">Tong tien</label>--%>
<%--                                            <input type="text" name="tongTien" class="form-control" value="${total}"--%>
<%--                                                   readonly>--%>

<%--                                        </div>--%>
<%--                                        <div class="modal-footer">--%>
<%--                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">--%>
<%--                                                Dong--%>
<%--                                            </button>--%>
<%--                                            <button type="submit" class="btn btn-primary">Thanh toan</button>--%>
<%--                                        </div>--%>

<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </form>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="/ban-hang/thanh-toan" method="post">
            <h2 class="text-center">Thong tin hoa don</h2>
            <label for="" class="label-control">Id hoa don</label>
            <input type="text" name="id" value="${hoaDon.id}" class="form-control"
                   readonly>
            <label for="" class="label-control">Khach hang</label>
            <select name="khachHang">
                <option value="">Khong co</option>
                <c:forEach items="${listKhachHang}" var="kh">
                    <option value="${kh.id}">${kh.hoTen}</option>
                </c:forEach>
            </select><br>
<%--            <label for="" class="label-control">Ngay tao</label>--%>
<%--            <input type="datetime-local" name="ngayTao" value="${hoaDon.ngayTao}" readonly><br>--%>
            <label for="" class="label-control">Tong tien</label>
            <input type="text" name="tongTien" class="form-control" value="${total}" readonly>
            <a href="/ban-hang/huy-hd/${hoaDon.id}" class="btn btn-danger">Huy</a>
            <button type="submit" class="btn btn-primary">Thanh toan</button>
        </form>
    </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>