package ra.baitap101.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "role")
    private String role;

    private Boolean enabled = true;

    private String otpCode;

    private LocalDateTime otpExpiration;
}
