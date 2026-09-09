package bussiness;

import model.Product;

import java.util.Scanner;

import static model.Product.inputData;

public class ProductService {
    public static Product[] products = new Product[100];
    public static int currentProductSize = 0;

    public static void addProduct(Scanner scanner){
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Đang tạo sản phẩm thứ: " +i);
            inputData(scanner,products,currentProductSize,CategoryService.categories,CategoryService.currentCategorySize);
            currentProductSize++;
        }
        System.out.printf("Đã tạo %d sản phẩm mới thành công! \n", n);

    }

    public static void displayProduct(){
        if (currentProductSize == 0){
            System.out.println("Chưa có sản phẩm nào trong danh sách");
            return;
        }
        for (int i = 0; i < currentProductSize; i++) {
            products[i].displayData();
        }
    }

    public static int isIdProductExist(String id){
        for (int i = 0; i < currentProductSize; i++) {
            if (products[i].getProductId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public static void sortProduct(){
        if (currentProductSize == 0){
            System.out.println("Chưa có sản phẩm nào trong danh sách");
            return;
        }
        for (int i = 0; i < currentProductSize - 1; i++) {
            for (int j = i + 1; j < currentProductSize; j++) {
                if(products[i].getPrice() > products[j].getPrice()){
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Danh sách sản phẩm sau khi sắp xếp: ");
        displayProduct();
    }

    public static void updateProduct(Scanner scanner){
        displayProduct();
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();
        int index = isIdProductExist(id);
        if(index == -1){
            System.out.println("Không tìm thấy ID sản phẩm");
        } else {
            Product product = products[index];

            String name;
            while (true) {
                System.out.print("Nhập tên mới cho sản phẩm: ");
                name = scanner.nextLine().trim();
                if (!name.matches("^.{10,50}$")) {
                    System.out.println("Tên sản phẩm từ 10-50 ký tự");
                    continue;
                }
                break;
            }

            float price;
            while (true) {
                System.out.print("Nhập giá mới sản phẩm: ");
                price = Float.parseFloat(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("Giá sản phẩm phải lớn hơn 0");
                    continue;
                }
                break;
            }
                System.out.print("Nhập mô tả mới cho sản phẩm: ");
                String description = scanner.nextLine().trim();

                int catalogId;
                boolean flag = false;
                CategoryService.displayCategory();
                while(true) {
                    System.out.print("Nhập ID danh mục mới cho sản phẩm: ");
                    catalogId = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < CategoryService.currentCategorySize; i++) {
                        if (CategoryService.categories[i].getCatalogId() == catalogId) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("ID danh mục không hợp lệ");
                        continue;
                    }
                    break;
                }

                int newStatus;
                while(true){
                    System.out.print("Nhập trạng thái danh mục mới  (0: Đang bán – 1: Hết hàng – 2: Không bán): ");
                    newStatus = Integer.parseInt(scanner.nextLine());
                    if(newStatus != 0 && newStatus != 1 && newStatus != 2){
                        System.out.println("Trạng thái không hợp lệ");
                        continue;
                    }
                break;
                }

            product.setProductName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setCatalogId(catalogId);
            product.setProductStatus(newStatus);
            System.out.println("Cập nhật sản phẩm thành công");
        }
    }

    public static void deleteProduct(Scanner scanner){
        displayProduct();
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        int index = isIdProductExist(id);
        if(index == -1){
            System.out.println("Không tìm thấy ID sản phẩm");
        } else {
            for (int i = index; i < currentProductSize - 1; i++) {
                products[i] = products[i+1];
            }
            products[currentProductSize - 1] = null;
            currentProductSize--;
            System.out.println("Xóa sản phẩm thành công");
        }
    }

    public static void searchProductByName(Scanner scanner){
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        for (int i = 0 ; i < currentProductSize ; i++){
            if(products[i].getProductName().toLowerCase().contains(name)){
                System.out.println("Đã tìm thấy sản phẩm!");
                products[i].displayData();
            }
        }
    }

    public static void searchProductByPrice(Scanner scanner){
        System.out.print("Nhập giá tối thiểu cần tìm: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập giá tối đa cần tìm: ");
        double max = Double.parseDouble(scanner.nextLine());

        for (int i = 0; i < currentProductSize; i++) {
            if(products[i].getPrice() >= min && products[i].getPrice() <= max){
                System.out.println("Đã tìm thấy sản phẩm!");
                products[i].displayData();
            }
        }
    }
}
