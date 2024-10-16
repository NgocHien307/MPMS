<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Xác Thực OTP</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
  <h2>Xác Thực OTP</h2>
  <form action="<%= request.getContextPath() %>/verifyForgotPasswordOtp" method="post">
    <label for="otp">Nhập mã OTP đã gửi đến email của bạn:</label>
    <input type="text" id="otp" name="otp" required>
    <button type="submit">Xác nhận</button>
  </form>
  <p>Quay lại <a href="<%= request.getContextPath() %>/forgotPassword">Quên mật khẩu</a></p>
  <% String error = (String) request.getAttribute("error");
    if (error != null) { %>
  <div class="error"><%= error %></div>
  <% } %>
</div>
</body>
</html>
