import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectivityExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "pass");
            System.out.println("--------------------------");
            System.out.println("Connected to the database!");
            System.out.println("--------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection in a finally block
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
