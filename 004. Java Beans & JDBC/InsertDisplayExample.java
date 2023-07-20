import java.sql.*;

public class InsertDisplayExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String username = "root";
        String password = "pass";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Insert a record using prepared statement
            String insertQuery = "INSERT INTO employees (employeeNumber, lastName, firstName, jobTitle) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

            // Set the parameter values for the insert statement
            insertStatement.setInt(1, 1001);
            insertStatement.setString(2, "Smith");
            insertStatement.setString(3, "John");
            insertStatement.setString(4, "Manager");

            // Execute the insert statement
            int rowsInserted = insertStatement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            // Display records using a simple statement
            String selectQuery = "SELECT employeeNumber, firstName, lastName, jobTitle FROM employees";
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

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
            selectStatement.close();
            insertStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
