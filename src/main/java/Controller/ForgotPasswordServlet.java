package Controller;

import DAO.EmailUtility;
import DAO.UserDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.SQLException;

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/forgotPassword"})
public class ForgotPasswordServlet extends HttpServlet {

    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/forgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        UserDAO userDAO = new UserDAO();

        try {
            User user = userDAO.getUserByEmail(email);
            if (user == null) {
                request.setAttribute("error", "Email này chưa được đăng ký.");
                request.getRequestDispatcher("/jsp/forgotPassword.jsp").forward(request, response);
                return;
            }

            String otp = generateOTP();
            userDAO.updateUserOtp(email, otp);

            String subject = "Đặt Lại Mật Khẩu - Hệ thống Quản lý Dự án";
            String content = "Mã OTP để đặt lại mật khẩu của bạn là: " + otp + "\n\nNếu bạn không yêu cầu đặt lại mật khẩu, vui lòng bỏ qua email này.";
            EmailUtility.sendEmail(email, subject, content);

            HttpSession session = request.getSession();
            session.setAttribute("forgotPasswordEmail", email);

            response.sendRedirect(request.getContextPath() + "/verifyForgotPasswordOtp");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Quá trình xử lý gặp lỗi. Vui lòng thử lại sau.");
            request.getRequestDispatcher("/jsp/forgotPassword.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Gửi email thất bại. Vui lòng kiểm tra cấu hình email.");
            request.getRequestDispatcher("/jsp/forgotPassword.jsp").forward(request, response);
        }
    }
}
