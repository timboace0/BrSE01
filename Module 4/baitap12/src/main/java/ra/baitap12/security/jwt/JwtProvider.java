package ra.baitap12.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secret;

    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username){
        Date now = new Date();
        Date expiryDate = new Date(new Date().getTime() + 86_400_000);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSecretKey())
                .compact();
    }

    public Claims getClaimFromToken(String token){
        try {
            return Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw new JwtException("Chữ ký không hợp lệ");
        } catch (MalformedJwtException e) {
            throw new JwtException("Chữ ký bất thường");
        } catch (ExpiredJwtException e){
            throw new JwtException("Chữ ký hết hạn");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateToken(String token){
        return getClaimFromToken(token) != null;
    }

    public String getUsernameFromToken(String token){
        return getClaimFromToken(token).getSubject();
    }

    public String generateRefreshToken(String username){
        Date now = new Date();

        Date expiryDate = new Date(
                now.getTime() + 1L * 24 * 60 * 60 * 1000
        );

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSecretKey())
                .compact();
    }
}
