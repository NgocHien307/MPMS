/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.*;
import Model.*;
import java.sql.*;

/**
 *
 * @author hient
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdParam = request.getParameter("user_id");

        if(userIdParam != null){
            int userId = Integer.parseInt(userIdParam);
            try {
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserById(userId);
                request.setAttribute("user", user);
                request.getRequestDispatcher("update_user.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
                response.sendRedirect("/ViewUsersServlet?error=Cannot retrieve user details.");
            }
        } else {
            response.sendRedirect("/ViewUsersServlet?error=Invalid user ID.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý cập nhật thông tin người dùng
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String fullName = request.getParameter("full_name");
        String userName = request.getParameter("user_name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        String roleName = request.getParameter("role");
        String status = request.getParameter("status");

        // Mã hóa mật khẩu
        String hashedPassword = PasswordUtil.hashPassword(password);

        try {
            UserDAO userDAO = new UserDAO();
            int roleSettingId = userDAO.getRoleSettingIdByNameAndType(roleName, "user_role");

            // Lấy user hiện tại để cập nhật
            User user = userDAO.getUserById(userId);
            user.setFull_name(fullName);
            user.setUser_name(userName);
            user.setEmail(email);
            user.setMobile(mobile);
            user.setPassword(hashedPassword);
            user.setRole_setting_id(roleSettingId);
            user.setStatus(status);
            user.setUpdated_at(new java.sql.Timestamp(System.currentTimeMillis()));
            user.setUpdated_by_id(1); // Giả sử Admin có user_id = 1

            // Cập nhật user
            userDAO.updateUser(user);

            response.sendRedirect("/ViewUsersServlet");

        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            response.sendRedirect("/ViewUsersServlet?error=Cannot update user.");
        }
    }
}