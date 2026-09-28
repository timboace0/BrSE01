package com.example.product_management.service;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(List.of(
            new Product(1,"iphone 18", 2000),
            new Product(2,"ipod 4", 500),
            new Product(3,"macbook m5", 3000)
    ));

    public List<Product> getAllProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    public void updateProduct(int id, Product newProduct){
        for (Product product : products){
            if(product.getId() == id){
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
    }

    public void deleteProduct(int id){
        products.removeIf(product -> product.getId() == id);
    }
}
