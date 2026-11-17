package ra.tsuptonjv260428_le_gia_khang.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Tên sản phẩm không được để trống!")
    private String productName;
    @NotNull(message = "Giá sản phẩm không được để trống!")
    @DecimalMin(value = "0", message = "Giá sản phẩm phải lớn hơn 0!")
    private Double price;
    @NotBlank(message = "Đơn vị tiền tệ không được để trống!")
    private String currencyUnit;
    @NotNull(message = "Ngày nhập hàng không được để trống!")
    private LocalDate importDate;
    @NotNull(message = "Thời gian bảo hành không được để trống!")
    private Integer warrantyPeriod;
    @NotBlank(message = "Đơn vị tính thời gian bảo hành không được để trống!")
    private String warrantyUnit;
    @NotNull(message = "Đường dẫn ảnh sản phẩm không được để trống!")
    private MultipartFile productImage;
    @NotBlank(message = "Mô tả sản phẩm không được để trống!")
    private String description;
    @NotNull(message = "Trạng thái sản phẩm không được để trống!")
    @Min(value = 0, message = "Trạng thái sản phẩm phải là 0 - Ngừng kinh doanh, 1 - Đang kinh doanh, 2 - Ngừng sản xuất!")
    @Max(value = 2, message = "Trạng thái sản phẩm phải là 0 - Ngừng kinh doanh, 1 - Đang kinh doanh, 2 - Ngừng sản xuất!")
    private Byte status;
}
