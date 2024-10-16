<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Xác Thực OTP</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
  <h2>Nhập Mã OTP</h2>
  <form action="<%= request.getContextPath() %>/otpVerification" method="post">
    <label>Nhập mã OTP đã gửi đến email của bạn:</label>
    <input type="text" name="otp" required>
    <button type="submit">Xác Thực</button>
  </form>

  <% if (request.getAttribute("error") != null) { %>
  <div class="error"><%= request.getAttribute("error") %></div>
  <% } %>
</div>
</body>
</html>
