package Controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.*;
import Model.*;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    // Gửi OTP qua email
    private void sendOTPEmail(String recipientEmail, String otp) throws Exception {
        String subject = "Your OTP Code - Project Management System";
        String content = "<p>Dear User,</p>"
                + "<p>Your OTP code is: <strong>" + otp + "</strong></p>"
                + "<p>Please enter this code to complete your login.</p>";

        EmailUtility.sendEmail(recipientEmail, subject, content);
    }

    // Tạo OTP ngẫu nhiên 6 chữ số
    private String generateOTP() {
        Random rnd = new SecureRandom();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    UserDAO dao = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Mã hóa mật khẩu
        String hashedPassword = PasswordUtil.hashPassword(password);

        try {
            User user = UserDAO.checkLogin(email, hashedPassword);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("password", password);

                // Kiểm tra trạng thái tài khoản
                if (user.getStatus().equals("active")) {
                    // Chuyển hướng tới dashboard tương ứng với vai trò người dùng
                    String role = dao.getRoleNameBySettingId(user.getRole_setting_id());
                    switch (role) {
                        case "Admin":
                            response.sendRedirect(request.getContextPath() + "/Views/dashboard_admin.jsp");
                            break;
                        case "Manager":
                            response.sendRedirect(request.getContextPath() + "/Views/dashboard_manager.jsp");
                            break;
                        case "Project Leader":
                            response.sendRedirect(request.getContextPath() + "/Views/dashboard_project_leader.jsp");
                            break;
                        case "Project Member":
                            response.sendRedirect(request.getContextPath() + "/Views/dashboard_project_member.jsp");
                            break;
                        default:
                            // Nếu role không xác định, mặc định chuyển tới guest dashboard
                            response.sendRedirect(request.getContextPath() + "/Views/dashboard_guest.jsp");
                            break;
                    }
                } else {
                    // Nếu tài khoản chưa được xác thực, gửi mã OTP qua email
                    String otp = generateOTP();
                    session.setAttribute("OTP", otp);
                    session.setAttribute("userEmail", email);
                    sendOTPEmail(email, otp);
                    response.sendRedirect(request.getContextPath() + "/Views/otp_verification.jsp");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
