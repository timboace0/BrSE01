package ra.baitap51.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.baitap51.model.dto.request.OrderSummary;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginationResponse {
    private List<OrderSummary> data;
    private int totalPage;
    private long totalElement;
    private int currentPage;
}
