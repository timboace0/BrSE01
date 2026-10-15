package ra.baitap81.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap81.model.entity.Product;
import ra.baitap81.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setImage(product.getImage());

        if(product1.getImage().isEmpty()){
            throw new RuntimeException("Ảnh sản phẩm là bắt buộc");
        }

        productRepository.addProduct(product1);
    }
}
