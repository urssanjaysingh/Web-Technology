package MyPostServlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "MyPostServlet", urlPatterns = {"/post"})
public class MyPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>POST Request Handling</title></head>");
            out.println("<body>");
            out.println("<h1>Handling POST Request</h1>");
            out.println("<p>Hello, " + name + "! This is a POST request.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
