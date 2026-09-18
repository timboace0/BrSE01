package bussiness.model;

import java.math.BigDecimal;

public class OrderDetail {

    private int id;
    private int productId;
    private int orderId;
    private int quantity;
    private BigDecimal priceSell;

    public OrderDetail() {
    }

    public OrderDetail(int id, int productId, int orderId, int quantity, BigDecimal priceSell) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.priceSell = priceSell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(BigDecimal priceSell) {
        this.priceSell = priceSell;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %-5d | Product ID: %-10d | Order ID: %-10d | Quantity: %-5d | Price: %12.2f",
                id,
                productId,
                orderId,
                quantity,
                priceSell
        );
    }
}