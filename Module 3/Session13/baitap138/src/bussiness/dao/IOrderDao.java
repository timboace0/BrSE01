package bussiness.dao;

import bussiness.model.Customer;
import bussiness.model.Order;
import bussiness.model.Product;

import java.util.List;

public interface IOrderDao {

    boolean addProduct(Product product);

    boolean updateCustomer(int customerId, Customer customer);

    boolean createOrder(int customerId, int productId, int quantity);

    List<Order> listAllOrders();

    List<Order> getOrdersByCustomer(int customerId);
}