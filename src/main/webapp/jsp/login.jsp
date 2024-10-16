<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Đăng Nhập</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
  <h2>Đăng Nhập</h2>
  <form action="<%= request.getContextPath() %>/login" method="post">
    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Mật khẩu:</label>
    <input type="password" name="password" required>

    <button type="submit">Đăng Nhập</button>
  </form>
  <p>Chưa có tài khoản? <a href="<%= request.getContextPath() %>/register">Đăng ký</a></p>

  <% if (request.getAttribute("error") != null) { %>
  <div class="error"><%= request.getAttribute("error") %></div>
  <% } %>
  <% if (request.getAttribute("message") != null) { %>
  <div class="message"><%= request.getAttribute("message") %></div>
  <% } %>
</div>
</body>
</html>
