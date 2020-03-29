package com.zadatak.vicevi_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/addLike/**","/addDislike/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(User.withDefaultPasswordEncoder().username("pperic").password("pero")
                .roles("EMPLOYEE", "USER").build());
        userDetailsList.add(User.withDefaultPasswordEncoder().username("iivic").password("ivan")
                .roles("MANAGER", "USER").build());

/*        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("pperic")
                        .password("pero")
                        .roles("USER")
                        .build();
        */
        return new InMemoryUserDetailsManager(userDetailsList);
    }
}
