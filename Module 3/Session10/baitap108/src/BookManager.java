import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookManager {
    private Set<Book> books = new HashSet<>();

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public List<Book> filterByYear(int year) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }

        return result;
    }

    public void sortByTitle(List<Book> books) {
        Collections.sort(books, (book1, book2) ->
                book1.getTitle().compareToIgnoreCase(book2.getTitle()));
    }

    public void display(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Không có sách phù hợp!");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayAll() {
        if (books.isEmpty()) {
            System.out.println("Bộ sưu tập sách đang trống!");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }
}