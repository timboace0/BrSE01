package ra.baitap12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.dto.response.RevenueReportResponse;
import ra.baitap12.model.entity.Order;
import ra.baitap12.repository.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ReportService {

    @Autowired
    private OrderRepository orderRepository;

    public ApiResponse<List<RevenueReportResponse>> getRevenueReport(String type) {

        if (type == null ||
                !(type.equalsIgnoreCase("day")
                        || type.equalsIgnoreCase("month")
                        || type.equalsIgnoreCase("year"))) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Type must be day, month or year"
            );
        }

        List<Order> orders = orderRepository.findAllByOrderByCreatedDateAsc();

        Map<String, RevenueReportResponse> reportMap = new TreeMap<>();

        for (Order order : orders) {

            if (order.getCreatedDate() == null) {
                continue;
            }

            String period;

            switch (type.toLowerCase()) {
                case "day":
                    period = order.getCreatedDate().toLocalDate().toString();
                    break;

                case "month":
                    period = YearMonth.from(order.getCreatedDate()).toString();
                    break;

                case "year":
                    period = String.valueOf(order.getCreatedDate().getYear());
                    break;

                default:
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Invalid report type"
                    );
            }

            BigDecimal revenue = order.getTotalMoney() == null
                    ? BigDecimal.ZERO
                    : order.getTotalMoney();

            RevenueReportResponse report = reportMap.get(period);

            if (report == null) {
                report = RevenueReportResponse.builder()
                        .period(period)
                        .totalRevenue(BigDecimal.ZERO)
                        .orderCount(0L)
                        .build();

                reportMap.put(period, report);
            }

            report.setTotalRevenue(report.getTotalRevenue().add(revenue));
            report.setOrderCount(report.getOrderCount() + 1);
        }

        return ApiResponse.<List<RevenueReportResponse>>builder()
                .status(200)
                .message("Get revenue report successfully")
                .data(List.copyOf(reportMap.values()))
                .build();
    }
}