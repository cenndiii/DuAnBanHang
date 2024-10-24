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
<div class="container">
    <div class="my-4 p-4">
        <h1 class="text-center">Thong tin Ctsp</h1>
        <form:form action="/ctsp/update-ctsp/${ctsp.id}" method="post" class="my-4" modelAttribute="ctsp">
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

            <button type="submit" class="btn btn-success">Update</button>
        </form:form>
    </div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>