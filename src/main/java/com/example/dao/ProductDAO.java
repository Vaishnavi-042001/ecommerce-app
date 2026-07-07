package com.example.dao;

import com.example.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop", "High-performance laptop", 999.99, "laptop.jpg"));
        products.add(new Product(2, "Smartphone", "Latest model smartphone", 699.99, "phone.jpg"));
        products.add(new Product(3, "Headphones", "Noise-cancelling headphones", 199.99, "headphones.jpg"));
        products.add(new Product(4, "Tablet", "10-inch tablet", 399.99, "tablet.jpg"));
    }

    public static List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public static Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
