package ra.baitap71.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.baitap71.validation.ViettelPhone;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParentDTO {
    @NotBlank(message = "Tên phụ huynh không được để trống!")
    @Pattern(regexp = "^[A-Z].*", message = "Tên phụ huynh phải bắt đầu bằng chữ in hoa!")
    private String name;

    @ViettelPhone
    private String phone;

}
