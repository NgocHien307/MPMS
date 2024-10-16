<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Đăng Ký</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
  <h2>Đăng Ký</h2>
  <form action="<%= request.getContextPath() %>/register" method="post">
    <label>Họ và tên:</label>
    <input type="text" name="fullName" required>

    <label>Tên đăng nhập:</label>
    <input type="text" name="userName" required>

    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Số điện thoại:</label>
    <input type="text" name="mobile">

    <label>Mật khẩu:</label>
    <input type="password" name="password" required>

    <label>Vai trò:</label>
    <select name="role" required>
      <option value="Admin">Admin</option>
      <option value="Manager">Manager</option>
      <option value="Project Manager">Project Manager</option>
      <option value="Member">Member</option>
      <option value="Guest">Guest</option>
    </select>

    <button type="submit">Đăng Ký</button>
  </form>
  <p>Đã có tài khoản? <a href="<%= request.getContextPath() %>/login">Đăng nhập</a></p>

  <% if (request.getAttribute("error") != null) { %>
  <div class="error"><%= request.getAttribute("error") %></div>
  <% } %>
</div>
</body>
</html>
