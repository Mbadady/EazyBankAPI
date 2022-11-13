package com.mbadady.EazyBank.filter;

import com.mbadady.EazyBank.constants.SecurityConstants;
import com.mbadady.EazyBank.customException.BlogApiException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JWTValidatorFilter extends OncePerRequestFilter {
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
//        String jwt = request.getHeader(SecurityConstants.JWT_HEADER);
//
//        if(jwt != null){
//            try {
//                SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
//                Claims claims = Jwts.parserBuilder()
//                        .setSigningKey(key)
//                        .build()
//                        .parseClaimsJws(jwt)
//                        .getBody();
//
//                String username = String.valueOf(claims.get("username"));
//                String authorities = (String) claims.get("authorities");
//
//                Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }catch (SignatureException exception) {
//                throw new BlogApiException(HttpStatus.BAD_REQUEST, "Invalid JWT signature");
//            } catch (MalformedJwtException exception) {
//                throw new BlogApiException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
//            } catch (ExpiredJwtException exception) {
//                throw new BlogApiException(HttpStatus.BAD_REQUEST, "Expired JWT token");
//            } catch (UnsupportedJwtException exception) {
//                throw new BlogApiException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
//            } catch (IllegalArgumentException exception) {
//                throw new BlogApiException(HttpStatus.BAD_REQUEST, "JWT claims string is empty");
//            }
//        }
//
//
//    }
//}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwt = request.getHeader(SecurityConstants.JWT_HEADER);
        if (null != jwt) {
            try {
                SecretKey key = Keys.hmacShaKeyFor(
                        SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));

                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();
                String username = String.valueOf(claims.get("username"));
                String authorities = (String) claims.get("authorities");
                Authentication auth = new UsernamePasswordAuthenticationToken(username, null,
                        AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception e) {
                throw new BadCredentialsException("Invalid Token received!");
            }

        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().equals("/user");
    }
}

