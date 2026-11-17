package ra.tsuptonjv260428_le_gia_khang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.tsuptonjv260428_le_gia_khang.exception.DuplicateResourceException;
import ra.tsuptonjv260428_le_gia_khang.exception.ResourceNotFoundException;
import ra.tsuptonjv260428_le_gia_khang.model.dto.request.ProductDTO;
import ra.tsuptonjv260428_le_gia_khang.model.dto.response.ApiResponse;
import ra.tsuptonjv260428_le_gia_khang.model.entity.Product;
import ra.tsuptonjv260428_le_gia_khang.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UploadService uploadService;

    public ApiResponse<Page<Product>> findAllProducts(Integer page){
        Pageable pageable = PageRequest.of(
                page,
                5,
                Sort.by("id").descending()
        );

        return ApiResponse.<Page<Product>>builder()
                .status(200)
                .message("Hiển thị danh sách sản phẩm thành công!")
                .data(productRepository.findAll(pageable))
                .timestamp(LocalDateTime.now())
                .build();
    }

    public ApiResponse<Product> addProduct(ProductDTO productDTO){
        if(productRepository.existsByProductName(productDTO.getProductName())) {
            throw new DuplicateResourceException(
                    "Tên sản phẩm đã tồn tại!"
            );
        };

        String imageName = uploadService.uploadFileToServer(productDTO.getProductImage());

        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .price(productDTO.getPrice())
                .currencyUnit(productDTO.getCurrencyUnit())
                .importDate(productDTO.getImportDate())
                .warrantyPeriod(productDTO.getWarrantyPeriod())
                .warrantyUnit(productDTO.getWarrantyUnit())
                .productImage(imageName)
                .description(productDTO.getDescription())
                .status(productDTO.getStatus())
                .build();

        return ApiResponse.<Product>builder()
                .status(201)
                .message("Thêm sản phẩm thành công!")
                .data(productRepository.save(product))
                .timestamp(LocalDateTime.now())
                .build();
    }

    public ApiResponse<Product> updateProduct(
            ProductDTO productDTO, Long id
    ) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sản phẩm!"));

        if(productRepository.existsByProductNameAndIdNot(productDTO.getProductName(), id)){
            throw  new DuplicateResourceException(
                    "Tên sản phẩm đã tồn tại!"
            );
        };

        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setCurrencyUnit(productDTO.getCurrencyUnit());
        product.setImportDate(productDTO.getImportDate());
        product.setWarrantyPeriod(productDTO.getWarrantyPeriod());
        product.setWarrantyUnit(productDTO.getWarrantyUnit());
        product.setDescription(productDTO.getDescription());
        product.setStatus(productDTO.getStatus());
        if(productDTO.getProductImage() != null
                        && !productDTO.getProductImage().isEmpty()){
            String imageName = uploadService.uploadFileToServer(productDTO.getProductImage());
            product.setProductImage(imageName);
        }

        return ApiResponse.<Product>builder()
                .status(200)
                .message("Cập nhật sản phẩm thành công!")
                .data(productRepository.save(product))
                .timestamp(LocalDateTime.now())
                .build();
    }

    public ApiResponse<Product> changeStatus(Long id, Byte status){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy sản phẩm!"
                ));

        if(product.getStatus() == 2){
            throw new RuntimeException(
                    "Sản phẩm đã ngừng sản xuất, không thể thay đổi!"
            );
        }
        if(status != 0 && status != 1 && status != 2){
            throw new RuntimeException(
                    "Status không hợp lệ!"
            );
        }

        product.setStatus(status);

        Product updatedProduct = productRepository.save(product);

        return ApiResponse.<Product>builder()
                .status(200)
                .message("Cập nhật trạng thái sản phẩm thành công!")
                .data(updatedProduct)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public ApiResponse<List<Product>> searchProductByName(String name){
        List<Product> products =
                productRepository.findByProductNameContainingIgnoreCase(name);

        if (products.isEmpty()){
            return ApiResponse.<List<Product>>builder()
                    .status(404)
                    .message("Không tìm thấy sản phẩm nào!")
                    .data(products)
                    .timestamp(LocalDateTime.now())
                    .build();
        }

        return ApiResponse.<List<Product>>builder()
                .status(200)
                .message("Tìm kiếm sản phẩm thành công!")
                .data(products)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public ApiResponse<List<Product>> searchProductByStatus(Byte status){
        List<Product> products =
                productRepository.findByStatus(status);

        if (products.isEmpty()){
            return ApiResponse.<List<Product>>builder()
                    .status(404)
                    .message("Không tìm thấy sản phẩm nào!")
                    .data(products)
                    .timestamp(LocalDateTime.now())
                    .build();
        }

        return ApiResponse.<List<Product>>builder()
                .status(200)
                .message("Tìm kiếm sản phẩm thành công!")
                .data(products)
                .timestamp(LocalDateTime.now())
                .build();
    }


}
