package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by Eric on 2/27/2017.
 */
@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//
//    private DataSource dataSource;
//
//    @Value("${spring.queries.users-query}")
//    private String usersQuery;



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();//delete this to get back to normal
        http
                .authorizeRequests()
                .antMatchers("/", "/index", "/register")
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();

    }

    //Creates an in-memory user. Temp for now, users & pwds should go in db
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user1").password("password").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user2").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("user3").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("rek").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("fx").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("zwarren").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("aren123").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("rbl").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("lol").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("hz").password("password").roles("USER");
    }

}
