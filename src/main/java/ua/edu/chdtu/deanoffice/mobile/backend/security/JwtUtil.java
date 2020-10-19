package ua.edu.chdtu.deanoffice.mobile.backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.List;

public class JwtUtil {

    public int parseToken(String token) {
        byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token)
                    .getBody();

            return (int) body.get("userId");

        } catch (JwtException | ClassCastException e) {
            return -1;
        }
    }

    public String generateToken(User u, List<String> roles, int id, byte[] signingKey) {

        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
                .setIssuer(SecurityConstants.TOKEN_ISSUER)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                .setSubject(u.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .claim("rol", roles)
                .claim("userId", id)
                .compact();
    }
}
