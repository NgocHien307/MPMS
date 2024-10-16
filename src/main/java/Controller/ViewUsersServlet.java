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
import java.util.*;

/**
 *
 * @author hient
 */
@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO userDAO = new UserDAO();
            List<User> userList = userDAO.getAllUser();

            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/view_users.jsp").forward(request, response);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("/admin_dashboard.jsp?error=Cannot retrieve users.");
        }
    }
}