package Controller;

import DAO.EmailUtility;
import DAO.PasswordUtility;
import DAO.UserDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    // Phương thức tạo mã OTP ngẫu nhiên
    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000); // Tạo OTP 6 chữ số
        return String.valueOf(otp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển tiếp đến trang đăng ký
        request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy dữ liệu từ form đăng ký
        String fullName = request.getParameter("fullName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Mã hóa mật khẩu
        String hashedPassword = PasswordUtility.hashPassword(password);

        // Tạo mã OTP
        String otp = generateOTP();

        // Thời gian hiện tại
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        // Tạo đối tượng User
        User user = new User();
        user.setFull_name(fullName);
        user.setUser_name(userName);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setPassword(hashedPassword);
        UserDAO userDAO = new UserDAO();
        try {
            int roleSettingId = userDAO.getRoleSettingIdByName(role);
            user.setRole_setting_id(roleSettingId);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi lấy vai trò người dùng.");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
            return;
        }
        user.setStatus("unverified"); // Trạng thái chưa xác thực
        user.setCreated_at(currentTimestamp);
        user.setOtp(otp); // Thiết lập OTP

        // Lưu người dùng vào database
        try {
            userDAO.addUser(user);

            // Gửi email chứa mã OTP
            String subject = "Xác Thực OTP";
            String content = "Mã OTP của bạn là: " + otp;
            EmailUtility.sendEmail(email, subject, content);

            // Lưu email vào session để dùng trong xác thực OTP
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            // Chuyển đến trang nhập OTP
            response.sendRedirect("otpVerification");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Đăng ký thất bại do lỗi server.");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Gửi email thất bại.");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        }
    }
}
