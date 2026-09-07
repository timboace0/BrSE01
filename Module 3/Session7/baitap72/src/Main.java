//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book myBook = new Book();

        myBook.setTitle("Java Programming");
        myBook.setAuthor("John Doe");

        myBook.setPrice(29.99);

        System.out.println("Tiêu đề: " + myBook.getTitle());
        System.out.println("Tác giả: " + myBook.getAuthor());
        System.out.println("Giá: " + myBook.getPrice());

        myBook.setPrice(35.50);
        System.out.println("Giá mới: " + myBook.getPrice());

        myBook.setPrice(-5.00);
    }
}