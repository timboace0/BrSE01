package bussiness.dao;

import java.math.BigDecimal;

public interface IOrderDao {
    void placeOrder(int customerId, BigDecimal totalAmount, int productId, int quantity);
}