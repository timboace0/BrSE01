import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, count = 0;
        int index = -1;
        boolean flag = false;
        Category[] categoryList = new Category[10];
        do {
            System.out.println("""
                    1. Thêm mới danh mục
                    2. Hiển thị danh sách danh mục
                    3. Cập nhật danh mục
                    4. Xóa danh mục
                    5. Tìm kiếm danh mục theo tên
                    6. Thoát
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:{
                    System.out.print("Nhập ID danh mục: ");
                    String id = scanner.nextLine();

                    System.out.print("Nhập tên danh mục: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập mô tả danh mục: ");
                    String description = scanner.nextLine();

                    Category category = new Category(id,name,description);
                    categoryList[count] = category;
                    count++;
                    System.out.println("Danh mục đã được thêm.");
                    break;
                }
                case 2:{
                    System.out.println("Danh sách danh mục:");
                    for (int i = 0; i < categoryList.length; i++) {
                        if(categoryList[i] != null){
                            System.out.printf("ID: %s, Tên: %s, Giá: %s%n", categoryList[i].getId(), categoryList[i].getName(), categoryList[i].getDescription());
                        } else {
                            System.out.println("Không có danh mục nào!");
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.print("Nhập ID danh mục cần cập nhật: ");
                    String value = scanner.nextLine();
                    for (int i = 0; i < categoryList.length; i++) {
                        if(categoryList[i] != null && Objects.equals(categoryList[i].getId(), value)){
                            flag = true;
                            index = i;
                            break;
                        }
                    }

                    if(flag){
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nhập mô tả mới: ");
                        String newDescription = scanner.nextLine();
                        categoryList[index].setName(newName);
                        categoryList[index].setDescription(newDescription);
                        System.out.println("Danh mục đã được cập nhật.");
                        flag = false;
                        index = -1;
                    } else {
                        System.out.println("Không tìm thấy ID danh mục!");
                    }
                    break;
                }
                case 4:{
                    System.out.print("Nập ID danh mục cần xóa: ");
                    String delId = scanner.nextLine();

                    for (int i = 0; i < categoryList.length; i++) {
                        if(categoryList[i] != null && categoryList[i].getId().equals(delId)){
                            flag = true;
                            index = i;
                            break;
                        }
                    }

                    if(flag){
                        for(int i = index; i < categoryList.length - 1; i++){
                            categoryList[i] = categoryList[i+1];
                        }

                        categoryList[categoryList.length - 1] = null;
                        flag = false;
                        index = -1;
                        System.out.println("Xóa danh mục thành công!");
                    } else {
                        System.out.println("Không tìm thấy danh mục!");
                    }
                    break;
                }
                case 5:{
                    System.out.print("Nhập tên danh mục cần tìm: ");
                    String searchValue = scanner.nextLine();
                    for (int i = 0; i < categoryList.length; i++) {
                        if(categoryList[i] != null && categoryList[i].getName().toLowerCase().contains(searchValue.toLowerCase())){
                            flag = true;
                            index = i;
                        }
                    }
                    if(flag){
                        System.out.printf("ID: %s, Tên: %s, Mô tả: %s%n", categoryList[index].getId(), categoryList[index].getName(), categoryList[index].getDescription());
                        flag = false;
                        index = -1;
                    } else {
                        System.out.println("Không thấy danh mục cần tìm");
                    }
                    break;
                }
                case 6:{
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }
}