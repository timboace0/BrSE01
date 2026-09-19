package bussiness.service;

import bussiness.exception.InvalidProductException;
import bussiness.exception.ProductNotFoundException;
import bussiness.model.Product;
import utils.InputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductManager<T extends Product> {
    List<T> productList = new ArrayList<>();
    Map<Integer, T> productMap = new HashMap<>();

    public void addProduct(Scanner scanner) {
        int id = InputData.getInt(scanner, "Nhập ID sản phẩm: ");

        if (productMap.containsKey(id)) {
            System.out.println("ID sản phẩm đã tồn tại!");
            return;
        }

        String name = InputData.getString(scanner, "Nhập tên sản phẩm: ");

        double price;

        try {
            price = InputData.getDouble(scanner, "Nhập giá sản phẩm: ");

            if (price <= 0) {
                throw new InvalidProductException("Giá sản phẩm phải lớn hơn 0!");
            }
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
            return;
        }

        Product product = new Product(id, name, price);

        productList.add((T) product);
        productMap.put(id, (T) product);

        System.out.println("Thêm sản phẩm thành công!");
    }

    public void removeProduct(Scanner scanner) {
        displayProducts();

        int id = InputData.getInt(scanner, "Nhập ID sản phẩm cần xóa: ");

        try {
            if (!productMap.containsKey(id)) {
                throw new ProductNotFoundException("Không tìm thấy sản phẩm!");
            }

            T product = productMap.remove(id);
            productList.remove(product);

            System.out.println("Xóa sản phẩm thành công!");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào!");
            return;
        }

        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }

    public T getProductById(int id) {
        try {
            T product = productMap.get(id);

            if (product == null) {
                throw new ProductNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
            }

            return product;
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void displayProductsByMap() {
        if (productMap.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào!");
            return;
        }

        for (Map.Entry<Integer, T> entry : productMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}