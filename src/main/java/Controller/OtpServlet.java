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

import DAO.*;
import Model.*;
import java.sql.*;

/**
 *
 * @author hient
 */
@WebServlet("/OTPServlet")
public class OtpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enteredOTP = request.getParameter("otp");

        HttpSession session = request.getSession(false);
        if(session != null){
            String sessionOTP = (String) session.getAttribute("OTP");
            String userEmail = (String) session.getAttribute("userEmail");

            if(enteredOTP != null && enteredOTP.equals(sessionOTP)){
                try {
                    UserDAO userDAO = new UserDAO();
                    User user = userDAO.getUserByEmail(userEmail);

                    if(user != null){
                        // Lưu thông tin đăng nhập vào session
                        session.setAttribute("loggedInUser", user);
                        // Xóa OTP khỏi session
                        session.removeAttribute("OTP");

                        // Chuyển hướng đến dashboard
                        response.sendRedirect("/DashboardServlet");
                    } else {
                        response.sendRedirect("/login.jsp?error=User not found.");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                    response.sendRedirect("/login.jsp?error=Error during login.");
                }
            } else {
                response.sendRedirect("/otp_verification.jsp?error=Invalid OTP. Please try again.");
            }
        } else {
            response.sendRedirect("/login.jsp?error=Session expired. Please login again.");
        }
    }
}