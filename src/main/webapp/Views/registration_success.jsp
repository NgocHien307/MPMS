<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful - Project Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6e6e6;
        }
        .container {
            width: 50%;
            margin: auto;
            background-color: #fff;
            padding: 40px;
            margin-top: 50px;
            box-shadow: 0px 0px 10px 0px #000;
            border-radius: 10px;
            text-align: center;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            color: #4CAF50;
            text-decoration: none;
            padding: 10px 20px;
            border: 1px solid #4CAF50;
            border-radius: 4px;
        }
        a:hover {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Registration Successful!</h2>
    <p>An OTP code has been sent to your email. Please verify to activate your account.</p>
    <a href="otp_verification.jsp">Verify OTP</a>
</div>
</body>
</html>
