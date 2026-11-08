package ra.baitap12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap12.model.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    boolean existsByOrder_User_IdAndProduct_Id(Long userId, Long productId);
}