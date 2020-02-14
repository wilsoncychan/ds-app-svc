package com.rad.kit.dsappsvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SimpleWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleWebSecurityConfiguration.class);

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/demo/*").permitAll()
                .anyRequest().authenticated();
    }
}
