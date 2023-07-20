package LoginServlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    String username = request.getParameter("username");
    String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("password")) {
            // Login successful
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect(request.getContextPath() + "/welcome.jsp"); // Redirect to the welcome page
        } else {
            // Login failed
            response.sendRedirect(request.getContextPath() + "/login.html"); // Redirect back to the login page
        }
    }
}
