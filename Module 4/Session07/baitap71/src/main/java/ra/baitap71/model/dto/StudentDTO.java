package ra.baitap71.model.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {
    @NotBlank(message = "Họ tên không được để trống!")
    @Size(min = 5, max = 100, message = "Họ tên phải có độ dài từ 5-100 ký tự!")
    private String fullName;

    @NotBlank(message = "Chuyên ngành không được để trống!")
    private String major;

    @Min(value = 18, message = "Sinh viên phải từ 18 tuổi trở lên!")
    private int age;

    @Min(value = 0, message = "Điểm GPA phải trong khoảng 0-10!")
    @Max(value = 10, message = "Điểm GPA phải trong khoảng 0-10!")
    private Double gpa;

    @Pattern(regexp = "^SV\\d{4}$", message = "Vui lòng nhập mã sinh viên hợp lệ! (SVxxxx) VD: SV1234")
    private String studentCode;

    @Valid
    private ParentDTO parent;
}
