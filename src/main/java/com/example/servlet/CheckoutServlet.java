package com.example.servlet;

import com.example.util.SessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (!SessionUtils.isLoggedIn(req.getSession())) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        req.getRequestDispatcher("/checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (!SessionUtils.isLoggedIn(req.getSession())) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        // Dummy checkout: clear cart and show confirmation
        SessionUtils.clearCart(req.getSession());
        req.setAttribute("message", "Order placed successfully!");
        req.getRequestDispatcher("/checkout.jsp").forward(req, resp);
    }
}
