import java.sql.*;

public class TransactionManagementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String username = "root";
        String password = "pass";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Disable auto-commit mode
            connection.setAutoCommit(false);

            try {
                // Perform database operations within the transaction
                // Insert employee record
                String insertQuery = "INSERT INTO employees (employeeNumber, firstName, lastName) " +
                        "VALUES (?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setInt(1, 101);
                insertStatement.setString(2, "John");
                insertStatement.setString(3, "Doe");
                insertStatement.executeUpdate();

                // Update employee record
                String updateQuery = "UPDATE employees SET lastName = ? WHERE employeeNumber = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, "Smith");
                updateStatement.setInt(2, 101);
                updateStatement.executeUpdate();

                // Delete employee record
                String deleteQuery = "DELETE FROM employees WHERE employeeNumber = ?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.setInt(1, 101);
                deleteStatement.executeUpdate();

                // Commit the transaction
                connection.commit();

                System.out.println("Transaction completed successfully.");
            } catch (SQLException e) {
                // Rollback the transaction in case of an exception
                connection.rollback();
                System.out.println("Transaction rolled back due to an error: " + e.getMessage());
            }

            // Close the resources
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
