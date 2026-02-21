package com.learning.sales.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails John = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();

        UserDetails Mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();

        UserDetails Susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(John, Mary, Susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/item").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/api/item/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/customer").hasRole("MANAGER")
                .requestMatchers(HttpMethod.GET, "/api/customer/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.GET, "/api/sales").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/sales/**").hasRole("ADMIN")
        );

        // use HTTP BASIC AUTH
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
