package ua.edu.chdtu.deanoffice.mobile.backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ua.edu.chdtu.deanoffice.mobile.backend.security.SecurityConstants.TOKEN_HEADER;
import static ua.edu.chdtu.deanoffice.mobile.backend.security.SecurityConstants.TOKEN_PREFIX;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        String token = getToken(request);
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();
        String user;
        String userId;
        List<GrantedAuthority> roles = new ArrayList<>();
        if (token != null) {
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(signingKey)
                        .parseClaimsJws(token)
                        .getBody();
                user = claims.getSubject();
                userId = claims.getIssuer();
                List<String> roleStrs = claims.get("rol", List.class);
                if (roleStrs != null)
                    roles = roleStrs.stream()
                            .map(role -> new SimpleGrantedAuthority((String)role))
                            .collect(Collectors.toList());
            } catch (JwtException e) {
                return null;
            }
            if (user != null) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, roles);
                usernamePasswordAuthenticationToken.setDetails(userId);
                return usernamePasswordAuthenticationToken;
            }
            return null;
        }
        return null;
    }

    private String getToken(HttpServletRequest req) {
        boolean isTokenInHeader = req.getHeader(TOKEN_HEADER) != null;

        if (isTokenInHeader) {
            return req.getHeader(TOKEN_HEADER).replace(TOKEN_PREFIX, "");
        } else {
            return req.getParameter("auth-jwt-token");
        }
    }
}
