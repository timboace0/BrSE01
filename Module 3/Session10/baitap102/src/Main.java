import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int choice;

      do {
          System.out.println("""
                  *********************MENU QUẢN LÝ SÁCH*************************
                  1. Thêm sách
                  2. Tìm kiếm sách
                  3. Hiển thị danh sách sách
                  4. Thoát
                  """);
          System.out.print("Lựa chọn của bạn: ");
          choice = Integer.parseInt(scanner.nextLine());
          switch (choice){
              case 1: {
                  BookManagement.addBook(scanner);
                  break;
              }
              case 2: {
                  BookManagement.findBook(scanner);
                  break;
              }
              case 3: {
                  BookManagement.displayAllBook();
                  break;
              }
              case 4: {
                  System.out.println("Bạn đã thoát chương trình");
                  System.exit(0);
                  break;
              }
              default:
                  System.out.println("Lựa chọn không hợp lệ!");
          }
      } while(true);
    }
}