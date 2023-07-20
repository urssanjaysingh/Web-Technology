package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final String COOKIE_NAME = "UserCredentials";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        // Retrieve the stored cookie
        Cookie[] cookies = request.getCookies();
        Cookie userCredentials = findCookie(cookies, COOKIE_NAME);

        // Authenticate the login credentials with the values available in the cookie
        if (userCredentials != null) {
            String storedCredentials = URLDecoder.decode(userCredentials.getValue(), "UTF-8");
            String[] credentialsArray = storedCredentials.split(",");

            for (String credentials : credentialsArray) {
                String[] userAndPassword = credentials.split(":");
                String storedUserId = userAndPassword[0].trim();
                String storedPassword = userAndPassword[1].trim();

                if (storedUserId.equals(userId) && storedPassword.equals(password)) {
                    // Authentication successful
                    response.getWriter().println("Login Successful!");
                    return;
                }
            }
        }

        // Authentication failed
        response.getWriter().println("Invalid credentials. Please try again.");
    }


    private Cookie findCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
