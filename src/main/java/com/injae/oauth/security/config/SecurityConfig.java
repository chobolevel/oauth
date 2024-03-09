package com.injae.oauth.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
        // requestMatchers 활용
        .authorizeHttpRequests(authorizeRequest -> {
          authorizeRequest.requestMatchers("/sign/up").anonymous();
          authorizeRequest.requestMatchers("/oauth/**").authenticated();
          authorizeRequest.anyRequest().permitAll();
        })
        .formLogin(formLogin -> {
          formLogin.loginPage("/sign/in");
          formLogin.loginProcessingUrl("/sign/in");
        });
    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
