package bussiness.model;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %-5d | Product: %-25s | Price: %12.2f",
                id,
                name,
                price
        );
    }
}