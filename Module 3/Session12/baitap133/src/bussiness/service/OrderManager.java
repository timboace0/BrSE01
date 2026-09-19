package bussiness.service;

import bussiness.exception.OrderNotFoundException;
import bussiness.exception.ProductNotFoundException;
import bussiness.model.Order;
import bussiness.model.Product;
import utils.InputData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class OrderManager {
    Map<String, Order> orderMap = new LinkedHashMap<>();

    public void createOrder(Scanner scanner) {
        int orderId = InputData.getInt(scanner, "Nhập ID đơn hàng: ");
        String key = String.valueOf(orderId);

        if (orderMap.containsKey(key)) {
            System.out.println("Mã đơn hàng đã tồn tại!");
            return;
        }

        Order order = new Order(orderId);
        orderMap.put(key, order);

        System.out.println("Tạo đơn hàng thành công!");
    }

    public void addProductToOrder(
            Scanner scanner,
            ProductManager<Product> productManager
    ) {
        String orderId = InputData.getString(scanner, "Nhập mã đơn hàng: ");

        try {
            Order order = orderMap.get(orderId);

            if (order == null) {
                throw new OrderNotFoundException("Không tìm thấy đơn hàng!");
            }

            int productId = InputData.getInt(scanner, "Nhập ID sản phẩm: ");

            Product product = productManager.getProductById(productId);

            if (product == null) {
                throw new ProductNotFoundException("Không tìm thấy sản phẩm!");
            }

            order.addProduct(product);

            System.out.println("Thêm sản phẩm vào đơn hàng thành công!");
        } catch (OrderNotFoundException | ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayOrders() {
        if (orderMap.isEmpty()) {
            System.out.println("Chưa có đơn hàng nào!");
            return;
        }

        for (Map.Entry<String, Order> entry : orderMap.entrySet()) {
            System.out.println(entry.getValue());

            for (Product product : entry.getValue().getProducts()) {
                System.out.println("   " + product);
            }
        }
    }

    public void calculateOrderTotal(Scanner scanner) {
        String orderId = InputData.getString(scanner, "Nhập mã đơn hàng: ");

        try {
            Order order = orderMap.get(orderId);

            if (order == null) {
                throw new OrderNotFoundException("Không tìm thấy đơn hàng!");
            }

            System.out.printf("Tổng tiền đơn hàng: %.2f%n", order.calculateTotal());
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayOrdersSorted() {
        if (orderMap.isEmpty()) {
            System.out.println("Chưa có đơn hàng nào!");
            return;
        }

        TreeMap<String, Order> sortedOrders = new TreeMap<>(orderMap);

        for (Map.Entry<String, Order> entry : sortedOrders.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}