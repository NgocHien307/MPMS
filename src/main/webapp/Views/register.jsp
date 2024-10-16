<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Project Management System</title>
    <style>
        /* CSS cơ bản cho giao diện */
        body {
            font-family: Arial, sans-serif;
            background-color: #e6e6e6;
        }
        .container {
            width: 50%;
            margin: auto;
            background-color: #fff;
            padding: 40px;
            margin-top: 50px;
            box-shadow: 0px 0px 10px 0px #000;
            border-radius: 10px;
        }
        input[type=text], input[type=email], input[type=password], input[type=tel], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0 20px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
        }
        a {
            display: block;
            margin-top: 20px;
            color: #4CAF50;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Register</h2>

    <%
        String errorMessage = (String) request.getAttribute("error");
        String fullName = (String) request.getAttribute("full_name");
        String userName = (String) request.getAttribute("user_name");
        String email = (String) request.getAttribute("email");
        String mobile = (String) request.getAttribute("mobile");

        if (errorMessage != null) {
    %>
    <p class="error"><%= errorMessage %></p>
    <%
        }
    %>

    <form action="<%= request.getContextPath() %>/RegisterServlet" method="post">
        <label for="full_name">Full Name</label>
        <input type="text" id="full_name" name="full_name"
               placeholder="Your full name.." value="<%= fullName != null ? fullName : "" %>" required>

        <label for="user_name">Username</label>
        <input type="text" id="user_name" name="user_name"
               placeholder="Your username.." value="<%= userName != null ? userName : "" %>" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email"
               placeholder="Your email.." value="<%= email != null ? email : "" %>" required>

        <label for="mobile">Mobile</label>
        <input type="tel" id="mobile" name="mobile"
               placeholder="Your mobile number.." value="<%= mobile != null ? mobile : "" %>" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Your password.." required>

        <!-- Thêm phần chọn vai trò -->
        <label for="role">Select Role</label>
        <select id="role" name="role">
            <option value="Admin">Admin</option>
            <option value="Manager">Manager</option>
            <option value="Project Leader">Employee</option>
            <option value="Project Member">Employee</option>

        </select>

        <button type="submit">Register</button>
    </form>
    <a href="<%= request.getContextPath() %>/index.jsp">Back to Home</a>
</div>
</body>
</html>
