package com.example.util;

import jakarta.servlet.http.HttpSession;

public class SessionUtils {
    private static final String USER_KEY = "loggedInUser";
    private static final String CART_KEY = "cart";

    public static void setLoggedInUser(HttpSession session, String username) {
        session.setAttribute(USER_KEY, username);
    }

    public static String getLoggedInUser(HttpSession session) {
        return (String) session.getAttribute(USER_KEY);
    }

    public static boolean isLoggedIn(HttpSession session) {
        return getLoggedInUser(session) != null;
    }

    public static java.util.List<com.example.model.Product> getCart(HttpSession session) {
        java.util.List<com.example.model.Product> cart =
            (java.util.List<com.example.model.Product>) session.getAttribute(CART_KEY);
        if (cart == null) {
            cart = new java.util.ArrayList<>();
            session.setAttribute(CART_KEY, cart);
        }
        return cart;
    }

    public static void clearCart(HttpSession session) {
        session.removeAttribute(CART_KEY);
    }
}
