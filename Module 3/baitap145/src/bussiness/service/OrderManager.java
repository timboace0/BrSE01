package bussiness.service;

import bussiness.dao.IOrderDao;
import bussiness.dao.OrderDaoImpl;

import java.math.BigDecimal;

public class OrderManager {

    private IOrderDao orderDao = new OrderDaoImpl();

    public void placeOrder(int customerId, BigDecimal totalAmount, int productId, int quantity) {
        orderDao.placeOrder(customerId, totalAmount, productId, quantity);
    }
}