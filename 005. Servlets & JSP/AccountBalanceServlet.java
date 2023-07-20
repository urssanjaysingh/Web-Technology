package AccountBalanceServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AccountBalanceServlet", urlPatterns = {"/AccountBalanceServlet"})
public class AccountBalanceServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/myDatabase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "pass";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");

        double accountBalance = getAccountBalance(accountNumber);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Account Balance</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Account Balance</h1>");
        out.println("<p>Account Number: " + accountNumber + "</p>");
        out.println("<p>Account Balance: $" + accountBalance + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    private double getAccountBalance(String accountNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double accountBalance = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "SELECT account_balance FROM accounts WHERE account_number = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountNumber);
            rs = stmt.executeQuery();

            if (rs.next()) {
                accountBalance = rs.getDouble("account_balance");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return accountBalance;
    }

}
