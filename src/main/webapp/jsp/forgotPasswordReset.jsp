<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Đặt Lại Mật Khẩu</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
  <h2>Đặt Lại Mật Khẩu</h2>
  <form action="<%= request.getContextPath() %>/forgotPasswordReset" method="post">
    <label for="newPassword">Mật khẩu mới:</label>
    <input type="password" id="newPassword" name="newPassword" required>

    <label for="confirmPassword">Xác nhận mật khẩu mới:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required>

    <button type="submit">Đặt lại mật khẩu</button>
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
