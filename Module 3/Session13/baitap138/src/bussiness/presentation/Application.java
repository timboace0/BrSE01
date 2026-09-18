package presentation;

import bussiness.service.OrderService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("""
                    
                    ==========================================
                       SHOP ORDER MANAGEMENT SYSTEM
                    ==========================================
                    1. Thêm sản phẩm
                    2. Cập nhật thông tin khách hàng
                    3. Tạo đơn hàng mới
                    4. Hiển thị danh sách đơn hàng
                    5. Tìm kiếm đơn hàng theo khách hàng
                    0. Thoát
                    ==========================================
                    """);

            System.out.print("Mời bạn chọn chức năng: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    OrderService.addProduct(scanner);
                    break;

                case "2":
                    OrderService.updateCustomer(scanner);
                    break;

                case "3":
                    OrderService.createOrder(scanner);
                    break;

                case "4":
                    OrderService.listAllOrders();
                    break;

                case "5":
                    OrderService.getOrdersByCustomer(scanner);
                    break;

                case "0":
                    System.out.println("Đã thoát chương trình!");
                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "Lựa chọn không hợp lệ!"
                    );
            }

        } while (true);
    }
}