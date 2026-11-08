package ra.baitap12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ra.baitap12.exception.UsernameAlreadyExistsException;
import ra.baitap12.model.dto.request.UserLoginDTO;
import ra.baitap12.model.dto.request.UserRegisterDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.dto.response.UserLoginResponse;
import ra.baitap12.model.dto.response.UserRegisterResponse;
import ra.baitap12.model.entity.User;
import ra.baitap12.model.entity.UserRole;
import ra.baitap12.repository.UserRepository;
import ra.baitap12.security.jwt.JwtProvider;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;


    public ApiResponse<UserLoginResponse> handleLogin(UserLoginDTO userLoginDTO){
        User user = userRepository.findByEmail(userLoginDTO.getEmail());

        if(user != null && passwordEncoder.matches(userLoginDTO.getPassword() , user.getPassword())){
            String accessToken = jwtProvider.generateToken(user.getEmail());
            String refreshToken = jwtProvider.generateRefreshToken(userLoginDTO.getEmail());

            UserLoginResponse userLoginResponse = UserLoginResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .build();

            return ApiResponse.<UserLoginResponse>builder()
                    .status(201)
                    .message("Đăng nhập thành công")
                    .data(userLoginResponse)
                    .build();
        }
        return ApiResponse.<UserLoginResponse>builder()
                .status(400)
                .message("Đăng nhập thất bại")
                .data(null)
                .build();
    }

    public ApiResponse<UserRegisterResponse> handleRegister(UserRegisterDTO userRegisterDTO){
        if(userRepository.existsByEmail(userRegisterDTO.getEmail())){
            throw new UsernameAlreadyExistsException("username đã tồn tại");
        }

        User user = User.builder()
                .email(userRegisterDTO.getEmail())
                .password(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .phone(userRegisterDTO.getPhone())
                .role(UserRole.USER)
                .build();

        User newUser = userRepository.save(user);

        UserRegisterResponse response = UserRegisterResponse.builder()
                .email(newUser.getEmail())
                .phone(newUser.getPhone())
                .role(UserRole.USER)
                .build();

        return ApiResponse.<UserRegisterResponse>builder()
                .status(201)
                .message("Đăng ký thành công")
                .data(response)
                .build();
    }




}
