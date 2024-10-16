package Controller;

import DAO.UserDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển tiếp đến trang đăng nhập
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy email và mật khẩu từ form đăng nhập
        String email = request.getParameter("email");
        String password = request.getParameter("password"); // Mật khẩu gốc từ form

        UserDAO userDAO = new UserDAO();

        try {
            // Xác thực người dùng
            User user = userDAO.checkLogin(email, password);

            if (user != null) {
                // Đăng nhập thành công, lưu thông tin vào session và chuyển hướng
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // Lấy tên vai trò từ role_setting_id
                String roleName = userDAO.getRoleNameById(user.getRole_setting_id());

                // Chuyển hướng dựa trên vai trò
                switch (roleName) {
                    case "Admin":
                        response.sendRedirect(request.getContextPath() + "/jsp/adminDashboard.jsp");
                        break;
                    case "Manager":
                        response.sendRedirect(request.getContextPath() + "/jsp/managerDashboard.jsp");
                        break;
                    case "Project Manager":
                        response.sendRedirect(request.getContextPath() + "/jsp/projectManagerDashboard.jsp");
                        break;
                    case "Member":
                        response.sendRedirect(request.getContextPath() + "/jsp/memberDashboard.jsp");
                        break;
                    case "Guest":
                        response.sendRedirect(request.getContextPath() + "/jsp/guestDashboard.jsp");
                        break;
                    default:
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                        break;
                }
            } else {
                // Đăng nhập thất bại
                request.setAttribute("error", "Email hoặc mật khẩu không đúng.");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Đăng nhập thất bại do lỗi server.");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}
