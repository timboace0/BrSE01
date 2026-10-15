package ra.baitap81.repository;

import org.springframework.stereotype.Repository;
import ra.baitap81.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    static List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }
}
