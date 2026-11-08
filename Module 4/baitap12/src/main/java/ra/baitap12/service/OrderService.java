package ra.baitap12.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ra.baitap12.model.dto.request.CreateOrderDTO;
import ra.baitap12.model.dto.request.OrderItemDTO;
import ra.baitap12.model.dto.request.UpdateOrderStatusDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.entity.Order;
import ra.baitap12.model.entity.OrderItem;
import ra.baitap12.model.entity.Product;
import ra.baitap12.model.entity.User;
import ra.baitap12.repository.OrderRepository;
import ra.baitap12.repository.ProductRepository;
import ra.baitap12.repository.UserRepository;
import ra.baitap12.security.principal.UserPrincipal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    private User getCurrentUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        UserPrincipal userPrincipal =
                (UserPrincipal) authentication.getPrincipal();

        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public ApiResponse<Order> createOrder(CreateOrderDTO dto) {

        User user = getCurrentUser();

        if (dto.getOrderItems() == null || dto.getOrderItems().isEmpty()) {
            throw new RuntimeException("Order items cannot be empty");
        }

        Order order = Order.builder()
                .createdDate(LocalDateTime.now())
                .status("JUST CREATED")
                .user(user)
                .build();

        List<OrderItem> orderItems = new ArrayList<>();

        BigDecimal totalMoney = BigDecimal.ZERO;

        for (OrderItemDTO itemDTO : dto.getOrderItems()) {

            if (itemDTO.getQuantity() == null || itemDTO.getQuantity() <= 0) {
                throw new RuntimeException("Quantity must be greater than 0");
            }

            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            BigDecimal priceBuy = product.getPrice();

            BigDecimal itemTotal = priceBuy.multiply(
                    BigDecimal.valueOf(itemDTO.getQuantity())
            );

            totalMoney = totalMoney.add(itemTotal);

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemDTO.getQuantity())
                    .priceBuy(priceBuy)
                    .build();

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setTotalMoney(totalMoney);

        Order savedOrder = orderRepository.save(order);

        return ApiResponse.<Order>builder()
                .status(201)
                .message("Order created successfully")
                .data(savedOrder)
                .build();
    }

    public ApiResponse<List<Order>> getMyOrders() {

        User user = getCurrentUser();

        List<Order> orders = orderRepository
                .findByUser_IdOrderByCreatedDateDesc(user.getId());

        return ApiResponse.<List<Order>>builder()
                .status(200)
                .message("Get my orders successfully")
                .data(orders)
                .build();
    }

    public ApiResponse<List<Order>> getAllOrders() {

        List<Order> orders = orderRepository.findAll();

        return ApiResponse.<List<Order>>builder()
                .status(200)
                .message("Get all orders successfully")
                .data(orders)
                .build();
    }

    public ApiResponse<Order> updateOrderStatus(
            Long orderId,
            UpdateOrderStatusDTO dto
    ) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (dto.getStatus() == null || dto.getStatus().isBlank()) {
            throw new RuntimeException("Status cannot be empty");
        }

        order.setStatus(dto.getStatus());

        Order updatedOrder = orderRepository.save(order);

        return ApiResponse.<Order>builder()
                .status(200)
                .message("Update order status successfully")
                .data(updatedOrder)
                .build();
    }
}