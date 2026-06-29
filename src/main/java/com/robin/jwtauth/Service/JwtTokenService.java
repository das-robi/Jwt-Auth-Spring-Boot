package com.robin.jwtauth.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;


@Service
public class JwtTokenService{

    private String secreteKey = "";

    public JwtTokenService() {

        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();

            secreteKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public String GenerateKey(String username){

        Map<String, Objects> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .subject(username)
                .add(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
                .and()
                .signWith(getsKey())
                .compact();
    }

    private SecretKey getsKey() {

        byte[] keyBytes = Decoders.BASE64.decode(secreteKey);

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {

        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getsKey())
                .build().parseSignedClaims(token).getPayload();

    }

    public boolean validateToken(String token, UserDetails userDetails) {

        final String userName = extractUserName(token);

        System.out.println("Checking validate " + userDetails.getUsername());

        return userName.equals(userDetails.getUsername());
    }
}
