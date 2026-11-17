package ra.tsuptonjv260428_le_gia_khang.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.tsuptonjv260428_le_gia_khang.model.dto.request.ProductDTO;
import ra.tsuptonjv260428_le_gia_khang.model.dto.response.ApiResponse;
import ra.tsuptonjv260428_le_gia_khang.model.entity.Product;
import ra.tsuptonjv260428_le_gia_khang.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Product>>> getAllProducts(
            @RequestParam(defaultValue = "0") int page
    ) {
        return ResponseEntity.ok(
                productService.findAllProducts(page)
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> addProduct(
           @Valid @ModelAttribute ProductDTO productDTO,
           BindingResult bindingResult
            ) {
        if(bindingResult.hasErrors()) {
            throw new RuntimeException("Thông tin sản phẩm không hợp lệ!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(
            @Valid @ModelAttribute ProductDTO productDTO,
            @PathVariable Long id,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) {
            throw new RuntimeException("Thông tin sản phẩm không hợp lệ!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(productDTO, id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> changeStatus(
            @PathVariable Long id,
            @RequestParam Byte status
    ) {
        return ResponseEntity.ok(
                productService.changeStatus(id,status)
        );
    }

    @GetMapping("/search/name")
    public ResponseEntity<?> searchByName(
            @RequestParam String name
    ) {
        return ResponseEntity.ok(
                productService.searchProductByName(name)
        );
    }

    @GetMapping("/search/status")
    public ResponseEntity<?> searchByStatus(
            @RequestParam Byte status
    ) {
        return ResponseEntity.ok(
                productService.searchProductByStatus(status)
        );
    }
}
