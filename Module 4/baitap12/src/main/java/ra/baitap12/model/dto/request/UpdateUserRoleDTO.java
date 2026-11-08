package ra.baitap12.model.dto.request;

import lombok.Data;
import ra.baitap12.model.entity.UserRole;

@Data
public class UpdateUserRoleDTO {
    private UserRole role;
}