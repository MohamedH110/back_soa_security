package com.example.demo_eleves.security;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        try {
            String jwt = request.getHeader("Authorization");
            
            if (jwt == null || !jwt.startsWith("Bearer ")) {
                System.out.println("No token found or token doesn't start with Bearer");
                filterChain.doFilter(request, response);
                return;
            }

            System.out.println("Original JWT: " + jwt);
            jwt = jwt.substring(7);
            System.out.println("JWT without Bearer: " + jwt);
            
            // Split the token to examine its parts
            String[] parts = jwt.split("\\.");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid token structure");
            }
            
            System.out.println("Token parts: Header=" + parts[0] + ", Payload=" + parts[1] + ", Signature=" + parts[2]);
            System.out.println("Secret being used for verification: " + SecParams.SECRET);
            
            Algorithm algorithm = Algorithm.HMAC256(SecParams.SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                                    .build();
            
            DecodedJWT decodedJWT = verifier.verify(jwt);
            String username = decodedJWT.getSubject();
            System.out.println("Decoded username: " + username);
            
            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
            System.out.println("Decoded roles: " + roles);
            
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (String r : roles) {
                authorities.add(new SimpleGrantedAuthority(r));
            }
            
            UsernamePasswordAuthenticationToken user =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
            
            SecurityContextHolder.getContext().setAuthentication(user);
            System.out.println("Authentication successful");
            
        } catch (Exception e) {
            System.out.println("Error processing JWT token. Error type: " + e.getClass().getName());
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();
            SecurityContextHolder.clearContext();
        }
        
        filterChain.doFilter(request, response);
    }
}