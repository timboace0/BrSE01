package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService pse;

    @Autowired
    public ProductController(ProductService pse){
        this.pse = pse;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return pse.getAllProducts();
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        pse.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable int id,@RequestBody Product product){
        pse.updateProduct(id,product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        pse.deleteProduct(id);
    }
}
