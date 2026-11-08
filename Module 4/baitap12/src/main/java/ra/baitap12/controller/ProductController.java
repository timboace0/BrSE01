package ra.baitap12.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.baitap12.model.dto.request.CreateProductDTO;
import ra.baitap12.model.dto.request.UpdateProductDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.entity.Product;
import ra.baitap12.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ApiResponse<List<Product>> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping
    public ApiResponse<Product> addProduct(
            @Valid @RequestBody CreateProductDTO createProductDTO
            ) {
        return productService.addProduct(createProductDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse<Product> updateProduct(
            @Valid @RequestBody UpdateProductDTO updateProductDTO,
            @PathVariable Long id
            ) {
        return productService.updateProduct(updateProductDTO, id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> deleteProduct(
            @Valid @PathVariable Long id
    ) {
        return productService.deleteProduct(id);
    }
}
