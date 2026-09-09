package bussiness;

import model.Categories;
import model.Product;

import java.util.Scanner;

import static model.Categories.inputData;

public class CategoryService {
    Scanner scanner = new Scanner(System.in);
    public static Categories[] categories = new Categories[100];
    public static int currentCategorySize = 0;

    public static void addCategory(Scanner scanner){
        System.out.print("Nhập số lượng danh mục muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Đang tạo danh mục thứ: " +i);
            inputData(scanner,categories,currentCategorySize);
            currentCategorySize++;
        }
        System.out.printf("Đã tạo %d danh mục mới thành công! \n", n);
    }

    public static void displayCategory(){
        if (currentCategorySize == 0){
            System.out.println("Chưa có danh mục nào trong danh sách");
            return;
        }
        for (int i = 0; i < currentCategorySize; i++) {
            categories[i].displayData();
        }
    }

    public static int isIdCategoryExist(int id){
        for (int i = 0; i < currentCategorySize; i++) {
            if (categories[i].getCatalogId() == id){
                return i;
            }
        }
        return -1;
    }

    public static void updateCategory(Scanner scanner){
        displayCategory();
        System.out.print("Nhập ID danh mục cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = isIdCategoryExist(id);
        if(index == -1){
            System.out.println("Không tìm thấy ID danh mục");
        } else {
            Categories category = categories[index];

            String name;

            while (true) {
                System.out.print("Mời nhập tên danh mục mới: ");
                name = scanner.nextLine().trim();

                if (name.length() > 50) {
                    System.out.println("Tên danh mục không vượt quá 50 ký tự");
                    continue;
                }

                boolean isExist = false;

                for (int i = 0; i < currentCategorySize; i++) {
                    if (i != index &&
                            categories[i].getCatalogName().equalsIgnoreCase(name)) {

                        isExist = true;
                        break;
                    }
                }

                if (isExist) {
                    System.out.println("Danh mục đã tồn tại");
                    continue;
                }

                break;
            }

            System.out.print("Mời nhập mô tả danh mục mới: ");
            String description = scanner.nextLine();

            boolean status;

            while (true) {
                System.out.print("Mời nhập trạng thái danh mục mới (true/false): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("true")) {
                    status = true;
                    break;
                } else if (input.equalsIgnoreCase("false")) {
                    status = false;
                    break;
                } else {
                    System.out.println("Chỉ được nhập true hoặc false!");
                }
            }

            category.setCatalogName(name);
            category.setDescriptions(description);
            category.setCatalogStatus(status);
            System.out.println("Cập nhật danh mục thành công");
        }
    }

    public static void deleteCategory(Scanner scanner){
        displayCategory();

        System.out.print("Nhập ID danh mục cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        int index = isIdCategoryExist(id);

        if(index == -1){
            System.out.println("Không tìm thấy ID danh mục");
        } else {

            boolean hasProduct = false;

            for (int i = 0; i < ProductService.currentProductSize; i++) {
                if (ProductService.products[i].getCatalogId() == id) {
                    hasProduct = true;
                    break;
                }
            }

            if (hasProduct) {
                System.out.println("Không thể xóa danh mục vì danh mục đang có sản phẩm!");
            } else {

                for (int i = index; i < currentCategorySize - 1; i++) {
                    categories[i] = categories[i + 1];
                }

                categories[currentCategorySize - 1] = null;
                currentCategorySize--;

                System.out.println("Xóa danh mục thành công");
            }
        }
    }

    public static void updateStatusCategory(Scanner scanner){
        displayCategory();
        System.out.print("Nhập ID danh mục cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = isIdCategoryExist(id);
        if(index == -1){
            System.out.println("Không tìm thấy ID danh mục");
        } else {
            System.out.println("Trạng thái danh mục hiện tại: "+ categories[index].isCatalogStatus());
            boolean newStatus;

            while (true) {
                System.out.print("Nhập trạng thái danh mục mới (true/false): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("true")) {
                    newStatus = true;
                    break;
                } else if (input.equalsIgnoreCase("false")) {
                    newStatus = false;
                    break;
                } else {
                    System.out.println("Chỉ được nhập true hoặc false!");
                }
            }
            categories[index].setCatalogStatus(newStatus);
            System.out.println("Cập nhật trạng thái danh mục thành công");
        }
    }


}
