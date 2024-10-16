
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="Model.User" %>
<%
  User user = (User) session.getAttribute("user");
  if (user == null || !user.getRoleName().equals("Ma")) {
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
  <a href="<%= request.getContextPath() %>/logout">Đăng xuất</a>
</div>
</body>
</html>
