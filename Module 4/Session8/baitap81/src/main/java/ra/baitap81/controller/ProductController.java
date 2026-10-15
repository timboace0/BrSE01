package ra.baitap81.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ra.baitap81.model.entity.Product;
import ra.baitap81.service.ProductService;
import ra.baitap81.service.UploadService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UploadService uploadService;

    @PostMapping
    public ResponseEntity<?> addProduct(
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam(value = "image", required = false) MultipartFile file
            ) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Ảnh sản phẩm là bắt buộc");
        }
        String imagePath = uploadService.uploadFileToServer(file);
        Product product = new Product(name,price,imagePath);
        productService.addProduct(product);
        return new ResponseEntity<>("Tạo sản phẩm thành công", HttpStatus.CREATED);
    }
}
