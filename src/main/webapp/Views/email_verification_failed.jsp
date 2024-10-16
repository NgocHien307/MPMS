<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Email Verification Failed</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #ffe6e6;
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
      margin-top: 20px;
      padding: 10px 20px;
      background-color: #f44336;
      color: white;
      text-decoration: none;
      border-radius: 5px;
    }
    a:hover {
      background-color: #da190b;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Email Verification Failed!</h2>
  <p>The verification link is invalid or has expired.</p>
  <a href="register.jsp">Register Again</a>
</div>
</body>
</html>
