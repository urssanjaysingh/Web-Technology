package MyGetServlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "MyGetServlet", urlPatterns = {"/get"})
public class MyGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>GET Request Handling</title></head>");
            out.println("<body>");
            out.println("<h1>Handling GET Request</h1>");
            out.println("<p>Hello, this is a GET request!</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
