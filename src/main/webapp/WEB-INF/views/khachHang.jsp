<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        .my-4.p-4{
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
            <a class="nav-link"  href="/danh-muc/hien-thi">Danh muc</a>
        </li>
        <li class="nav-item">
            <a class="nav-link "  href="/san-pham/hien-thi">San pham</a>
        </li>
        <li class="nav-item">
            <a class="nav-link "  href="/ctsp/hien-thi">Chi tiet san pham</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page"href="/khach-hang/hien-thi">Khach hang</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="/hdct/hien-thi">Hoa don chi tiet</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ban-hang/hien-thi">Ban Hang</a>
        </li>
    </ul>
</div>
<div class="container">
    <div class="my-4 p-4">
        <h1 class="text-center">Khach hang</h1>

        <form:form action="/khach-hang/add-khachHang" method="post" class="my-4" modelAttribute="khachHang">
            <label for="hoTen" class="label-control">Ten</label>
            <form:input path="hoTen" class="form-control"/>
            <form:errors path="hoTen" cssClass="text-danger"/><br>

            <label for="diaChi" class="label-control">Dia chi</label>
            <form:input path="diaChi" class="form-control"/>
            <form:errors path="diaChi" cssClass="text-danger"/><br>

            <label for="sdt" class="label-control">Sdt</label>
            <form:input path="sdt" class="form-control"/>
            <form:errors path="sdt" cssClass="text-danger"/><br>

            <label class="label-control">Trang thai</label><br>
            <form:radiobutton path="trangThai" value="Active"/> Active
            <form:radiobutton path="trangThai" value="Inactive"/> Inactive
            <br>

            <button type="submit" class="btn btn-success">Add</button>
        </form:form>

        <table class="table table-hover">
            <thead>
            <th>Id</th>
            <th>Ten</th>
            <th>Dia chi</th>
            <th>Sdt</th>
            <th>Ngay tao</th>
            <th>Ngay Sua</th>
            <th>Trang thai</th>
            <th>Hanh dong</th>
            </thead>
            <tbody>
            <c:forEach items="${listKhachHang}" var="khachHang">
                <tr>
                    <td>${khachHang.id}</td>
                    <td>${khachHang.hoTen}</td>
                    <td>${khachHang.diaChi}</td>
                    <td>${khachHang.sdt}</td>
                    <td>${khachHang.ngayTao}</td>
                    <td>${khachHang.ngaySua}</td>
                    <td>${khachHang.trangThai}</td>
                    <td><a href="/khach-hang/detail-khachHang/${khachHang.id}" class="btn btn-warning">Detail</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>