package bussiness.model;

public class Product {
    private int id;
    private String productName;
    private int stock;

    public Product() {
    }

    public Product(int id, String productName, int stock) {
        this.id = id;
        this.productName = productName;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", stock=" + stock +
                '}';
    }
}