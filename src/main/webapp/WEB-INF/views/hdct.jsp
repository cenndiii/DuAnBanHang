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
        .my-4.p-4 {
            background-color: #b1bfbd;
            border-radius: 10px;
        }
    </style>
</head>
<body class="">
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
            <a class="nav-link active" aria-current="page" href="/hdct/hien-thi">Hoa don chi tiet</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ban-hang/hien-thi">Ban Hang</a>
        </li>
    </ul>
</div>
<div class="container">
    <c:if test="${not empty error}">
        <div class="alert alert-danger">
                ${error}
        </div>
    </c:if>
    <div class="card my-4">
        <div class="card-header">
            <h1 class="text-center">Hoa don</h1>
        </div>
        <div class="card-body">
            <form action="/hdct/tim-kiem" method="post">
                <label class="label-control">Tim kiem</label>
                <input type="text" name="keyWord">
                <select name="key" >
                    <option value="1">Id hoa don</option>
                    <option value="2">Id Khach hang</option>
                    <option value="3">Ten Khach hang</option>
                    <option value="4">Trang thai</option>
                </select>
                <label class="label-control">Tu ngay</label>
                <input type="datetime-local" name="startDate" >
                <label class="label-control">Den ngay</label>
                <input type="datetime-local" name="endDate">
                <button type="submit" style="border-radius: 10px;border: black 1px outset">Tim kiem</button>
            </form>
            <hr>
<%--            <table class="table table-hover">--%>
<%--                <thead>--%>
<%--                <th>Id</th>--%>
<%--                <th>Id khach hang</th>--%>
<%--                <th>Ten khach hang</th>--%>
<%--                <th>Ngay tao</th>--%>
<%--                <th>Ngay sua</th>--%>
<%--                <th>Trang thai</th>--%>
<%--                <th>Hanh dong</th>--%>
<%--                </thead>--%>
<%--                <tbody>--%>
<%--                <c:forEach items="${listHoaDon}" var="hoaDon">--%>
<%--                    <tr>--%>
<%--                        <td>${hoaDon.id}</td>--%>
<%--                        <td>${hoaDon.khachHang.id}</td>--%>
<%--                        <td>${hoaDon.khachHang.hoTen}</td>--%>
<%--                        <td>${hoaDon.ngayTao}</td>--%>
<%--                        <td>${hoaDon.ngaySua}</td>--%>
<%--                        <td>${hoaDon.trangThai}</td>--%>
<%--                        <td><a href="/hdct/detail-hdct/${hoaDon.id}" class="btn btn-warning">Detail</a></td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--                </tbody>--%>
<%--            </table>--%>
            <table class="table table-hover">
                <thead>
                <th>Id</th>
                <th>Id khach hang</th>
                <th>Ten khach hang</th>
                <th>Ngay tao</th>
                <th>Ngay sua</th>
                <th>tong</th>
                <th>Trang thai</th>
                <th>Hanh dong</th>
                </thead>
                <tbody>
                <c:forEach items="${listHoaDon}" var="hoaDon">
                    <tr>
                        <td>${hoaDon.id}</td>
                        <td>${hoaDon.idKhachHang}</td>
                        <td>${hoaDon.hoTen}</td>
                        <td>${hoaDon.ngayTao}</td>
                        <td>${hoaDon.ngaySua}</td>
                        <td>${hoaDon.tongTien}</td>
                        <td>${hoaDon.trangThai}</td>
                        <td><a href="/hdct/detail-hdct/${hoaDon.id}" class="btn btn-warning">Detail</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/hdct/reload" class="btn btn-primary">Tai lai</a>
            <div class="float-end">
                <label class="label-control">Tong tien cac hoa don</label>
                <input type="text" name="totalAllBill" value="${totalAllBill}" class="text-end" readonly>
            </div>
        </div>
    </div>
    <div class="card my-4">
        <div class="card-header">
            <h1 class="text-center">Hoa don chi tiet</h1>
        </div>
        <div class="float-start mt-2">
            <label class="label-control">Tong tien</label>
            <input type="text" name="totalBill" value="${totalBill}" class="" readonly>
        </div>
        <hr>
        <div class="card-body">
            <table class="table table-hover">
                <thead>
                <th>Id hoa don</th>
                <th>San pham</th>
                <th>So luong mua</th>
                <th>Gia ban</th>
                <th>Tong tien</th>
                <th>Trang thai</th>
                <th>Ngay tao</th>
                <th>Ngay sua</th>
                </thead>
                <tbody>
                <c:forEach items="${listSpct}" var="spct">
                    <tr>
                        <td>${spct.idHoaDon}</td>
                        <td>${spct.tenSanPham}</td>
                        <td>${spct.soLuongMua}</td>
                        <td>${spct.giaBan}</td>
                        <td>${spct.tongTien}</td>
                        <td>${spct.trangThai}</td>
                        <td>${spct.ngayTao}</td>
                        <td>${spct.ngaySua}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>