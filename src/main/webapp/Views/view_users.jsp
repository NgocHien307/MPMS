<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>View Users - Admin Dashboard</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }
    .container {
      width: 90%;
      margin: auto;
      background-color: #fff;
      padding: 40px;
      margin-top: 30px;
      box-shadow: 0px 0px 10px 0px #000;
      border-radius: 10px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      padding: 12px;
      border-bottom: 1px solid #ddd;
      text-align: left;
    }
    tr:hover {background-color: #f5f5f5;}
    .action-links a {
      margin-right: 10px;
      color: #008CBA;
      text-decoration: none;
    }
    .action-links a:hover {
      text-decoration: underline;
    }
    .logout {
      float: right;
      margin-top: -50px;
    }
  </style>
</head>
<body>
<div class="container">
  <a href="LogoutServlet" class="logout">Logout</a>
  <h2>User List</h2>
  <table>
    <tr>
      <th>User ID</th>
      <th>Full Name</th>
      <th>Username</th>
      <th>Email</th>
      <th>Mobile</th>
      <th>Role</th>
      <th>Status</th>
      <th>Actions</th>
    </tr>
    <%
      List<User> userList = (List<User>) request.getAttribute("userList");
      if(userList != null){
        for(User user : userList){
          // Lấy tên vai trò từ UserDAO
          String roleName = "";
          try{
            roleName = new DAO.UserDAO().getRoleNameBySettingId(user.getRole_setting_id());
          } catch(Exception e){
            e.printStackTrace();
          }
    %>
    <tr>
      <td><%= user.getUser_id() %></td>
      <td><%= user.getFull_name() %></td>
      <td><%= user.getUser_name() %></td>
      <td><%= user.getEmail() %></td>
      <td><%= user.getMobile() %></td>
      <td><%= roleName %></td>
      <td><%= user.getStatus() %></td>
      <td class="action-links">
        <a href="ActivateDeactivateServlet?user_id=<%= user.getUser_id() %>&action=<%= user.getStatus().equals("active") ? "deactivate" : "activate" %>">
          <%= user.getStatus().equals("active") ? "Deactivate" : "Activate" %>
        </a>
        <a href="UpdateUserServlet?user_id=<%= user.getUser_id() %>">Edit</a>
      </td>
    </tr>
    <%
        }
      }
    %>
  </table>
</div>
</body>
</html>
