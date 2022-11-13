package com.mbadady.EazyBank.securityConfig;

//import com.mbadady.EazyBank.filter.JWTTokenGeneratorFilter;
//import com.mbadady.EazyBank.filter.JWTValidatorFilter;
import com.mbadady.EazyBank.filter.JWTTokenGeneratorFilter;
import com.mbadady.EazyBank.filter.JWTValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
////        this is for cross-origin resource configuration globally instead of using @Crossorigin annotation on each controller
//        http
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()  //this is going to tell spring security not to generate a token and that i will handle it
//                .cors().configurationSource(new CorsConfigurationSource() {
//            @Override
//            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//                CorsConfiguration config = new CorsConfiguration();
//                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//                config.setAllowedMethods(Collections.singletonList("*"));
//                config.setAllowCredentials(true);
//                config.setExposedHeaders(Arrays.asList("Authorization"));   // telling the browser to accept the token as header
//                config.setMaxAge(3600L);
//                config.setAllowedHeaders(Collections.singletonList("*"));
//
//                return config;
//            }
//        })
//        .and().csrf().ignoringAntMatchers("/contacts", "/signup").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and().addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
//                .addFilterBefore(new JWTValidatorFilter(), BasicAuthenticationFilter.class)
//                .authorizeRequests()
//                        .antMatchers("/accounts", "/cards", "/loans", "/balance","/user").authenticated()
//                        .antMatchers("/notices", "/contacts","/signup").permitAll()
//                .and().formLogin()
//                .and().httpBasic().and().csrf().disable();
//        return http.build();
//    }
//
//    // Approach 1 for using InMemory Authentication. we use withDefaultPasswordEncoder() method for creating user details
//
////    @Bean
////    public InMemoryUserDetailsManager userDetails(){
////        UserDetails admin = User.withDefaultPasswordEncoder()
////                .username("Mbadady")
////                .password("Mbadady1_")
////                .authorities("admin")
////                .build();
////
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .authorities("user")
////                .password("manchi")
////                .username("Manchi")
////                .build();
////
////        return new InMemoryUserDetailsManager(admin, user);
////    }
//
//    // Approach 2 for using NoOpPasswordEncoder. we return a bean of NoOpPasswordEncoder
//    //we use NoOpPasswordEncoder() method for creating user detail
//
////    @Bean
////    public InMemoryUserDetailsManager userDetails(){
////        UserDetails admin = User.withUsername("Mbadady")
////                .password("Mbadady1_")
////                .authorities("admin")
////                .build();
////
////        UserDetails user = User.withUsername("Manchi")
////                .authorities("user")
////                .password("manchi")
////                .build();
////
////        return new InMemoryUserDetailsManager(admin, user);
////    }
//
////    @Bean
////    public UserDetailsService userDetailsService(DataSource dataSource){
////        return new JdbcUserDetailsManager(dataSource);
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
////        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
//    }
@Bean
SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .cors().configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                }
            }).and().csrf().ignoringAntMatchers("/contacts","/signup").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
            .addFilterBefore(new JWTValidatorFilter(), BasicAuthenticationFilter.class)
            .authorizeHttpRequests()
            .antMatchers("/accounts").hasRole("USER")
            .antMatchers("/balance").hasAnyRole("USER","ADMIN")
            .antMatchers("/loans").hasRole("USER")
            .antMatchers("/cards").hasRole("USER")
            .antMatchers("/user").authenticated()
            .antMatchers("/notices","/contacts","/signup").permitAll()
            .and().formLogin()
            .and().httpBasic();
    return http.build();
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
