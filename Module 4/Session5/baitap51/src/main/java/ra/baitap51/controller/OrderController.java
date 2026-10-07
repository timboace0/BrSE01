package ra.baitap51.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ra.baitap51.model.dto.request.OrderSummary;
import ra.baitap51.model.dto.response.PaginationResponse;
import ra.baitap51.model.entity.Order;
import ra.baitap51.service.OrderService;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/searchStatus")
    public ResponseEntity<List<Order>> searchStatus(
            @RequestParam String status
    ) {
        return new ResponseEntity<>(orderService.getOrdersByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/searchByCustomer")
    public ResponseEntity<List<Order>> searchByCustomer(
            @RequestParam String customerName
    ) {
        return new ResponseEntity<>(orderService.getOrdersByCustomerName(customerName), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Order>> sortOrders(
            @RequestParam String sortBy,
            @RequestParam String dir
    ) {
        return new ResponseEntity<>(orderService.getAllOrdersSorted(sortBy, dir), HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Slice<Order>> pagingOrders(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        return new ResponseEntity<>(orderService.getOrdersPaged(page, size), HttpStatus.OK);
    }

    @GetMapping("/high-value")
    public ResponseEntity<List<Order>> getOrdersHighPrice() {
        return new ResponseEntity<>(orderService.getOrdersHighPrice(), HttpStatus.OK);
    }

    @GetMapping("/findAllAndSearch")
    public ResponseEntity<PaginationResponse> findAllAndSearch(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        return new ResponseEntity<>(
                orderService.findAllAndPagination(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<OrderSummary>> filterOrders(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String sort
    ) {
        String[] sortParams = sort.split(",");

        Sort.Direction direction =
                Sort.Direction.fromString(sortParams[1]);

        Sort sortBy = Sort.by(direction, sortParams[0]);

        Pageable pageable = PageRequest.of(page, size, sortBy);

        return ResponseEntity.ok(
                orderService.filterOrders(status, minPrice, pageable)
        );
    }
}
