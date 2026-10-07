package ra.baitap51.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.baitap51.model.dto.request.OrderSummary;
import ra.baitap51.model.entity.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);
    List<Order> findByCustomerNameContaining(String name);

    @Query("""
    SELECT o from Order o
                where o.totalPrice > (select avg(o2.totalPrice) from Order o2)
    """)
    List<Order> findOrderHighPrice();

    @Query("select new ra.baitap51.model.dto.request.OrderSummary(o.orderCode, o.customerName, o.totalPrice) from Order o")
    Page<OrderSummary> findAllAndPagination(Pageable pageable);


    @Query("""
    SELECT new ra.baitap51.model.dto.request.OrderSummary(
        o.orderCode,
        o.customerName,
        o.totalPrice
    )
    FROM Order o
    WHERE (:status IS NULL OR o.status = :status)
      AND (:minPrice IS NULL OR o.totalPrice >= :minPrice)
""")
    Page<OrderSummary> filterOrders(
            @Param("status") String status,
            @Param("minPrice") BigDecimal minPrice,
            Pageable pageable
    );
}
