<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="main.css">
    <link rel="icon" href="https://logos-download.com/wp-content/uploads/2017/01/Circle_Food_Store_logo-700x342.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
        integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <title>Flower Store</title>
</head>

<body>
    <div class="header">
        <div class="header_wrap">
            <a href="/FoodStore" class="food_header_logo">
                <img src="https://www.flowercorner.vn/image/catalog/1_dienhoa/app/shop-hoa-tuoi-flowercorner-logo.png" alt="">
            </a>

            <div class="search_header w-25">
                <div class="search_header_wrap">
                    <input class="search_header_input" id="searchingPage" type="text" placeholder="Nhập tên loại hoa">
                    <i class="fa-solid fa-magnifying-glass search_header_icon"></i>
                </div>
            </div>

            <div class="header_hello_title"></div>
        </div>
    </div>

    <div class="content">
        <div class="content_wrap">
            <div class="content_left">
                <a href="/FlowerStore" class="content_left_item content_left_item_logout_active">Tất cả loại hoa</a>
                <a href="flower_chucmung" class="content_left_item">Hoa chúc mừng</a>
                <a href="flower_nhagiao" class="content_left_item">Ngày nhà giáo Việt Nam</a>
                <a href="flower_cuame" class="content_left_item">Hoa của mẹ</a>
                <a href="flower_tinhyeu" class="content_left_item">Hoa tình yêu</a>
                <a href="flower_user" class="content_left_item">Quản lý tài khoản</a>
                <a href="logout" class="content_left_item content_left_item_logout">Đăng xuất</a>
            </div>

            <div class="content_right">
            	<div class="search_value_title"><strong>${addingSuccess }</strong></div>
            	<h2 class="content_right_sum_title">Thêm loại hoa</h2>
                <form class="form_add_item" action="${pageContext.request.contextPath}/add_flower" method="post">
                    <div class="mb-3">
                        <label class="form-label"><strong>Loại hoa</strong></label>
                        <select name="flower_name" id="flower_name" class="form-select">
                            <option value="chucmung">Hoa chúc mừng</option>
                            <option value="nhagiao">Ngày nhà giáo Việt Nam</option>
                            <option value="cuame">Hoa của mẹ</option>
                            <option value="tinhyeu">Hoa tình yêu</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label"><strong>Tên</strong></label>
                        <input required="" type="text" placeholder="Nhập tên loại hoa" class="form-control" name="name"
                            id="name">
                    </div>
                    <div class="mb-3">
                        <label class="form-label"><strong>Giá</strong></label>
                        <input required="" type="number" placeholder="Nhập Giá" class="form-control" name="price"
                            id="price">
                    </div>
                    <div class="mb-3">
                        <label class="form-label"><strong>Link image</strong></label>
                        <input required="" type="text" placeholder="Nhập link hình ảnh" class="form-control"
                            name="link_image" id="link_image">
                    </div>
                    <div class="mb-3">
                        <label class="form-label"><strong>Description</strong></label>
                        <textarea name="description" id="description" class="form-control" required="" type="text"
                            placeholder="Nhập mô tả" aria-label="With textarea"></textarea>
                    </div>
                    <div class="btn_login_div_wrap">
                        <button type="submit" class="btn btn-primary btn-form-login-submit">Thêm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="footer"></div>

</body>

</html>


<style>

* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    font-family: Arial, Helvetica, sans-serif;
}

.search_header_wrap {
    display: flex;
    align-items: center;
    justify-content: center;
    border: 1px solid #333;
    height: 36px;
    border-radius: 20px;
    position: relative;
    width: 280px;
    background-color: white;
}

.search_header_input {
    border: none;
    outline: none;
    left: 20px;
    font-size: inherit;
}

.content_left_item_logout_active {
    background-color: pink;
    color: white;
}  

.search_header_icon {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    width: 20px;
    right: 10px;
    font-size: 20px;
    color: #1e73ac;
    font-weight: bold;
}

.header_wrap {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 30px;
    height: 70px;
    /* background-color: #0b86c9; */
    background-color: pink;
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
}

.food_header_logo {
    display: block;
    height: 100%;
}

.food_header_logo img {
    height: 100%;
    padding: 5px 0;
}

.header_hello_title {
    font-weight: bold;
    font-size: 24px;
    color: white;
}

.content {
    margin-top: 70px;
}

.content_wrap {
    display: flex;
    justify-content: flex-end;
}

.content_add_page_wrap {
    display: flex;
    padding: 50px 200px;
    justify-content: flex-end;
}

.content_left {
    background-color: #f1f1f1;
    height: 100vh;
    padding-top: 20px;
    width: 20%;
    position: fixed;
    left: 0;
    bottom: 0;
    top: 70px;
}

.content_left_item {
    display: block;
    text-decoration: none;
    color: black;
    font-weight: bold;
    font-size: 22px;
    text-align: center;
    padding: 20px 40px;
    border-radius: 8px;
}

.content_left_item:hover {
    /* background-color: #0b86c9; */
    background-color: pink;
    color: white;
}

.content_left_item_logout:hover {
    background-color: rgb(255, 86, 86);
    color: white;
}   

.product_item_title {
    font-weight: bold;
    font-size: 18px;
    padding: 5px 0;
    text-align: center;
}

.product_item {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 25%;
}

.product_item_button_detail {
    width: 100%;
    display: flex;
    justify-content: center;
    padding-bottom: 8px;
}

.product_item_button_detail a {
    width: 80%;
    font-weight: bold;
}

.product_item_button_manipulate {
    width: 100%;
    padding: 0 10%;
    display: flex;
    justify-content: space-between;
}

.product_item_button_manipulate a {
    width: 48%;
    font-weight: bold;
}

.product_list_item {
    display: flex;
    flex-wrap: wrap;
    padding: 30px;
}

.content_right {
    width: 80%;
    padding: 50px 100px;
}

.product_item_img {
    width: 85%;
}

.product_item {
    padding: 20px;
    border: 1px solid #bcbcbc;
}

.form_add_item {
    width: 600px;
}

.btn-form-login-submit {
    padding: 12px 25px !important;
    font-size: 16px !important;
    background-color: #a0144f !important;
    border: #a0144f !important;
}

.btn_login_div_wrap {
    display: flex;
    justify-content: center;
}

.content_right_sum_title {
    margin-bottom: 30px;
    font-weight: bold;
    color: #a0144f;
}

tr:nth-child(even) {
    background-color: #D6EEEE;
  }

th, td {
    padding: 15px;
}

.btn_delete_confirm {
    margin-top: 20px;
    display: block;
    display: flex;
    justify-content: center;
}


.content_right_add_container {
    padding: 20px;
    display: flex;
    justify-content: flex-end;
    margin-bottom: 16px;
    border-bottom: 1px solid #ccc;
}

.search_value_title strong {
	font-size: 22px;
    color: rgb(255, 86, 86);
}

</style>