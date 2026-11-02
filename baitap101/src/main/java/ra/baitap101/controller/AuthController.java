package ra.baitap101.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import ra.baitap101.model.dto.request.ActiveUserDTO;
import ra.baitap101.model.dto.request.LoginRequest;
import ra.baitap101.model.dto.request.RegisterRequest;
import ra.baitap101.model.entity.Employee;
import ra.baitap101.model.entity.User;
import ra.baitap101.security.jwt.JwtProvider;
import ra.baitap101.security.principal.UserPrincipal;
import ra.baitap101.service.AuthService;
import ra.baitap101.service.EmployeeService;
import ra.baitap101.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Valid @RequestBody RegisterRequest registerRequest
            ) {
        return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("/active-user")
    public ResponseEntity<String> activeUser(@Valid @RequestBody ActiveUserDTO dto) {
        return ResponseEntity.ok(authService.activeUser(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest loginRequest
            ) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    loginRequest.getUsername(),
                                    loginRequest.getPassword()
                            )
                    );

            UserPrincipal principal =
                    (UserPrincipal) authentication.getPrincipal();

            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();

            String token = jwtProvider.generateToken(
                    principal.getUsername(),
                    roles
            );

            return ResponseEntity.ok(Map.of(
                    "accessToken", token,
                    "type", "Bearer",
                    "username", principal.getUsername()
            ));

        } catch (BadCredentialsException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "message",
                            "username or password incorrect"
                    ));
        }
        }


    }


