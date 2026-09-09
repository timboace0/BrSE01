package model;

import java.util.Scanner;

public class Categories implements IShop {
    public static int currentId = 1;
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
        this.catalogId = currentId++;
    }

    public Categories(String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = currentId++;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public static void inputData(Scanner scanner,  Categories[] arrCategories, int index){
        String name;

        while(true){
            System.out.print("Mời nhập tên danh mục: ");
            name = scanner.nextLine().trim();

            if(name.length() > 50){
                System.out.println("Tên danh mục không vượt qua 50 ký tự");
                continue;
            }

            boolean isExist = false;

            for(int i = 0; i < index; i++){
                if(arrCategories[i].getCatalogName().equalsIgnoreCase(name)){
                    isExist = true;
                    break;
                }
            }
            if(isExist){
                System.out.println("Danh mục đã tồn tại");
                continue;
            }

            break;
        }


        System.out.print("Mời nhập mô tả danh mục: ");
        String description = scanner.nextLine();


        boolean status;
        while (true) {
            System.out.print("Mời nhập trạng thái danh mục (true/false): ");
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

        Categories categories = new Categories(name, description, status);
        arrCategories[index] = categories;
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %-3d | Tên Danh Mục: %-30s | Mô tả: %-30s | Trạng Thái: %-10s \n", this.catalogId, this.catalogName, this.descriptions, this.catalogStatus ? "Hoạt động" : "Không hoạt động");
    }
}
