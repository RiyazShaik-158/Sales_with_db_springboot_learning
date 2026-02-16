package com.learning.sales.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails John = User.builder().username("John").password("{noop}test123").roles("EMPLOYEE").build();

        UserDetails Mary = User.builder().username("Mary").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();

        UserDetails Susan = User.builder().username("Susan").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(John, Mary, Susan);
    }

}
