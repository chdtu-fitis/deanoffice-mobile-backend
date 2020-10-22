package ua.edu.chdtu.deanoffice.mobile.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.List;

public class JwtUtil {
    public static int getUserIdInt() {
        return Integer.parseInt((String)SecurityContextHolder.getContext().getAuthentication().getDetails());
    }

    public String generateToken(User u, List<String> roles, String id) {
        byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
                .setIssuer(id)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                .setSubject(u.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .claim("rol", roles)
                .compact();
    }
}
