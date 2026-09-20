package bussiness.dao;

import bussiness.model.OrderDetail;
import bussiness.model.Product;

import java.util.List;

public interface IOrderDao {

    void createOrder(String customerName, List<OrderDetail> orderDetails);

    void updateProductStock(int productId, int quantity);

    List<Product> listProducts();
}