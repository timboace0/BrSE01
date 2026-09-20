package bussiness.service;

import bussiness.dao.IOrderDao;
import bussiness.dao.OrderDaoImpl;
import bussiness.model.OrderDetail;
import bussiness.model.Product;

import java.util.List;

public class OrderManager {

    private IOrderDao orderDao = new OrderDaoImpl();

    public void createOrder(
            String customerName,
            List<OrderDetail> orderDetails
    ) {
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Tên khách hàng không được để trống!");
            return;
        }

        if (orderDetails == null || orderDetails.isEmpty()) {
            System.out.println("Đơn hàng phải có ít nhất một sản phẩm!");
            return;
        }

        for (OrderDetail detail : orderDetails) {
            if (detail.getQuantity() <= 0) {
                System.out.println("Số lượng sản phẩm phải lớn hơn 0!");
                return;
            }
        }

        orderDao.createOrder(customerName, orderDetails);
    }

    public void updateProductStock(int productId, int quantity) {
        if (quantity <= 0) {
            System.out.println("Số lượng phải lớn hơn 0!");
            return;
        }

        orderDao.updateProductStock(productId, quantity);
    }

    public void listProducts() {

        List<Product> products = orderDao.listProducts();

        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm!");
            return;
        }

        System.out.println("""
                
                ========== DANH SÁCH SẢN PHẨM ==========
                """);

        for (Product product : products) {
            System.out.println(product);
        }
    }
}