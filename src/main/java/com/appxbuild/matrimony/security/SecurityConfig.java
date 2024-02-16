package com.appxbuild.matrimony.security;


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
    public InMemoryUserDetailsManager userDetailsManager () {

        UserDetails himanshu = User.builder()
                .username("himanshu")
                .password("{noop}hima123")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(himanshu);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(HttpMethod.GET, "/api/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("EMPLOYEE")
                );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
