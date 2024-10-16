<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Project Management System</title>
  <style>
    /* CSS cơ bản cho giao diện */
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      text-align: center;
      padding-top: 100px;
    }
    .container {
      background-color: #fff;
      padding: 50px;
      margin: auto;
      width: 50%;
      box-shadow: 0px 0px 10px 0px #000;
      border-radius: 10px;
    }
    a {
      display: inline-block;
      margin: 20px;
      padding: 15px 25px;
      background-color: #4CAF50;
      color: white;
      text-decoration: none;
      border-radius: 5px;
    }
    a:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Welcome to Project Management System</h1>
  <a href="Views/login.jsp">Login</a>
  <a href="Views/register.jsp">Register</a>
</div>
</body>
</html>
