package ra.baitap61.model.dto.response;

import lombok.*;
import ra.baitap61.model.entity.Patient;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponse {
    private List<Patient> data;
    private int totalPage;
    private int totalElement;
    private int currentPage;
}
