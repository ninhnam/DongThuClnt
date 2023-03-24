<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <link rel="icon" href="https://logos-download.com/wp-content/uploads/2017/01/Circle_Food_Store_logo-700x342.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
        integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <title>Flower Store Signin</title>
</head>

<body>
    <div class="form_login">
        <h1 class="page_form_login_title">Quản lý cửa hàng bán hoa tươi</h1>
        <div class="page_form_login_title_error">${signinStatus }</div>
        <form class="form_login_form" action="${pageContext.request.contextPath}/signin" method="post">
            <h2 class="form_login_title">Đăng kí</h2>
            <div class="mb-3 form_login_input">
                <label for="exampleInputUsername" class="form-label"><strong>Username:</strong></label>
                <input placeholder="Nhập username" type="text" class="form-control" id="exampleInputUsername" name="username"
                    aria-describedby="emailHelp">
            </div>
            <div class="mb-3 form_login_input">
                <label for="exampleInputPassword" class="form-label"><strong>Password</strong></label>
                <input pattern=".{6,}" required type="password" placeholder="Nhập password" class="form-control" id="exampleInputPassword" name="password">
            </div>
            <div class="mb-3 form_login_input">
                <label for="exampleInputPassword_confirm" class="form-label"><strong>Confirm Password</strong></label>
                <input pattern=".{6,}" required type="password" placeholder="Xác nhận password" class="form-control" name="password_confirm"
                    id="exampleInputPassword_confirm">
            </div>
            <button type="submit" class="btn btn-primary btn-form-login-submit">Đăng kí</button>
        </form>
        <a class="form_login_signup" href="login">Đăng nhập</a>
    </div>
</body>

</html>

<style>

* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    font-family: Arial, Helvetica, sans-serif;
}

.form_login {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100vw;
    height: 100vh;
    padding-top: 120px;
    background-color: #a0144f;
}

.form_login_form {
    background-color: white;
    width: 400px;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 30px 40px 40px;
    border-radius: 10px;
}

.form_login_input {
    width: 90%;
}

.page_form_login_title {
    padding-bottom: 20px;
    color: white;
    font-weight: bold;
}

.form_login_signup {
    padding-top: 5px;
    font-size: 18px;
    color: white;
}


.page_form_login_title_error {
	padding-bottom: 20px;
    color: #ffce09;
}

</style>