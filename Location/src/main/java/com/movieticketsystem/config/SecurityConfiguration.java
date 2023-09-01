package com.movieticketsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value(value = "${aws.cognito.jwk}")
    private String cognitoJWKS;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET,"/city/{cityName}").hasRole("Admin")
        .requestMatchers(HttpMethod.GET,"/theatre/{theatreId}").hasAnyRole("Admin","Users")
        .requestMatchers(HttpMethod.GET,"/theatre/{theatreName}/getMovies").hasAnyRole("Admin","Users")
        .requestMatchers(HttpMethod.GET,"/movies/{movieId}").hasAnyRole("Admin","Users")
        .requestMatchers(HttpMethod.GET,"/movies/{movieId}/getAllScreens").hasAnyRole("Admin","Users")
        .requestMatchers(HttpMethod.GET,"/screen/{screenId}").hasAnyRole("Admin","Users")
        .requestMatchers(HttpMethod.GET,"/screen/{screenId}/showSeats").hasAnyRole("Admin","Users")
        .requestMatchers(HttpMethod.GET,"/seat/book").hasAnyRole("Admin","Users")
        .requestMatchers("/city/**").hasRole("Admin")
        .requestMatchers("/theatre/**").hasRole("Admin")
        .requestMatchers("/movies/**").hasRole("Admin")
        .requestMatchers("/screen/**").hasRole("Admin")
        .requestMatchers("/seat/**").hasRole("Admin").anyRequest().authenticated())
                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                                        .decoder(jwtDecoder())));
        return http.build();
    }

    @Bean
    public Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new RoleBasedJwtGrantedAuthoritiesConverter());
        return converter;
    }

    @Bean
    public JwtDecoder jwtDecoder() {
    return NimbusJwtDecoder.withJwkSetUri(cognitoJWKS).build();
    }
}