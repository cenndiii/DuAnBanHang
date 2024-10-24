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
            <a class="nav-link active" aria-current="page" href="/san-pham/hien-thi">San pham</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ctsp/hien-thi">Chi tiet san pham</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/khach-hang/hien-thi">Khach hang</a>
        </li>

        <li class="nav-item">
            <a class="nav-link "  href="/hdct/hien-thi">Hoa don chi tiet</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ban-hang/hien-thi">Ban Hang</a>
        </li>
    </ul>
</div>
<div class="container">
    <div class="my-4 p-4">
        <h1 class="text-center">San pham</h1>
        <form:form action="/san-pham/add-sanPham" method="post" class="my-4" modelAttribute="sanPham">
            <label for="maSanPham" class="label-control">Ma</label>
            <form:input path="maSanPham" class="form-control"/>
            <form:errors path="maSanPham" cssClass="text-danger"/><br>

            <label for="tenSanPham" class="label-control">Ten</label>
            <form:input path="tenSanPham" class="form-control"/>
            <form:errors path="tenSanPham" cssClass="text-danger"/><br>

            <label class="label-control">Trang thai</label><br>
            <form:radiobutton path="trangThai" value="Active"/>Active
            <form:radiobutton path="trangThai" value="Inactive"/>Inactive<br>
            <form:errors path="trangThai" cssClass="text-danger"/>

            <label for="danhMuc" class="label-control">Danh muc</label>
            <form:select path="danhMuc" class="form-select">
                <form:options items="${listDanhMuc}" itemValue="id" itemLabel="tenDanhMuc"/>
            </form:select>

            <button type="submit" class="btn btn-success">Add</button>
        </form:form>
        <table class="table table-hover">
            <thead>
            <th>Id</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>Ngay tao</th>
            <th>Ngay Sua</th>
            <th>Danh muc</th>
            <th>Trang thai</th>
            <th>Hanh dong</th>
            </thead>
            <tbody>
            <c:forEach items="${listSanPham}" var="sanPham">
                <tr>
                    <td>${sanPham.id}</td>
                    <td>${sanPham.maSanPham}</td>
                    <td>${sanPham.tenSanPham}</td>
                    <td>${sanPham.ngayTao}</td>
                    <td>${sanPham.ngaySua}</td>
                    <td>${sanPham.danhMuc.tenDanhMuc}</td>
                    <td>${sanPham.trangThai}</td>
                    <td><a href="/san-pham/detail-sanPham/${sanPham.id}" class="btn btn-warning">Detail</a> </td>
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