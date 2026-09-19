package presentation;

import bussiness.model.Product;
import bussiness.service.OrderManager;
import bussiness.service.ProductManager;
import utils.InputData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductManager<Product> productManager = new ProductManager<>();
        OrderManager orderManager = new OrderManager();

        do {
            System.out.println("""
                    
                    ========== QUẢN LÝ SẢN PHẨM & ĐƠN HÀNG ==========
                    1. Hiển thị danh sách sản phẩm
                    2. Thêm sản phẩm
                    3. Xóa sản phẩm
                    4. Tạo đơn hàng
                    5. Thêm sản phẩm vào đơn hàng
                    6. Hiển thị danh sách đơn hàng
                    7. Tính tổng tiền đơn hàng
                    8. Hiển thị đơn hàng theo mã tăng dần
                    9. Thoát
                    ================================================
                    """);

            int choice = InputData.getInt(scanner, "Nhập lựa chọn của bạn: ");

            switch (choice) {
                case 1:
                    productManager.displayProducts();
                    break;

                case 2:
                    productManager.addProduct(scanner);
                    break;

                case 3:
                    productManager.removeProduct(scanner);
                    break;

                case 4:
                    orderManager.createOrder(scanner);
                    break;

                case 5:
                    orderManager.addProductToOrder(scanner, productManager);
                    break;

                case 6:
                    orderManager.displayOrders();
                    break;

                case 7:
                    orderManager.calculateOrderTotal(scanner);
                    break;

                case 8:
                    orderManager.displayOrdersSorted();
                    break;

                case 9:
                    System.out.println("Bạn đã thoát chương trình!");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}