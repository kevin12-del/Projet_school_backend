package com.kevin.gestionscolaire.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // désactiver CSRF si nécessaire
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
                // autoriser toutes les requêtes sans auth
        return http.build();
    }
}
