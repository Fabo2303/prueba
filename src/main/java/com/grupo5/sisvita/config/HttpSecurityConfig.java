package com.grupo5.sisvita.config;

import com.grupo5.sisvita.utilz.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableMethodSecurity
public class HttpSecurityConfig {
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "/auth/public-access").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "/api/usuarios/all").hasAuthority(Permission.READ_ALL_USERS.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/api/preguntas/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "/api/alternativas/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "/api/tests/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "/api/respuestas/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.POST, "/api/tests/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.POST, "/api/respuestas/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "api/api/tiposTests/**").permitAll();
                });
        return http.build();
    }

}
