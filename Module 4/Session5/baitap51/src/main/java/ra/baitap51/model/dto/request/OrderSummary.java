package ra.baitap51.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderSummary {
    private String orderCode;

    private String customerName;

    private Double totalPrice;
}
