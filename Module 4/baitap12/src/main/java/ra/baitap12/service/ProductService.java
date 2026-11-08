package ra.baitap12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap12.model.dto.request.CreateProductDTO;
import ra.baitap12.model.dto.request.UpdateProductDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.entity.Product;
import ra.baitap12.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ApiResponse<List<Product>> getAllProduct(){
        return ApiResponse.<List<Product>>builder()
                .status(200)
                .message("Lấy danh sách thành công")
                .data(productRepository.findAll())
                .build();
    }

    public ApiResponse<Product> addProduct(CreateProductDTO createProductDTO){
        Product newProduct = Product.builder()
                .name(createProductDTO.getName())
                .description(createProductDTO.getDescription())
                .price(createProductDTO.getPrice())
                .size(createProductDTO.getSize())
                .toppings(createProductDTO.getToppings())
                .build();

        return ApiResponse.<Product>builder()
                .status(201)
                .message("Tạo sản phẩm mới thành công")
                .data(productRepository.save(newProduct))
                .build();
    }

    public ApiResponse<Product> updateProduct(UpdateProductDTO updateProductDTO, Long id) {
        Product foundProduct = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Không tìm thấy id sản phẩm"
                ));

        foundProduct.setName(updateProductDTO.getName());
        foundProduct.setDescription(updateProductDTO.getDescription());
        foundProduct.setPrice(updateProductDTO.getPrice());
        foundProduct.setSize(updateProductDTO.getSize());
        foundProduct.setToppings(updateProductDTO.getToppings());

        return ApiResponse.<Product>builder()
                .status(200)
                .message("cập nhật sản phẩm thành công")
                .data(productRepository.save(foundProduct))
                .build();
    }

    public ApiResponse<?> deleteProduct(Long id){
        Product foundProduct = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Không tìm thấy id sản phẩm"
                ));

        productRepository.delete(foundProduct);
        return ApiResponse.builder()
                .status(200)
                .message("Xóa sản phẩm thành công")
                .data(null)
                .build();
    }
}
