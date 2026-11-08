package ra.baitap12.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private String size;
    private String toppings;
}
