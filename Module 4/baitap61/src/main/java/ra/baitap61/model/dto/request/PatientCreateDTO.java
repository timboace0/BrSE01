package ra.baitap61.model.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientCreateDTO {
    private String patientCode;
    private String fullName;
    private String phone;
    private String address;
}
