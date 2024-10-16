<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quên Mật Khẩu</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
    <h2>Quên Mật Khẩu</h2>
    <form action="<%= request.getContextPath() %>/forgotPassword" method="post">
        <label for="email">Email đã đăng ký:</label>
        <input type="email" id="email" name="email" required>
        <button type="submit">Gửi OTP</button>
    </form>
    <p>Quay lại <a href="<%= request.getContextPath() %>/login">Đăng nhập</a></p>
    <% String error = (String) request.getAttribute("error");
        String message = (String) request.getAttribute("message");
        if (error != null) { %>
    <div class="error"><%= error %></div>
    <% } if (message != null) { %>
    <div class="message"><%= message %></div>
    <% } %>
</div>
</body>
</html>
