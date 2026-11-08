package ra.baitap12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap12.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
