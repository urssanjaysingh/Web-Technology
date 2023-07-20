package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "pass";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Execute SELECT query to retrieve user data
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Display retrieved user data
            out.println("<html><body>");
            out.println("<h2>User Details:</h2>");
            out.println("<table border=\"1\"><tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Phone Number</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email_id");
                String phoneNumber = resultSet.getString("phone_number");

                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + password + "</td><td>" + email
                        + "</td><td>" + phoneNumber + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

            // Clean up resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred while processing the request.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone");

        try {
            // Connect to the database
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Execute INSERT query to add new user details
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO users (name, password, email_id, phone_number) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phoneNumber);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                out.println("User details inserted successfully!");
            } else {
                out.println("Failed to insert user details.");
            }

            // Clean up resources
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred while processing the request.");
        }
    }
}
