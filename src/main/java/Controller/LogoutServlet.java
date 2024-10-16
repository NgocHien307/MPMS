package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hủy session
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        // Chuyển hướng về trang chủ
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
