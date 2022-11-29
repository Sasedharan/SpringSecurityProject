package com.em.springbootsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserSecurityConfiguration {
@Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
  http
          .authorizeRequests()
          .antMatchers("/user/context").authenticated()
          .antMatchers("/admin/dashboard").authenticated()
          .and()
          .httpBasic();
  return http.build();
 }
 @Bean
 public UserDetailsService userDetailsService() throws Exception{
 InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
 manager.createUser(User.withUsername("USER")
         .password("{noop}123")
         .roles("User")
         .build());
 manager.createUser(User.withUsername("ADMIN")
         .password("{noop}456")
         .roles("Admin")
         .build());
 return manager;
 }
/*
 @Bean
  public InMemoryUserDetailsManager userDetailService(){
 UserDetails userDetails = User.withUsername("USER")
         .password("123")
         .roles("user")
         .build();
 User.withUsername("ADMIN")
         .password("456")
         .roles("admin")
         .build();
 return new InMemoryUserDetailsManager(userDetails);
  }
  @Bean
 public PasswordEncoder passwordEncoder(){
 return NoOpPasswordEncoder.getInstance();
 }*/

 }

