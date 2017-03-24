package com.example.controller;

import com.example.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by Eric on 2/27/2017.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");

        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        //registry.addViewController("/members").setViewName("members");
        //registry.addViewController("/register").setViewName("register");
    }


}
