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
</head>
<body>
<div class="">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/home/hien-thi">Home</a>
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
            <a class="nav-link " href="/hdct/hien-thi">Hoa don chi tiet</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="/ban-hang/hien-thi">Ban Hang</a>
        </li>
    </ul>
</div>
<div class="d-flex justify-content-evenly bg-secondary container my-2" style="border-radius: 10px">
    <div class="card my-3">
        <div class="card-header">
            Doanh thu theo ngay
        </div>
        <div class="card-body">
            ${dayRevenue}
        </div>
    </div>
    <div class="card my-3">
        <div class="card-header">
            Doanh thu theo thang
        </div>
        <div class="card-body">
            ${monthlyRevenue}
        </div>
    </div>
    <div class="card my-3">
        <div class="card-header">
            Doanh thu theo nam
        </div>
        <div class="card-body">
            ${revenueByYear}
        </div>
    </div>
</div>
<div id="carouselExampleAutoplaying" class="carousel slide " data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="\images\anh1.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="\images\anh2.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="\images\anh3.jpg" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>