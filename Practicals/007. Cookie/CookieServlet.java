package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/cookies")
public class CookieServlet extends HttpServlet {
    private static final String COOKIE_NAME = "UserCredentials";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userCredentials = "user1:pwd1,user2:pwd2,user3:pwd3,user4:pwd4";

        try {
            String encodedCredentials = URLEncoder.encode(userCredentials, "UTF-8");

            Cookie cookie = new Cookie(COOKIE_NAME, encodedCredentials);
            cookie.setMaxAge(24 * 60 * 60); // Set cookie expiration time (in seconds)
            response.addCookie(cookie);
            response.getWriter().println("Cookie created successfully!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
