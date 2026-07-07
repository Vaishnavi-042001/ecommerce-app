package com.example.servlet;

import com.example.dao.ProductDAO;
import com.example.util.SessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (!SessionUtils.isLoggedIn(req.getSession())) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        req.setAttribute("products", ProductDAO.getAllProducts());
        req.getRequestDispatcher("/catalog.jsp").forward(req, resp);
    }
}
