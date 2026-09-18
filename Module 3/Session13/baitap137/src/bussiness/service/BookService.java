package bussiness.service;

import bussiness.dao.BookDaoImpl;
import bussiness.dao.IBookDao;
import bussiness.model.Book;
import utils.InputData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class BookService {

    static IBookDao iBookDao = new BookDaoImpl();

    public static void addBook(Scanner scanner) {

        String title = InputData.getString(
                scanner,
                "Mời nhập tên sách: "
        );

        String author = InputData.getString(
                scanner,
                "Mời nhập tên tác giả: "
        );

        int publishedYear = InputData.getInt(
                scanner,
                "Mời nhập năm xuất bản: "
        );

        BigDecimal price = getPrice(scanner);

        Book book = new Book(
                title,
                author,
                publishedYear,
                price
        );

        boolean result = iBookDao.addBook(book);

        if (result) {
            System.out.println("Thêm sách thành công!");
        } else {
            System.out.println("Sách đã tồn tại!");
        }
    }

    public static void listAllBooks() {
        List<Book> books = iBookDao.listAllBooks();

        if (books.isEmpty()) {
            System.out.println("Danh sách sách đang trống!");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void updateBook(Scanner scanner) {

        listAllBooks();

        int id = InputData.getInt(
                scanner,
                "Mời nhập ID sách cần cập nhật: "
        );

        String title = InputData.getString(
                scanner,
                "Mời nhập tên sách mới: "
        );

        String author = InputData.getString(
                scanner,
                "Mời nhập tên tác giả mới: "
        );

        int publishedYear = InputData.getInt(
                scanner,
                "Mời nhập năm xuất bản mới: "
        );

        BigDecimal price = getPrice(scanner);

        Book book = new Book(
                title,
                author,
                publishedYear,
                price
        );

        boolean result = iBookDao.updateBook(id, book);

        if (result) {
            System.out.println("Cập nhật sách thành công!");
        } else {
            System.out.println("Không tìm thấy sách!");
        }
    }

    public static void deleteBook(Scanner scanner) {

        listAllBooks();

        int id = InputData.getInt(
                scanner,
                "Mời nhập ID sách cần xóa: "
        );

        boolean result = iBookDao.deleteBook(id);

        if (result) {
            System.out.println("Xóa sách thành công!");
        } else {
            System.out.println("Không tìm thấy sách!");
        }
    }

    public static void findBooksByAuthor(Scanner scanner) {

        String author = InputData.getString(
                scanner,
                "Mời nhập tên tác giả cần tìm: "
        );

        List<Book> books =
                iBookDao.findBooksByAuthor(author);

        if (books.isEmpty()) {
            System.out.println("Không tìm thấy sách của tác giả này!");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static BigDecimal getPrice(Scanner scanner) {
        while (true) {
            String input = InputData.getString(
                    scanner,
                    "Mời nhập giá sách: "
            );

            try {
                BigDecimal price = new BigDecimal(input);

                if (price.compareTo(BigDecimal.ZERO) > 0) {
                    return price;
                }

                System.out.println("Giá sách phải lớn hơn 0!");

            } catch (NumberFormatException e) {
                System.out.println("Giá sách phải là số!");
            }
        }
    }
}