package com.lufegaba.datalab.configs;

import com.lufegaba.datalab.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {


    private final AuthenticationProvider authProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(
                c -> c.disable()
        );
        http.cors().configurationSource(request -> {
            final CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("*"));
            cors.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "HEAD", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("Origin", "Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization"));
            cors.setExposedHeaders(List.of("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Authorization"));
            return cors;
        });
        http.authorizeHttpRequests(
                c -> c
                        /*.requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/address/**",
                                            "/api/v1/analysistemplates/**",
                                            "/analysistemplatetechniques/**",
                                            "/clients/**",
                                            "/parameters/**",
                                            "/phones/**",
                                            "/regulations/**",
                                            "/regulationcriteria/**",
                                            "/regulationtemplates/**",
                                            "/sampletypes/**",
                                            "/species/**",
                                            "/techniques/**",
                                            "/templates/**",
                                            "/templatetechniques/**",
                                            "/users/**",
                                            "/workers/**").hasAuthority("ADMIN")
                        .requestMatchers("/analysisorders/**",
                                            "/samples/**",
                                            "/samplings/**").hasAnyAuthority("WORKER", "ADMIN")*/
                        //.anyRequest().authenticated()
                        .anyRequest().permitAll()
                );
        http.sessionManagement(
                s -> s
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        http.authenticationProvider(authProvider);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
