public class BookManager implements IBookManager {
    Book[] books = new Book[100];

    @Override
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                System.out.println("Đã thêm sách: " + book.getDetails());
                return;
            }
        }

        System.out.println("Danh sách sách đã đầy.");
    }

    @Override
    public void removeBook(String isbn) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getIsbn().equals(isbn)) {
                books[i] = null;
                System.out.println("Đã xóa sách với ISBN: " + isbn);
                return;
            }
        }

        System.out.println("Không tìm thấy sách với ISBN: " + isbn);
    }

    @Override
    public void displayBooks() {
        System.out.println("Danh sách sách:");

        for (Book book : books) {
            if (book != null) {
                System.out.println(book.getDetails());
            }
        }
    }
}
