<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Project Management System</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
  <h1>Welcome to Project Management System</h1>
  <a href="<%= request.getContextPath() %>/login" class="btn">Login</a>
  <a href="<%= request.getContextPath() %>/register" class="btn">Register</a>
</div>
</body>
</html>
