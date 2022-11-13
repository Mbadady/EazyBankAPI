package com.mbadady.EazyBank.filter;
//
import com.mbadady.EazyBank.constants.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
//
//
////    @Autowired
////    private JwtTokenGenerator jwtTokenGenerator;
//    /**
//     * Same contract as for {@code doFilter}, but guaranteed to be
//     * just invoked once per request within a single request thread.
//     * See {@link #shouldNotFilterAsyncDispatch()} for details.
//     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
//     * default ServletRequest and ServletResponse ones.
//     *
//     * @param request
//     * @param response
//     * @param filterChain
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // to make sure the user is authenticated before generating the token
//
//        if(authentication != null){
////            String jwt = jwtTokenGenerator.generateToken(authentication);
//
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
//            response.setHeader(SecurityConstants.JWT_HEADER, jwt); // this will return the jwt with the header
//        }
//
//
//        filterChain.doFilter(request, response);
//
//        }
//
//
//
//// This will return false and will only execute during login
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        return !request.getServletPath().equals("/user");
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


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder().setIssuer("Eazy Bank").setSubject("JWT Token")
                    .claim("username", authentication.getName())
                    .claim("authorities", populateAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + 30000000))
                    .signWith(key).compact();
            response.setHeader(SecurityConstants.JWT_HEADER, jwt);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/user");
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
}
