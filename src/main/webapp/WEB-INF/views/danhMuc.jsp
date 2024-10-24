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
            <a class="nav-link active" aria-current="page" href="/danh-muc/hien-thi">Danh muc</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/san-pham/hien-thi">San pham</a>
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
        <h1 class="text-center">Danh muc</h1>
        <form:form action="/danh-muc/add-danhMuc" method="post" class="my-4" modelAttribute="danhMuc">
            <label for="maDanhMuc" class="label-control">Ma</label>
            <form:input path="maDanhMuc" cssClass="form-control"/>
            <form:errors path="maDanhMuc" cssClass="text-danger"/><br>

            <label for="tenDanhMuc" class="label-control">Ten</label>
            <form:input path="tenDanhMuc" cssClass="form-control"/>
            <form:errors path="tenDanhMuc" cssClass="text-danger"/><br>

            <label class="form-label">Trang thai</label><br>
            <form:radiobutton path="trangThai" value="Active" label="Active" />
            <form:radiobutton path="trangThai" value="Inactive" label="Inactive" /><br>

            <button type="submit" class="btn btn-success">Add</button>

        </form:form>
        <table class="table table-hover">
            <thead>
            <th>Id</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>Ngay tao</th>
            <th>Ngay Sua</th>
            <th>Trang thai</th>
            <th>Hanh dong</th>
            </thead>
            <tbody>
            <c:forEach items="${listDanhMuc}" var="danhMuc">
                <tr>
                    <td>${danhMuc.id}</td>
                    <td>${danhMuc.maDanhMuc}</td>
                    <td>${danhMuc.tenDanhMuc}</td>
                    <td>${danhMuc.ngayTao}</td>
                    <td>${danhMuc.ngaySua}</td>
                    <td>${danhMuc.trangThai}</td>
                    <td><a href="/danh-muc/detail-danhMuc/${danhMuc.id}" class="btn btn-warning">Detail</a> </td>
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