import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookManager bookManager = new BookManager();

        int choice;

        do {
            System.out.println("""
                    Chọn chức năng:
                    1. Thêm sách
                    2. Hiển thị sách
                    3. Xóa sách
                    4. Thoát
                    """);

            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: {
                    System.out.print("Nhập tiêu đề: ");
                    String title = scanner.nextLine();

                    System.out.print("Nhập tác giả: ");
                    String author = scanner.nextLine();

                    System.out.print("Nhập ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Nhập năm xuất bản: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    Book book = new Book(title, author, isbn, year);

                    bookManager.addBook(book);
                    break;
                }

                case 2: {
                    bookManager.displayBooks();
                    break;
                }

                case 3: {
                    System.out.print("Nhập ISBN sách cần xóa: ");
                    String isbn = scanner.nextLine();

                    bookManager.removeBook(isbn);
                    break;
                }

                case 4: {
                    System.out.println("Bạn đã thoát chương trình.");
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }

        } while (true);
    }
}