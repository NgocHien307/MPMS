package Controller;

import DAO.UserDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ForgotPasswordOtpVerificationServlet", urlPatterns = {"/verifyForgotPasswordOtp"})
public class ForgotPasswordOtpVerificationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/forgotPasswordOtpVerification.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enteredOtp = request.getParameter("otp");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("forgotPasswordEmail");

        if (email == null) {
            response.sendRedirect(request.getContextPath() + "/forgotPassword");
            return;
        }

        UserDAO userDAO = new UserDAO();

        try {
            User user = userDAO.getUserByEmail(email);
            if (user != null && enteredOtp.equals(user.getOtp())) {
                response.sendRedirect(request.getContextPath() + "/forgotPasswordReset");
            } else {
                request.setAttribute("error", "Mã OTP không hợp lệ. Vui lòng thử lại.");
                request.getRequestDispatcher("/jsp/forgotPasswordOtpVerification.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Quá trình xác thực gặp lỗi. Vui lòng thử lại sau.");
            request.getRequestDispatcher("/jsp/forgotPasswordOtpVerification.jsp").forward(request, response);
        }
    }
}
