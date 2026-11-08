package ra.baitap12.model.dto.request;

import lombok.Data;

@Data
public class CreateReviewDTO {
    private Long productId;
    private Integer rating;
    private String comment;
}