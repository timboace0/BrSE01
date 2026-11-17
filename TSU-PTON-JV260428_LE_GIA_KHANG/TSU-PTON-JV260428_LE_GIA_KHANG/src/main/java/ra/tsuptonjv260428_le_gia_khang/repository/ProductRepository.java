package ra.tsuptonjv260428_le_gia_khang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.tsuptonjv260428_le_gia_khang.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Boolean existsByProductName(String productName);

    Boolean existsByProductNameAndIdNot(String productName, Long id);

    List<Product> findByProductNameContainingIgnoreCase(String productName);

    List<Product> findByStatus(Byte status);
}
