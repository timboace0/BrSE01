package bussiness.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {

    private int id;
    private int customerId;
    private String customerName;
    private LocalDate orderDate;
    private BigDecimal totalAmount;

    public Order() {
    }

    public Order(int id, int customerId, LocalDate orderDate, BigDecimal totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public Order(int id, String customerName, LocalDate orderDate, BigDecimal totalAmount) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return String.format(
                "Order ID: %-5d | Customer: %-25s | Date: %-12s | Total: %12.2f",
                id,
                customerName,
                orderDate,
                totalAmount
        );
    }
}