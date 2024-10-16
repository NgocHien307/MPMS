/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.*;
import Model.*;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hient
 */
@WebServlet("/VerifyEmailServlet")
public class VerifyEmailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        // chúng ta có thể so sánh với mã xác thực từ liên kết
        HttpSession session = request.getSession(false);
        if(session != null){
            String sessionCode = (String) session.getAttribute("verificationCode");
            String userEmail = (String) session.getAttribute("userEmail");

            if(code != null && code.equals(sessionCode)){
                try {
                    UserDAO userDAO = new UserDAO();
                    userDAO.verifyUserEmail(userEmail);
                    response.sendRedirect("email_verified.jsp");
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                    response.sendRedirect("email_verification_failed.jsp");
                }
            } else {
                response.sendRedirect("email_verification_failed.jsp");
            }
        } else {
            response.sendRedirect("email_verification_failed.jsp");
        }
    }
}