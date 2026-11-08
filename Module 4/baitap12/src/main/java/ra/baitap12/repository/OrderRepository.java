package ra.baitap12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap12.model.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser_IdOrderByCreatedDateDesc(Long userId);
    List<Order> findAllByOrderByCreatedDateAsc();
}

