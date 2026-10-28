package ra.baitap91.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import ra.baitap91.validator.CheckFileImage;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDTO {
    @NotBlank(message = "tên nhân viên không được để trống!")
    private String fullName;

    @Email(message = "Vui lòng nhập đúng định dạng email!")
    private String email;

    @Pattern(regexp = "^0[35789][0-9]{8}$", message = "Số điện thoại không hợp lệ!")
    private String phone;

    @Min(5000000)
    private Double salary;

    @CheckFileImage
    private MultipartFile avatarUrl;

    @NotNull(message = "Vui lòng chọn phòng ban")
    private Long departmentId;
}
