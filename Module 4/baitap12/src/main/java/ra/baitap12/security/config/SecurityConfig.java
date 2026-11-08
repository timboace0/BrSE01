package ra.baitap12.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ra.baitap12.security.jwt.JwtFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private JwtFilterChain jwtFilterChain;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .requestMatchers("/errors").permitAll()

                                .requestMatchers(HttpMethod.GET, "/api/v1/products", "/api/v1/products/**")
                                .hasAnyRole("USER", "ADMIN", "STAFF")

                                .requestMatchers("/api/v1/products", "/api/v1/products/**")
                                .hasAnyRole("STAFF", "ADMIN")

                                .requestMatchers(HttpMethod.PUT, "/api/users/*/role")
                                .hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET, "/api/users/me")
                                .authenticated()
                                .requestMatchers(HttpMethod.POST, "/api/reviews")
                                .hasRole("USER")

                                .requestMatchers(HttpMethod.GET, "/api/products/*/reviews")
                                .authenticated()

                                .requestMatchers(HttpMethod.GET, "/api/reports/revenue")
                                .hasRole("ADMIN")

                                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilterChain, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}