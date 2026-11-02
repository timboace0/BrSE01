package ra.baitap101.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.baitap101.model.dto.request.RegisterDTO;
import ra.baitap101.model.dto.request.ActiveUserDTO;
import ra.baitap101.model.entity.User;
import ra.baitap101.repository.UserRepository;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

    private final SecureRandom secureRandom = new SecureRandom();

    @Transactional
    public String register(RegisterDTO dto) {

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email đã được sử dụng");
        }

        String otp = String.format("%06d", secureRandom.nextInt(1000000));

        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .role("USER")
                .enabled(false)
                .otpCode(otp)
                .otpExpiration(LocalDateTime.now().plusMinutes(5))
                .build();

        userRepository.save(user);

        mailService.sendMail(user.getEmail(), otp);

        return "Đăng ký thành công. Vui lòng kiểm tra email để lấy mã OTP.";
    }

    @Transactional
    public String activeUser(ActiveUserDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));

        if (Boolean.TRUE.equals(user.getEnabled())) {
            throw new RuntimeException("Tài khoản đã được kích hoạt");
        }

        if (user.getOtpCode() == null || !user.getOtpCode().equals(dto.getOtp())) {
            throw new RuntimeException("OTP không chính xác");
        }

        if (user.getOtpExpiration() == null ||
                LocalDateTime.now().isAfter(user.getOtpExpiration())) {
            throw new RuntimeException("OTP đã hết hạn");
        }

        user.setEnabled(true);
        user.setOtpCode(null);
        user.setOtpExpiration(null);

        userRepository.save(user);

        return "Kích hoạt tài khoản thành công! Bạn có thể đăng nhập ngay bây giờ.";
    }
}