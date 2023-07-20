package BookQueryServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookquery")
public class BookQueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "pass";
            conn = DriverManager.getConnection(url, username, password);

            // Execute book query
            stmt = conn.createStatement();
            String query = "SELECT * FROM books";
            rs = stmt.executeQuery(query);

            // Store book query results in a list
            List<String> books = new ArrayList<>();
            while (rs.next()) {
                String bookTitle = rs.getString("title");
                books.add(bookTitle);
            }

            // Generate HTML response
            out.println("<html>");
            out.println("<head><title>Book Query Results</title></head>");
            out.println("<body>");
            out.println("<h1>Book Query Results</h1>");
            out.println("<ul>");
            for (String book : books) {
                out.println("<li>" + book + "</li>");
            }
            out.println("</ul>");
            out.println("</body></html>");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close JDBC resources
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
