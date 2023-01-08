package com.function;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private Integer id;
    private String name;
    private String description;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Product> getAllProducts() {
        var products = new ArrayList<Product>();

        var product1 = new Product();
        product1.setId(1);
        product1.setName("Product1");
        product1.setDescription("Description1");

        var product2 = new Product();
        product2.setId(2);
        product2.setName("Product2");
        product2.setDescription("Description2");

        products.add(product1);
        products.add(product2);

        return products;
    }
}
