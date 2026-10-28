package ra.baitap101.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;
import ra.baitap101.model.dto.request.LoginRequest;
import ra.baitap101.model.dto.request.RegisterRequest;
import ra.baitap101.model.entity.Employee;
import ra.baitap101.model.entity.User;
import ra.baitap101.security.principal.UserPrincipal;
import ra.baitap101.service.EmployeeService;
import ra.baitap101.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployee(){
        return new ResponseEntity<>(employeeService.findAllEmployee(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody RegisterRequest registerRequest
            ) {
        return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest loginRequest,
            HttpSession session
            ) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    loginRequest.getUsername(),
                                    loginRequest.getPassword()
                            )
                    );

            SecurityContext context =
                    SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);

            session.setAttribute(
                    HttpSessionSecurityContextRepository
                            .SPRING_SECURITY_CONTEXT_KEY,
                    context
            );

            UserPrincipal principal =
                    (UserPrincipal) authentication.getPrincipal();

            return ResponseEntity.ok(Map.of(
                    "message", "Đăng nhập thành công",
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


