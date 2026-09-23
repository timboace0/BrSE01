package presentation;

import bussiness.service.ProductManager;
import utils.InputData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    ********************PRODUCT MANAGEMENT****************  
                    1. Danh sách sản phẩm
                    2. Thêm mới sản phẩm
                    3. Cập nhật sản phẩm
                    4. Xóa sản phẩm
                    5. Tìm kiếm sản phẩm theo ID sản phẩm
                    6. Tìm kiếm sản phẩm theo tên sản phẩm
                    7. Sắp xếp sản phẩm theo giá tăng dần
                    8. Thống kê số lượng sản phẩm theo danh mục
                    9. Thoát
                    """);
            choice = InputData.getInt(scanner, "Nhập lựa chọn của bạn: ");
            switch (choice){
                case 1: {
                    ProductManager.displayAllProduct();
                    break;
                }
                case 2: {
                    ProductManager.addProduct(scanner);
                    break;
                }
                case 3: {
                    ProductManager.updateProduct(scanner);
                    break;
                }
                case 4: {
                    ProductManager.deleteProduct(scanner);
                    break;
                }
                case 5: {
                    ProductManager.findProductById(scanner);
                    break;
                }
                case 6: {
                    ProductManager.findProductByName(scanner);
                    break;
                }
                case 7: {
                    ProductManager.displaySortedProduct();
                    break;
                }
                case 8: {
                    ProductManager.statisticCatalog();
                    break;
                }
                case 9: {
                    System.out.println("Bạn đã thoát chương trình!");
                    System.exit(0);
                    break;
                }
            }
        } while(true);
    }
}