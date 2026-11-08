package ra.baitap12.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.baitap12.model.dto.request.UserLoginDTO;
import ra.baitap12.model.dto.request.UserRegisterDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.dto.response.UserLoginResponse;
import ra.baitap12.model.dto.response.UserRegisterResponse;
import ra.baitap12.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserRegisterResponse> register(
            @Valid @RequestBody UserRegisterDTO userRegisterDTO
            ) {
        return userService.handleRegister(userRegisterDTO);
    }

    @PostMapping("/login")
    public ApiResponse<UserLoginResponse> login(
            @Valid @RequestBody UserLoginDTO userLoginDTO
    ) {
        return userService.handleLogin(userLoginDTO);
    }
}
