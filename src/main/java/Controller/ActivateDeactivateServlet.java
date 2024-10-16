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
import java.sql.SQLException;


/**
 *
 * @author hient
 */
@WebServlet("/ActivateDeactivateServlet")
public class ActivateDeactivateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdParam = request.getParameter("user_id");
        String action = request.getParameter("action");

        if(userIdParam != null && action != null){
            int userId = Integer.parseInt(userIdParam);
            String newStatus = action.equalsIgnoreCase("activate") ? "active" : "inactive";

            try {
                UserDAO userDAO = new UserDAO();
                userDAO.updateUserStatus(userId, newStatus, 1); // Giả sử Admin có user_id = 1
                response.sendRedirect("/ViewUsersServlet");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                response.sendRedirect("/ViewUsersServlet?error=Cannot update user status.");
            }
        } else {
            response.sendRedirect("/ViewUsersServlet?error=Invalid parameters.");
        }
    }
}
