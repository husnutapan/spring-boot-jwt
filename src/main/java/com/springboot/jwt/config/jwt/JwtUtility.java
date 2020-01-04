package com.springboot.jwt.config.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtility {

    @Value("${jwt.token.expiration.in.seconds}")
    private long expirationSecond;

    @Value("${jwt.signing.key.secret}")
    private String secretKey;

    public String generateToken(UserDetails userDetails) {
        final Date creationDate = new Date();
        final Date expireDate = new Date(creationDate.getTime() + expirationSecond * 1000);
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(creationDate).setExpiration(expireDate).compact();
    }


}
