<%--
  Created by IntelliJ IDEA.
  User: Asilb
  Date: 5/12/2024
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
    <style>
        body {
            background-color: #f9f9f9;
        }

        .container {
            margin-top: 100px;
        }

        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card-header {
            background-color: lime;
            color: #fff;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            padding: 20px;
            text-align: center;
        }

        .card-body {
            padding: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .sticker {
            position: absolute;
            top: -20px;
            right: -20px;
            width: 70px;
            height: 70px;
            background-color: blueviolet;
            border-radius: 50%;
            color: #fff;
            font-size: 24px;
            font-weight: bold;
            display: flex;
            align-items: center;
            justify-content: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transform: rotate(45deg);
        }

        .btn-primary {
            background-color: lime;
            border-color: black;
        }

        .btn-primary:hover {
            background-color: #f85252;
            border-color: #f85252;
        }

        .btn-primary:focus,
        .btn-primary:active {
            background-color: black;
            border-color: yellow;
            box-shadow: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="card-header">
                    <h3>Login</h3>
                    <div class="sticker">&#10084;</div>
                </div>
                <div class="card-body">
                    <form action="/auth/login" method="get">
                        <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <input name="phone" type="tel" class="form-control" id="phone"
                                   placeholder="Enter your phone number">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input name="password" type="password" class="form-control" id="password"
                                   placeholder="Enter your password">
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
