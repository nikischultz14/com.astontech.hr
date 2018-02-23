package com.astontech.hr.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //permit all with no authentication

        httpSecurity.authorizeRequests().antMatchers("/").permitAll()
                //we will let anyone in from any url
                .and().authorizeRequests().antMatchers("/console/**").permitAll();
            //anyone can access console
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();



    }
}
