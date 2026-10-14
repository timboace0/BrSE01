package ra.baitap61.model.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorCreateDTO {
    private String doctorCode;
    private String fullName;
    private String specialization;
    private Integer experienceYears;
}
