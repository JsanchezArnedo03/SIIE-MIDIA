package com.midia.sistema_notas.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {

    @Value("${jwt.secret.key}")
    private String secretKey;

    public String generateToken(UserDetails userDetails, Long idEmpresa) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("idEmpresa", idEmpresa) // <--- ESTE ES EL PASO CLAVE
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
                .signWith(getSignatureKey())
                .compact();
    }


    // 1. Obtener todos los datos (Claims) del token
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 2. Extraer un dato específico (como el idEmpresa)
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    // 3. Extraer el nombre de usuario (Subject)
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    // 4. EXTRAER ID_EMPRESA (Lo que necesitabas)
    public Long getEmpresaIdFromToken(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("idEmpresa", Long.class);
    }

    // Generar la llave de firma
    private Key getSignatureKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}