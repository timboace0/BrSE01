package ra.baitap61.model.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecordRequest {
    private Long doctorId;
    private Long patientId;
    private String diagnosis;
}
