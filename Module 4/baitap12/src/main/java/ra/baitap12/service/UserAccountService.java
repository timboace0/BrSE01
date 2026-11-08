package ra.baitap12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ra.baitap12.model.dto.request.UpdateUserRoleDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.dto.response.UserInfoResponse;
import ra.baitap12.model.entity.User;
import ra.baitap12.repository.UserRepository;
import ra.baitap12.security.principal.UserPrincipal;

@Service
public class UserAccountService {

    @Autowired
    private UserRepository userRepository;

    public ApiResponse<UserInfoResponse> updateUserRole(Long id, UpdateUserRoleDTO dto) {
        if (dto.getRole() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role cannot be empty");
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        user.setRole(dto.getRole());

        User updatedUser = userRepository.save(user);

        UserInfoResponse response = convertToDTO(updatedUser);

        return ApiResponse.<UserInfoResponse>builder()
                .status(200)
                .message("Update user role successfully")
                .data(response)
                .build();
    }

    public ApiResponse<UserInfoResponse> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return ApiResponse.<UserInfoResponse>builder()
                .status(200)
                .message("Get current user successfully")
                .data(convertToDTO(user))
                .build();
    }

    private UserInfoResponse convertToDTO(User user) {
        return UserInfoResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .build();
    }
}