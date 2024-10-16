package Controller;

import DAO.PasswordUtility;
import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ForgotPasswordResetServlet", urlPatterns = {"/forgotPasswordReset"})
public class ForgotPasswordResetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/forgotPasswordReset.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("forgotPasswordEmail");

        if (email == null) {
            response.sendRedirect(request.getContextPath() + "/forgotPassword");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("error", "Mật khẩu xác nhận không trùng khớp.");
            request.getRequestDispatcher("/jsp/forgotPasswordReset.jsp").forward(request, response);
            return;
        }

        UserDAO userDAO = new UserDAO();

        try {
            String hashedPassword = PasswordUtility.hashPassword(newPassword);
            userDAO.updateUserPassword(email, hashedPassword);
            session.removeAttribute("forgotPasswordEmail");

            request.setAttribute("message", "Đặt lại mật khẩu thành công. Vui lòng đăng nhập với mật khẩu mới.");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Quá trình đặt lại mật khẩu gặp lỗi. Vui lòng thử lại sau.");
            request.getRequestDispatcher("/jsp/forgotPasswordReset.jsp").forward(request, response);
        }
    }
}
