<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.User" %>
<%@ page session="true" %>
<%
  User user = (User) session.getAttribute("user");
  if (user == null || !user.hasRole("Admin")) {
    response.sendRedirect(request.getContextPath() + "/login");
    return;
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
  <h2>Chào mừng, <%= user.getFull_name() %> (Admin)</h2>
  <p>Đây là trang quản trị.</p>
  <a href="<%= request.getContextPath() %>/logout" class="btn">Đăng xuất</a>
</div>
</body>
</html>
