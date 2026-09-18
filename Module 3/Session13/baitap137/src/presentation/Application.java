package presentation;

import bussiness.service.BookService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("""
                    
                    ==============================
                       LIBRARY MANAGEMENT SYSTEM
                    ==============================
                    1. Thêm sách
                    2. Cập nhật thông tin sách
                    3. Xóa sách
                    4. Tìm kiếm sách theo tác giả
                    5. Hiển thị tất cả sách
                    0. Thoát
                    ==============================
                    """);

            System.out.print("Mời bạn chọn chức năng: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    BookService.addBook(scanner);
                    break;

                case "2":
                    BookService.updateBook(scanner);
                    break;

                case "3":
                    BookService.deleteBook(scanner);
                    break;

                case "4":
                    BookService.findBooksByAuthor(scanner);
                    break;

                case "5":
                    BookService.listAllBooks();
                    break;

                case "0":
                    System.out.println("Đã thoát chương trình!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (true);
    }
}