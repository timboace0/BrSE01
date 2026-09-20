package presentation;

import bussiness.model.OrderDetail;
import bussiness.service.OrderManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        OrderManager orderManager = new OrderManager();

        do {

            System.out.println("""
                    
                    ========== ORDER MANAGEMENT ==========
                    1. Tạo đơn hàng
                    2. Cập nhật số lượng sản phẩm
                    3. Hiển thị danh sách sản phẩm
                    4. Thoát
                    ======================================
                    """);

            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Nhập số lượng sản phẩm trong đơn: ");
                    int numberOfProducts =
                            Integer.parseInt(scanner.nextLine());

                    List<OrderDetail> orderDetails =
                            new ArrayList<>();

                    for (int i = 0; i < numberOfProducts; i++) {

                        System.out.println(
                                "\nSản phẩm thứ " + (i + 1)
                        );

                        System.out.print("Nhập ID sản phẩm: ");
                        int productId =
                                Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập số lượng: ");
                        int quantity =
                                Integer.parseInt(scanner.nextLine());

                        OrderDetail detail =
                                new OrderDetail(
                                        0,
                                        0,
                                        productId,
                                        quantity
                                );

                        orderDetails.add(detail);
                    }

                    orderManager.createOrder(
                            customerName,
                            orderDetails
                    );

                    break;

                case 2:

                    System.out.print("Nhập ID sản phẩm: ");
                    int productId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập số lượng muốn giảm: ");
                    int quantity =
                            Integer.parseInt(scanner.nextLine());

                    orderManager.updateProductStock(
                            productId,
                            quantity
                    );

                    break;

                case 3:

                    orderManager.listProducts();

                    break;

                case 4:

                    System.out.println("Đã thoát chương trình!");
                    return;

                default:

                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (true);
    }
}