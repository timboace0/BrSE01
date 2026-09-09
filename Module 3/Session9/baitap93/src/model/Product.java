package model;

import bussiness.CategoryService;

import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private double price;
    private String description;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, double price, String description, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public static void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatalog){
        String id;

        while (true) {
            System.out.print("Mời nhập mã sản phẩm (CXXX - SXXX - AXXX): ");
            id = scanner.nextLine().trim();

            if (!id.matches("^[CSA]\\d{3}$")) {
                System.out.println("Mã sản phẩm không đúng định dạng!");
                continue;
            }

            boolean isExist = false;

            for (int i = 0; i < indexProduct; i++) {
                if (arrProduct[i].getProductId().equalsIgnoreCase(id)) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                System.out.println("Mã sản phẩm đã tồn tại!");
                continue;
            }

            break;
        }

        String name;

        while (true) {
            System.out.print("Mời nhập tên sản phẩm: ");
            name = scanner.nextLine().trim();

            if (!name.matches("^.{10,50}$")) {
                System.out.println("Tên sản phẩm từ 10-50 ký tự!");
                continue;
            }

            break;
        }

        double price;

        while (true) {
            System.out.print("Mời nhập giá sản phẩm: ");
            price = Double.parseDouble(scanner.nextLine());

            if (price <= 0) {
                System.out.println("Giá sản phẩm phải lớn hơn 0!");
                continue;
            }

            break;
        }

        System.out.print("Mời mô tả sản phẩm: ");
        String description = scanner.nextLine().trim();

        CategoryService.displayCategory();

        int idCatalog;

        while (true) {
            System.out.print("Mời nhập mã danh mục sản phẩm thuộc về: ");
            idCatalog = Integer.parseInt(scanner.nextLine());

            boolean isExist = false;

            for (int i = 0; i < indexCatalog; i++) {
                if (arrCategories[i].getCatalogId() == idCatalog) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                System.out.println("ID danh mục không tồn tại!");
                continue;
            }

            break;
        }

        int status;

        while (true) {
            System.out.print(
                    "Mời nhập trạng thái sản phẩm " +
                            "(0: Đang bán – 1: Hết hàng – 2: Không bán): "
            );

            status = Integer.parseInt(scanner.nextLine());

            if (status != 0 && status != 1 && status != 2) {
                System.out.println("Trạng thái không hợp lệ!");
                continue;
            }

            break;
        }

        Product product = new Product(id,name,price,description,idCatalog,status);

        arrProduct[indexProduct] = product;
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %-3s | Tên Sản Phẩm: %-30s | Giá: %-10.3f | Mô tả: %-30s | Mã danh mục: %-3d | Trạng thái: %-10s \n", this.productId, this.productName, this.price, this.description, this.catalogId, this.productStatus);
    }
}
