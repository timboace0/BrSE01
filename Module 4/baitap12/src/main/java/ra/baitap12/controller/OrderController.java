package ra.baitap12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.baitap12.model.dto.request.CreateOrderDTO;
import ra.baitap12.model.dto.request.UpdateOrderStatusDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.entity.Order;
import ra.baitap12.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ApiResponse<Order> createOrder(
            @RequestBody CreateOrderDTO dto
    ) {
        return orderService.createOrder(dto);
    }

    @GetMapping("/my")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ApiResponse<List<Order>> getMyOrders() {
        return orderService.getMyOrders();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('STAFF', 'ADMIN')")
    public ApiResponse<List<Order>> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasAuthority('STAFF')")
    public ApiResponse<Order> updateOrderStatus(
            @PathVariable Long id,
            @RequestBody UpdateOrderStatusDTO dto
    ) {
        return orderService.updateOrderStatus(id, dto);
    }
}