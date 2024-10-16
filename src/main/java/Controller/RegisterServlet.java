package Controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.UUID;

import DAO.EmailUtility;
import DAO.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import DAO.UserDAO;
import Model.User;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("full_name");
        String userName = request.getParameter("user_name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try {
            UserDAO userDAO = new UserDAO();

            // Kiểm tra xem email đã tồn tại chưa
            if (userDAO.checkEmailExists(email)) {
                request.setAttribute("error", "Email đã tồn tại. Vui lòng sử dụng email khác.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/register.jsp");
                dispatcher.forward(request, response);
                return; // Dừng tiến trình nếu email đã tồn tại
            }

            // Nếu email không tồn tại, tiếp tục quá trình đăng ký
            String hashedPassword = PasswordUtil.hashPassword(password);

            User user = new User();
            user.setFull_name(fullName);
            user.setUser_name(userName);
            user.setEmail(email);
            user.setMobile(mobile);
            user.setPassword(hashedPassword);
            user.setStatus("unverified"); // Người dùng chưa được xác thực
            user.setNote("");
            user.setCreated_at(new Timestamp(System.currentTimeMillis()));
            user.setCreated_by_id(1);
            user.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            user.setUpdated_by_id(1);

            int roleId = userDAO.getRoleSettingIdByNameAndType(role, "user_role");
            user.setRole_setting_id(roleId);

            // Tạo mã OTP ngẫu nhiên
            String otpCode = String.format("%06d", new SecureRandom().nextInt(999999));
            user.setOtp(otpCode);

            // Thêm người dùng vào cơ sở dữ liệu
            userDAO.addUser(user);

            // Lưu OTP và email vào session để xác thực
            HttpSession session = request.getSession();
            session.setAttribute("otpCode", otpCode);
            session.setAttribute("userEmail", email);

            // Gửi OTP tới email người dùng
            sendOTPEmail(email, otpCode);

            // Chuyển hướng tới trang xác thực OTP
            response.sendRedirect(request.getContextPath() + "/Views/otp_verification.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Registration failed. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/register.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Gửi email chứa mã OTP
    private void sendOTPEmail(String recipientEmail, String otpCode) throws Exception {
        String subject = "OTP Verification - Project Management System";
        String content = "<p>Your OTP code is: <strong>" + otpCode + "</strong></p>";
        EmailUtility.sendEmail(recipientEmail, subject, content);
    }
}
