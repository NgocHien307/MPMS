<%@ page import="Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !user.getRoleName().equals("Manager")) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manager Dashboard</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
    <h2>Chào mừng, <%= user.getFull_name() %> (Manager)</h2>
    <p>Đây là trang dành cho Manager.</p>
    <a href="<%= request.getContextPath() %>/logout">Đăng xuất</a>
</div>
</body>
</html>
