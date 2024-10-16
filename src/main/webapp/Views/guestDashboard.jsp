<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.User" %>
<!DOCTYPE html>
<html>
<head>
  <title>Guest Dashboard</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }
    .container {
      width: 80%;
      margin: auto;
      background-color: #fff;
      padding: 40px;
      margin-top: 50px;
      box-shadow: 0px 0px 10px 0px #000;
      border-radius: 10px;
    }
    a {
      color: #f44336;
      text-decoration: none;
      float: right;
    }
    a:hover {
      text-decoration: underline;
    }
    .logout {
      clear: both;
      text-align: right;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div class="container">
  <a href="LogoutServlet">Logout</a>
  <h2>Guest Dashboard</h2>
  <p>Welcome, Guest!</p>
  <!-- Thêm các chức năng giới hạn cho Guest tại đây -->
</div>
</body>
</html>
