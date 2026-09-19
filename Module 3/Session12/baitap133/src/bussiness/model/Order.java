package bussiness.model;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products;

    public Order() {
        products = new LinkedList<>();
    }

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new LinkedList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        return String.format(
                "Order ID: %d | Số sản phẩm: %d | Tổng tiền: %.2f",
                orderId,
                products.size(),
                calculateTotal()
        );
    }
}