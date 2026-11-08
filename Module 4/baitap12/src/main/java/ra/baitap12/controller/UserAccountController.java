package ra.baitap12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.baitap12.model.dto.request.UpdateUserRoleDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.dto.response.UserInfoResponse;
import ra.baitap12.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PutMapping("/{id}/role")
    public ApiResponse<UserInfoResponse> updateUserRole(
            @PathVariable Long id,
            @RequestBody UpdateUserRoleDTO dto
    ) {
        return userAccountService.updateUserRole(id, dto);
    }

    @GetMapping("/me")
    public ApiResponse<UserInfoResponse> getCurrentUser() {
        return userAccountService.getCurrentUser();
    }
}