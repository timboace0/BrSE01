package ra.baitap101.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String username, List<String> roles) {
        Date now = new Date();

        Date expiryDate = new Date(now.getTime() + expiration);

        byte[] keyBytes = Base64.getDecoder().decode(secret);

        return Jwts.builder()
                .setSubject(username)
                .claim("role", roles)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, keyBytes)
                .compact();
    }

    public String getUserNameFromJWT(String token){
        byte[] keyBytes = Base64.getDecoder().decode(secret);

        Claims claims = Jwts.parser()
                .setSigningKey(keyBytes)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            byte[] keyBytes = Base64.getDecoder().decode(secret);

            Jwts.parser()
                    .setSigningKey(keyBytes)
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
