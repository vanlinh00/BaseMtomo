package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/", "/login", "/css/**", "/js/**").permitAll() // ✅ allow access without login
                        .anyRequest().authenticated() // ❗ everything else requires login
                )
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/oauth2/authorization/google")
//                        .defaultSuccessUrl("/home", true)
//                );
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")  // your custom login page URL
                        .defaultSuccessUrl("/home", true)
                );


        return http.build();
    }
}
