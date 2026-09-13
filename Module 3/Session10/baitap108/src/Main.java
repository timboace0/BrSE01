import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();

        do {
            System.out.println("""
                    *********************** MENU QUẢN LÝ SÁCH **************************
                    1. Thêm sách
                    2. Hiển thị danh sách sách
                    3. Lọc sách theo năm xuất bản
                    4. Thoát
                    """);

            System.out.print("Lựa chọn của bạn: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {

                case 1: {
                    String id;

                    do {
                        System.out.print("Nhập mã sách: ");
                        id = scanner.nextLine();

                        if (id.trim().isEmpty()) {
                            System.out.println("Mã sách không được để trống!");
                        }

                    } while (id.trim().isEmpty());

                    String title;

                    do {
                        System.out.print("Nhập tên sách: ");
                        title = scanner.nextLine();

                        if (title.trim().isEmpty()) {
                            System.out.println("Tên sách không được để trống!");
                        }

                    } while (title.trim().isEmpty());

                    String author;

                    do {
                        System.out.print("Nhập tác giả: ");
                        author = scanner.nextLine();

                        if (author.trim().isEmpty()) {
                            System.out.println("Tên tác giả không được để trống!");
                        }

                    } while (author.trim().isEmpty());

                    int year;

                    while (true) {
                        try {
                            System.out.print("Nhập năm xuất bản: ");
                            String yearInput = scanner.nextLine();

                            if (yearInput.trim().isEmpty()) {
                                System.out.println("Năm xuất bản không được để trống!");
                            } else {
                                year = Integer.parseInt(yearInput);

                                if (year < 0) {
                                    System.out.println("Năm xuất bản phải >= 0!");
                                } else {
                                    break;
                                }
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Năm xuất bản phải là số!");
                        }
                    }

                    Book book = new Book(id, title, author, year);

                    if (bookManager.addBook(book)) {
                        System.out.println("Thêm sách thành công!");
                    } else {
                        System.out.println("Mã sách đã tồn tại!");
                    }

                    break;
                }

                case 2: {
                    System.out.println("**************** DANH SÁCH SÁCH ****************");
                    bookManager.displayAll();
                    break;
                }

                case 3: {
                    int year;

                    while (true) {
                        try {
                            System.out.print("Nhập năm để lọc sách: ");
                            String yearInput = scanner.nextLine();

                            if (yearInput.trim().isEmpty()) {
                                System.out.println("Năm không được để trống!");
                            } else {
                                year = Integer.parseInt(yearInput);
                                break;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số!");
                        }
                    }

                    List<Book> result = bookManager.filterByYear(year);

                    bookManager.sortByTitle(result);

                    System.out.println("**************** SÁCH XUẤT BẢN SAU NĂM " + year + " ****************");

                    bookManager.display(result);

                    break;
                }

                case 4: {
                    System.out.println("Bạn đã thoát chương trình!");
                    return;
                }

                default: {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }

        } while (true);
    }
}