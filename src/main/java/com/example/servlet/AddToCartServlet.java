package com.example.servlet;

import com.example.dao.ProductDAO;
import com.example.model.Product;
import com.example.util.SessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (!SessionUtils.isLoggedIn(req.getSession())) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String productIdStr = req.getParameter("id");
        if (productIdStr != null) {
            try {
                int id = Integer.parseInt(productIdStr);
                Product product = ProductDAO.getProductById(id);
                if (product != null) {
                    var cart = SessionUtils.getCart(req.getSession());
                    cart.add(product);  // in real app, handle quantity
                }
            } catch (NumberFormatException ignored) {}
        }
        // Redirect back to catalog (or to cart if preferred)
        resp.sendRedirect(req.getContextPath() + "/catalog");
    }
}
