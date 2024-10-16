package Controller;

import DAO.UserDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OTPVerificationServlet", urlPatterns = {"/otpVerification"})
public class OTPVerificationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển tiếp đến trang nhập OTP
        request.getRequestDispatcher("/jsp/otpVerification.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enteredOtp = request.getParameter("otp");

        // Lấy email từ session
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        if (email == null) {
            // Không có email trong session, chuyển về trang đăng ký
            response.sendRedirect("register");
            return;
        }

        UserDAO userDAO = new UserDAO();
        try {
            // Lấy thông tin người dùng theo email
            User user = userDAO.getUserByEmail(email);
            if (user != null && user.getOtp().equals(enteredOtp)) {
                // OTP đúng, cập nhật trạng thái và xóa OTP
                user.setStatus("active");
                user.setOtp(null);
                userDAO.updateUserStatusAndOtp(user);

                // Đăng nhập tự động cho người dùng
                session.setAttribute("user", user);

                // Lấy tên vai trò từ role_setting_id
                String roleName = userDAO.getRoleNameById(user.getRole_setting_id());

                // Chuyển hướng đến dashboard tương ứng
                switch (roleName) {
                    case "Admin":
                        response.sendRedirect("adminDashboard.jsp");
                        break;
                    case "Manager":
                        response.sendRedirect("managerDashboard.jsp");
                        break;
                    case "Project Manager":
                        response.sendRedirect("projectManagerDashboard.jsp");
                        break;
                    case "Member":
                        response.sendRedirect("memberDashboard.jsp");
                        break;
                    case "Guest":
                        response.sendRedirect("guestDashboard.jsp");
                        break;
                    default:
                        response.sendRedirect("index.jsp");
                        break;
                }

            } else {
                // OTP sai
                request.setAttribute("error", "OTP không hợp lệ. Vui lòng thử lại.");
                request.getRequestDispatcher("/jsp/otpVerification.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Xác thực thất bại do lỗi server.");
            request.getRequestDispatcher("/jsp/otpVerification.jsp").forward(request, response);
        }
    }
}
