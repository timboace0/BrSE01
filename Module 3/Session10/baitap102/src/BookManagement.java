import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookManagement {
    static Map<Integer, Book> bookMap = new HashMap<>();
    public static int currentBookMapSize = 1;
    static String bookName;
    static String author;
    static int year;
    public static void addBook(Scanner scanner){
        do {
                System.out.print("Nhập tên sách: ");
                bookName = scanner.nextLine();
                if (bookName.isEmpty()){
                    System.out.println("Tên sách không được để trống!");
                }
        } while(bookName.isEmpty());

        do {
            System.out.print("Nhập tác giả: ");
            author = scanner.nextLine();
            if (author.isEmpty()){
                System.out.println("Tên sách không được để trống!");
            }
        } while(author.isEmpty());

        boolean validYear = false;

        do {
            try {
                System.out.print("Nhập năm xuất bản: ");
                String yearInput = scanner.nextLine();
                if(yearInput.isEmpty()){
                    System.out.println("Vui lòng ko để trống!");
                } else {
                    year = Integer.parseInt(yearInput);
                    validYear = true;
                }
            } catch (NumberFormatException e){
                System.out.print("Vui lòng nhập số!");
            }

        } while(!validYear);

        Book book = new Book(bookName,author,year);
        bookMap.put(currentBookMapSize,book);
        currentBookMapSize++;
        System.out.println("Thêm sách mới thành công!");
    }

    public static void findBook(Scanner scanner) {
        boolean flag = false;
        System.out.print("Nhập tên sách để tìm kiếm: ");
        String searchValue = scanner.nextLine().trim();

        if(searchValue.equals("")){
            System.out.println("Vui lòng nhập thông tin");
            return;
        }
        for (Book book : bookMap.values()) {
            if (book.getBookName().toLowerCase().contains(searchValue.toLowerCase())) {
                System.out.printf("Tên Sách: %-10s | Tên tác giả: %-5s | Năm xuất bản: %-5d%n", book.getBookName(), book.getAuthor(), book.getPublishYear());
                flag = true;
            }
        }


        if (!flag) {
            System.out.println("Không thấy sách cần tìm!");
        }

    }

    public static void displayAllBook(){
        for (Book book : bookMap.values()){
            System.out.printf("Tên Sách: %-10s | Tên tác giả: %-5s | Năm xuất bản: %-5d%n", book.getBookName(), book.getAuthor(), book.getPublishYear());
        }
    }

}
