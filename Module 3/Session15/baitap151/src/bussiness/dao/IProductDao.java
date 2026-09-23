package bussiness.dao;

import bussiness.model.Product;

import java.util.Scanner;

public interface IProductDao {
    void getAllProduct();
    void isCatalogExist(Scanner scanner);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Integer id);
    void findProductById(Integer id);
    void findProductByName(String name);
    void statisticByCatalog();
}
