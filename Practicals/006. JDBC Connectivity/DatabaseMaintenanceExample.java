import java.sql.*;

public class DatabaseMaintenanceExample {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USER = "root";
    static final String PASS = "pass";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Example queries
            String createTableQuery = "CREATE TABLE customers (id INT, name VARCHAR(50))";
            String insertDataQuery = "INSERT INTO customers (id, name) VALUES (1, 'John Doe')";
            String updateDataQuery = "UPDATE customers SET name = 'Jane Smith' WHERE id = 1";
            String deleteDataQuery = "DELETE FROM customers WHERE id = 1";

            // Execute queries
            stmt.executeUpdate(createTableQuery);
            stmt.executeUpdate(insertDataQuery);
            stmt.executeUpdate(updateDataQuery);
            stmt.executeUpdate(deleteDataQuery);

            System.out.println("-------------------------------------------------------");
            System.out.println("Database maintenance operations completed successfully.");

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
