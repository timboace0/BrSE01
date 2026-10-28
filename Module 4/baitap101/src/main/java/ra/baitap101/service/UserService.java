package ra.baitap101.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ra.baitap101.model.dto.request.RegisterRequest;
import ra.baitap101.model.entity.Employee;
import ra.baitap101.model.entity.User;
import ra.baitap101.repository.UserRepository;

import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(RegisterRequest registerRequest){
        Boolean found = userRepository.existsByUsername(registerRequest.getUsername());
        if(found){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username đã tồn tại!");
        }

         User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .fullName(registerRequest.getFullName())
                .role("USER")
                .enabled(true)
                .build();
        return userRepository.save(user);
    }
}
