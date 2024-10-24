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
            <a class="nav-link "  href="/danh-muc/hien-thi">Danh muc</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/san-pham/hien-thi">San pham</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/ctsp/hien-thi">Chi tiet san pham</a>
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
        <h1 class="text-center">Chi tiet san pham</h1>
        <form:form action="/ctsp/add-ctsp" method="post" class="my-4" modelAttribute="ctsp">
            <label for="sanPham" class="label-control">San pham</label>
            <form:select path="sanPham" class="form-select">
                <form:options items="${listSanPham}" itemValue="id" itemLabel="tenSanPham"/>
            </form:select>

            <label for="mauSac" class="label-control">Mau sac</label>
            <form:select path="mauSac" class="form-select">
                <form:options items="${listMau}" itemValue="id" itemLabel="tenMau"/>
            </form:select>

            <label for="size" class="label-control">Size</label>
            <form:select path="size" class="form-select">
                <form:options items="${listSize}" itemValue="id" itemLabel="tenSize"/>
            </form:select>

            <label for="giaBan" class="label-control">Gia ban</label>
            <form:input path="giaBan" class="form-control"/>
            <form:errors path="giaBan" cssClass="text-danger"/><br>

            <label for="soLuongTon" class="label-control">So luong ton</label>
            <form:input path="soLuongTon" class="form-control"/>
            <form:errors path="soLuongTon" cssClass="text-danger"/><br>

            <label class="label-control">Trang thai</label><br>
            <form:radiobutton path="trangThai" value="Active"/>Active
            <form:radiobutton path="trangThai" value="Inactive"/>Inactive<br>
            <form:errors path="trangThai" cssClass="text-danger"/>

            <button type="submit" class="btn btn-success">Add</button>
        </form:form>

        <table class="table table-hover">
            <thead>
            <th>Id</th>
            <th>San pham</th>
            <th>Mau sac</th>
            <th>Size</th>
            <th>Gia ban</th>
            <th>So luong ton</th>
            <th>Ngay tao</th>
            <th>Ngay Sua</th>
            <th>Trang thai</th>
            <th>Hanh dong</th>
            </thead>
            <tbody>
            <c:forEach items="${listCtsp}" var="ctsp">
                <tr>
                    <td>${ctsp.id}</td>
                    <td>${ctsp.sanPham.tenSanPham}</td>
                    <td>${ctsp.mauSac.tenMau}</td>
                    <td>${ctsp.size.tenSize}</td>
                    <td>${ctsp.giaBan}</td>
                    <td>${ctsp.soLuongTon}</td>
                    <td>${ctsp.ngayTao}</td>
                    <td>${ctsp.ngaySua}</td>
                    <td>${ctsp.trangThai}</td>
                    <td><a href="/ctsp/detail-ctsp/${ctsp.id}" class="btn btn-warning">Detail</a> </td>
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