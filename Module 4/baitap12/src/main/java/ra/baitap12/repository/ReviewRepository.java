package ra.baitap12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap12.model.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProduct_IdOrderByCreatedDateDesc(Long productId);
}