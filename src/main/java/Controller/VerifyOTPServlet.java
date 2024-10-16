package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import DAO.UserDAO;
import Model.User;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/VerifyOTPServlet")
public class VerifyOTPServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enteredOtp = request.getParameter("otp_code");

        HttpSession session = request.getSession();
        String sessionOtp = (String) session.getAttribute("OTP");
        String userEmail = (String) session.getAttribute("userEmail");

        // Kiểm tra mã OTP
        if (enteredOtp != null && sessionOtp != null && enteredOtp.equals(sessionOtp)) {
            try {
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserByEmail(userEmail);  // Lấy thông tin người dùng

                if (user == null) {
                    throw new Exception("User not found.");
                }

                // Cập nhật trạng thái thành "active"
                user.setStatus("active");
                userDAO.updateUser(user);

                // Xóa OTP khỏi session
                session.removeAttribute("OTP");
                session.removeAttribute("userEmail");

                // Chuyển hướng tới dashboard tương ứng với vai trò người dùng
                String role = userDAO.getRoleNameBySettingId(user.getRole_setting_id());
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

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "OTP verification failed. Please try again.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/otp_verification.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // Nếu OTP không hợp lệ, quay lại trang OTP với thông báo lỗi
            request.setAttribute("error", "Invalid OTP. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/otp_verification.jsp");
            dispatcher.forward(request, response);
        }
    }
}
