import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String username = "root";
        String password = "pass";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            String query = "SELECT employeeNumber, firstName, lastName, jobTitle FROM employees";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int employeeNumber = resultSet.getInt("employeeNumber");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String jobTitle = resultSet.getString("jobTitle");

                // Process the retrieved data
                System.out.println("Employee Number: " + employeeNumber);
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Job Title: " + jobTitle);
                System.out.println("--------------------------");
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
