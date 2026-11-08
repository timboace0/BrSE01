package ra.baitap12.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RevenueReportResponse {
    private String period;
    private BigDecimal totalRevenue;
    private Long orderCount;
}