package presentation;

import bussiness.CategoryService;
import bussiness.ProductService;
import model.Categories;
import model.Product;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    ******************SHOP MENU*******************
                    
                    1. Quản lý danh mục sản phẩm
                    
                    2. Quản lý sản phẩm
                    
                    3. Thoát
                    """);

            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1: {
                    int categoryChoice;

                    do {
                        System.out.println("""
                                ********************CATEGORIES MENU***********
                                
                                1. Nhập thông tin các danh mục
                                
                                2. Hiển thị thông tin các danh mục
                                
                                3. Cập nhật thông tin danh mục
                                
                                4. Xóa danh mục
                                
                                5. Cập nhật trạng thái danh mục
                                
                                6. Thoát
                                """);

                        System.out.print("Lựa chọn của bạn: ");
                        categoryChoice = Integer.parseInt(scanner.nextLine());

                        switch (categoryChoice) {
                            case 1:
                                CategoryService.addCategory(scanner);
                                break;

                            case 2:
                                CategoryService.displayCategory();
                                break;

                            case 3:
                                CategoryService.updateCategory(scanner);
                                break;

                            case 4:
                                CategoryService.deleteCategory(scanner);
                                break;

                            case 5:
                                CategoryService.updateStatusCategory(scanner);
                                break;

                            case 6:
                                System.out.println("Quay lại Shop Menu");
                                break;

                            default:
                                System.out.println("Lựa chọn không hợp lệ");
                        }

                    } while (categoryChoice != 6);

                    break;
                }

                case 2: {
                    int productChoice;

                    do {
                        System.out.println("""
                                *******************PRODUCT MANAGEMENT*****************
                                
                                1. Nhập thông tin các sản phẩm
                                
                                2. Hiển thị thông tin các sản phẩm
                                
                                3. Sắp xếp các sản phẩm theo giá
                                
                                4. Cập nhật thông tin sản phẩm theo mã sản phẩm
                                
                                5. Xóa sản phẩm theo mã sản phẩm
                                
                                6. Tìm kiếm các sản phẩm theo tên sản phẩm
                                
                                7. Tìm kiếm sản phẩm trong khoảng giá a – b
                                
                                8. Thoát
                                """);

                        System.out.print("Lựa chọn của bạn: ");
                        productChoice = Integer.parseInt(scanner.nextLine());

                        switch (productChoice) {
                            case 1:
                                ProductService.addProduct(scanner);
                                break;

                            case 2:
                                 ProductService.displayProduct();
                                break;

                            case 3:
                                 ProductService.sortProduct();
                                break;

                            case 4:
                                 ProductService.updateProduct(scanner);
                                 break;

                            case 5:
                                ProductService.deleteProduct(scanner);
                                break;

                            case 6:
                                 ProductService.searchProductByName(scanner);
                                break;

                            case 7:
                                 ProductService.searchProductByPrice(scanner);
                                break;

                            case 8:
                                System.out.println("Quay lại Shop Menu");
                                break;

                            default:
                                System.out.println("Lựa chọn không hợp lệ");
                        }

                    } while (productChoice != 8);

                    break;
                }

                case 3:
                    System.out.println("Bạn đã thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (choice != 3);
    }
}