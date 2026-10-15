package ra.baitap81.model.entity;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidate {
    private String fullName;
    @Email(message = "email không đúng định dạng")
    private String email;
    private String skills;
    private String cvUrl;
}
