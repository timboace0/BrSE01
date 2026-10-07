package ra.baitap51.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ra.baitap51.model.dto.request.OrderSummary;
import ra.baitap51.model.dto.response.PaginationResponse;
import ra.baitap51.model.entity.Order;
import ra.baitap51.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByStatus(String status){
        return orderRepository.findByStatus(status);
    }

    public List<Order> getOrdersByCustomerName(String name){
        return orderRepository.findByCustomerNameContaining(name);
    }

    public List<Order> getAllOrdersSorted(String field, String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortDirection, field);

        return orderRepository.findAll(sort);
    }

    public Slice<Order> getOrdersPaged(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return orderRepository.findAll(pageable);
    }

    public List<Order> getOrdersHighPrice(){
        return orderRepository.findOrderHighPrice();
    }

    public PaginationResponse findAllAndPagination(Pageable pageable){
        Page<OrderSummary> page = orderRepository.findAllAndPagination(pageable);

        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setData(page.getContent());
        paginationResponse.setTotalPage(page.getTotalPages());
        paginationResponse.setTotalElement(page.getTotalElements());
        paginationResponse.setCurrentPage(page.getNumber());
                return paginationResponse;
    }

    public Page<OrderSummary> filterOrders(
            String status,
            BigDecimal minPrice,
            Pageable pageable
    ) {
        return orderRepository.filterOrders(status, minPrice, pageable);
    }
}
