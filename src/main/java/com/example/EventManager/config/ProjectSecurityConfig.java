package com.example.EventManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.ignoringRequestMatchers("/eventTypes")
                        .ignoringRequestMatchers("/saveEvent"))
                .authorizeHttpRequests((requests) ->
                        requests.requestMatchers("/assets/**").permitAll()
                                .requestMatchers("/dashboard").permitAll()
                                .requestMatchers("/", "/home").permitAll()
                                .requestMatchers("/static/**").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/logout").permitAll()
                                .requestMatchers("/events").permitAll()
                                .requestMatchers("/eventTypes").permitAll()
                                .requestMatchers("/saveEvent").permitAll()
                                .requestMatchers("/contact").permitAll()
                                .requestMatchers("/about").permitAll())
                .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true).permitAll());
        return http.build();
    }
}
