package com.stan.jwtauthenticationbackend.jwtauthenticationbackend.securityConfigurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableJpaAuditing
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception{
   auth.inMemoryAuthentication().withUser("stanley").password(passwordEncoder().encode("stan")).authorities("USER", "ADMIN");
}
@Bean
public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();

}


@Override
   protected void configure(HttpSecurity http) throws Exception{
   // http.authorizeRequests().anyRequest().permitAll();
    http.authorizeRequests().anyRequest().authenticated();
    http.formLogin();

}

}
