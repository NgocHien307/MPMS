<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>OTP Verification - Project Management System</title>
    <style>
        /* CSS cho trang login */
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
        input[type=email], input[type=password] {
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
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>OTP Verification</h2>
    <form action="<%= request.getContextPath() %>/VerifyOTPServlet" method="post">
        <label for="otp_code">Enter OTP</label>
        <input type="text" id="otp_code" name="otp_code" required>

        <button type="submit">Verify OTP</button>
    </form>

    <% if (request.getAttribute("error") != null) { %>
    <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>
</div>
</body>
</html>
