package ra.baitap12.model.dto.response;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.baitap12.model.entity.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterResponse {
    private String phone;
    private String password;
    private String email;
    private UserRole role;
}
