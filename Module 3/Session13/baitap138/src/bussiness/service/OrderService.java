package bussiness.service;

import bussiness.dao.IOrderDao;
import bussiness.dao.OrderDaoImpl;
import bussiness.model.Customer;
import bussiness.model.Order;
import bussiness.model.Product;
import utils.InputData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    static IOrderDao iOrderDao = new OrderDaoImpl();

    public static void addProduct(Scanner scanner) {

        String name = InputData.getString(
                scanner,
                "Mời nhập tên sản phẩm: "
        );

        BigDecimal price = getPrice(scanner);

        Product product = new Product(name, price);

        boolean result = iOrderDao.addProduct(product);

        if (result) {
            System.out.println("Thêm sản phẩm thành công!");
        } else {
            System.out.println("Sản phẩm đã tồn tại!");
        }
    }

    public static void updateCustomer(Scanner scanner) {

        int customerId = InputData.getInt(
                scanner,
                "Mời nhập ID khách hàng: "
        );

        String name = InputData.getString(
                scanner,
                "Mời nhập tên khách hàng mới: "
        );

        String email = InputData.getString(
                scanner,
                "Mời nhập email mới: "
        );

        Customer customer = new Customer(name, email);

        boolean result =
                iOrderDao.updateCustomer(customerId, customer);

        if (result) {
            System.out.println("Cập nhật khách hàng thành công!");
        } else {
            System.out.println("Không tìm thấy khách hàng!");
        }
    }

    public static void createOrder(Scanner scanner) {

        int customerId = InputData.getInt(
                scanner,
                "Mời nhập ID khách hàng: "
        );

        int productId = InputData.getInt(
                scanner,
                "Mời nhập ID sản phẩm: "
        );

        int quantity = getQuantity(scanner);

        boolean result =
                iOrderDao.createOrder(
                        customerId,
                        productId,
                        quantity
                );

        if (result) {
            System.out.println("Tạo đơn hàng thành công!");
        } else {
            System.out.println(
                    "Không thể tạo đơn hàng. Kiểm tra Customer ID, Product ID hoặc số lượng!"
            );
        }
    }

    public static void listAllOrders() {

        List<Order> orders =
                iOrderDao.listAllOrders();

        if (orders.isEmpty()) {
            System.out.println("Chưa có đơn hàng nào!");
            return;
        }

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void getOrdersByCustomer(Scanner scanner) {

        int customerId = InputData.getInt(
                scanner,
                "Mời nhập ID khách hàng: "
        );

        List<Order> orders =
                iOrderDao.getOrdersByCustomer(customerId);

        if (orders.isEmpty()) {
            System.out.println(
                    "Không tìm thấy đơn hàng của khách hàng này!"
            );
            return;
        }

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private static BigDecimal getPrice(Scanner scanner) {

        while (true) {

            String input = InputData.getString(
                    scanner,
                    "Mời nhập giá sản phẩm: "
            );

            try {
                BigDecimal price =
                        new BigDecimal(input);

                if (price.compareTo(BigDecimal.ZERO) > 0) {
                    return price;
                }

                System.out.println(
                        "Giá sản phẩm phải lớn hơn 0!"
                );

            } catch (NumberFormatException e) {
                System.out.println(
                        "Giá sản phẩm không hợp lệ!"
                );
            }
        }
    }

    private static int getQuantity(Scanner scanner) {

        while (true) {

            int quantity = InputData.getInt(
                    scanner,
                    "Mời nhập số lượng: "
            );

            if (quantity > 0) {
                return quantity;
            }

            System.out.println(
                    "Số lượng phải lớn hơn 0!"
            );
        }
    }
}