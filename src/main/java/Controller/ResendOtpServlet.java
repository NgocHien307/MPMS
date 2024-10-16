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
import java.util.Random;

/**
 *
 * @author hient
 */
@WebServlet("/ResendOtpServlet")
public class ResendOtpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect("login.jsp?error=session");
            return;
        }

        int userId = (int) session.getAttribute("user_id");

        try {
            UserDAO dao = new UserDAO();
            User user = dao.getUserById(userId);
            if (user == null) {
                response.sendRedirect("login.jsp?error=invalidUser");
                return;
            }

            // Tạo OTP mới
            String otp = generateOtp();
            dao.updateOtp(userId, otp);

            // Gửi OTP qua email
            String subject = "Mã Xác Thực OTP - Hệ Thống Quản Lý Dự Án";
            String content = "<p>Chào " + user.getFull_name() + ",</p>"
                    + "<p>Dưới đây là mã OTP của bạn để hoàn tất quá trình đăng nhập:</p>"
                    + "<h3>" + otp + "</h3>";
            EmailUtility.sendEmail(user.getEmail(), subject, content);

            // Thông báo đã gửi lại OTP
            response.sendRedirect("otp_verification.jsp?message=resent");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("otp_verification.jsp?error=server");
        }
    }

    // Phương thức tạo OTP ngẫu nhiên 6 chữ số
    private String generateOtp() {
        Random random = new Random();
        int number = 100000 + random.nextInt(900000);
        return String.valueOf(number);
    }
}
