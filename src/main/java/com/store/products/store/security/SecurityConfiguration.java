package com.store.products.store.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // set your configuration on the auth object
        auth.inMemoryAuthentication()
                .withUser("abhi")
                .password("abhi")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/saveEngProduct").hasRole("ADMIN")
                .antMatchers("/api/engProduct").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getEncodePassword(){
        return NoOpPasswordEncoder.getInstance();
    }
}
