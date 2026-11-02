package ra.baitap101.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ra.baitap101.security.exception.JwtAuthenticationEntryPoint;
import ra.baitap101.security.jwt.JwtProvider;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. Lấy token từ Header
        String header = request.getHeader("Authorization");

// 2. Không có Bearer Token thì cho request đi tiếp
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);

        try {

            String username = jwtProvider.getUserNameFromJWT(token);

            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);

        } catch (ExpiredJwtException e) {

            authenticationEntryPoint.commence(
                    request,
                    response,
                    new BadCredentialsException("Token expired", e)
            );
            return;

        } catch (MalformedJwtException | SignatureException e) {

            authenticationEntryPoint.commence(
                    request,
                    response,
                    new BadCredentialsException("Invalid token", e)
            );
            return;

        } catch (AuthenticationException e) {

            authenticationEntryPoint.commence(request, response, e);
            return;

        } catch (Exception e) {

            authenticationEntryPoint.commence(
                    request,
                    response,
                    new BadCredentialsException("Invalid token", e)
            );
            return;
        }

        filterChain.doFilter(request, response);
    }
}
