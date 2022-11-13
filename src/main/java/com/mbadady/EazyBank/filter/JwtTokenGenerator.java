package com.mbadady.EazyBank.filter;

import com.mbadady.EazyBank.constants.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Component
//public class JwtTokenGenerator {
//
//    public String generateToken(Authentication authentication) {
//            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));  // used to generate the key using algorithm HS256
//
//            String jwt = Jwts.builder()
//                    .setIssuer("Eazy_Banks")
//                    .setExpiration(new Date((new Date()).getTime() + 300000))
//                    .setIssuedAt(new Date())
//                    .setSubject(authentication.getName())
//                    .claim("username", authentication.getName())
//                    .claim("authorities", populateAuthorities(authentication.getAuthorities()))
//                    .signWith(key)
//                    .compact();
//
//            return jwt;
//    }
//
//    private String populateAuthorities(Collection<? extends GrantedAuthority> collection){
//        Set<String> authoritiesSet = new HashSet<>();
//
//        for(GrantedAuthority authority : collection){
//            authoritiesSet.add(authority.getAuthority());
//        }
//        return String.join(",", authoritiesSet);
//    }
//}
