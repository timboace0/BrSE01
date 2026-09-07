import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        CategoryManagement categoryManagement = new CategoryManagement();

        do {
            System.out.println("""
                    Menu:
                    1: Thêm danh mục
                    2: Hiển thị danh mục
                    3: Cập nhật danh mục
                    4: Xóa danh mục
                    5: Thoát
                    """);
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1: {
                    System.out.print("Nhập ID danh mục: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên danh mục: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập mô tả danh mục: ");
                    String des = scanner.nextLine();
                    Category category = new Category(id, name, des);
                    categoryManagement.addCategory(category);
                    break;
                }
                case 2: {
                    System.out.println("Danh sách danh mục: ");
                    Category[] categories = categoryManagement.findAll();
                    for(Category category : categories){
                        System.out.printf("ID: %d, Name: %s, Description: %s%n", category.getId(), category.getName(), category.getDescription());
                    }
                    break;
                }
                case 3: {
                    System.out.print("Nhập ID danh mục cần cập nhật: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập tên danh mục mới: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập mô tả danh mục mới: ");
                    String des = scanner.nextLine();

                    Category updatedCategory = new Category(id, name, des);

                    categoryManagement.updateCategory(updatedCategory);
                    break;
                }
                case 4: {
                    System.out.print("Nhập ID danh mục cần xóa: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    categoryManagement.deleteById(id);
                    break;
                }
                case 5: {
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
            }
        } while (true);
    }

}