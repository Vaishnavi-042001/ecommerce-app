package com.example.servlet;

import com.example.util.SessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // If already logged in, go to catalog
        if (SessionUtils.isLoggedIn(req.getSession())) {
            resp.sendRedirect(req.getContextPath() + "/catalog");
            return;
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Dummy validation: hardcoded admin/admin
        if ("admin".equals(username) && "admin".equals(password)) {
            SessionUtils.setLoggedInUser(req.getSession(), username);
            resp.sendRedirect(req.getContextPath() + "/catalog");
        } else {
            req.setAttribute("error", "Invalid credentials");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
