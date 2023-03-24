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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
        integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <title>Flower Store</title>
</head>

<body>
    <div class="header">
        <div class="header_wrap">
            <a href="/FlowerStore" class="food_header_logo">
                <img src="https://www.flowercorner.vn/image/catalog/1_dienhoa/app/shop-hoa-tuoi-flowercorner-logo.png" alt="">
            </a>


            <div class="header_hello_title">Xin chào: ${usernameFlowerStore }</div>
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
            <h3 class="add_product_success">${deleteUserSuccess }</h3>
            	<table class="table table_user_list list_restaurant">
                    <thead>
                        <tr>
                            <th class="th-bg" scope="col">ID</th>
                            <th class="th-bg" scope="col">Username</th>
                            <th class="th-bg" scope="col">Password</th>
                            <th class="th-bg" scope="col">Role</th>
                            <th class="th-bg" scope="col"><i data-bs-toggle="tooltip" data-bs-placement="top"
                                    data-bs-title="Sửa" class="bi bi-pencil-square"></i></th>
                            <th class="th-bg" scope="col"><i data-bs-toggle="tooltip" data-bs-placement="top"
                                    data-bs-title="Xóa" class="bi bi-trash"></i></th>
                        </tr>
                    </thead>
                    <tbody class="body_restaurant">
						<c:forEach items="${listUser}" var="user">
							<tr class="hover-item-restaurant">
	                            <th scope="row">${user.getId() }</th>
	                            <td>${user.getUsername() }</td>
	                            <td>${user.getPassword() }</td>
	                            <td>${user.getRole() }</td>
	                            <td><a href="user_flower_edit?id=${user.getId() }"><i class="bi-pink-icon bi bi-pencil-square"></i></a></td>
	                            <td><a href="user_flower_delete?id=${user.getId() }"><i class="bi-pink-icon bi bi-trash"></i></a></td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
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
    color: black;
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
}

.btn_login_div_wrap {
    display: flex;
    justify-content: center;
}

.content_right_sum_title {
    margin-bottom: 30px;
    font-weight: bold;
    color: #0873ac;
}

tr:nth-child(even) {
    background-color: #eed6e3;
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
    color: pink;
    padding-right: 320px;
}

.th-bg {
    background-color: pink !important;
}

th, td {
    padding: 10px;
}

html {
    padding: 45px 45px 0 70px;}

.add_product_success {
 color: #a0144f;
}

.bi-pink-icon {
	color: #a0144f;
}
</style>