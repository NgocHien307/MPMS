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
import jakarta.servlet.http.HttpSession;

import Model.*;
import DAO.*;
        

/**
 *
 * @author hient
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin người dùng từ session
        HttpSession session = request.getSession(false);
        if(session != null){
            User user = (User) session.getAttribute("loggedInUser");
            if(user != null){
                // Lấy vai trò từ setting table
                String role = getUserRole(user.getRole_setting_id());

                // Chuyển hướng đến dashboard tương ứng
                switch(role){
                    case "Admin":
                        response.sendRedirect("admin_dashboard.jsp");
                        break;
                    case "Manager":
                        response.sendRedirect("manager_dashboard.jsp");
                        break;
                    case "Guest":
                        response.sendRedirect("guest_dashboard.jsp");
                        break;
                    default:
                        response.sendRedirect("login.jsp?error=Invalid role.");
                }
            } else {
                response.sendRedirect("login.jsp?error=Please login first.");
            }
        } else {
            response.sendRedirect("login.jsp?error=Please login first.");
        }
    }

    private String getUserRole(int roleSettingId){
        // Implement phương thức này để lấy tên vai trò từ setting table dựa trên role_setting_id
        // Bạn có thể thêm phương thức trong UserDAO để thực hiện việc này
        try {
            DAO.UserDAO userDAO = new DAO.UserDAO();
            return userDAO.getRoleNameBySettingId(roleSettingId);
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
