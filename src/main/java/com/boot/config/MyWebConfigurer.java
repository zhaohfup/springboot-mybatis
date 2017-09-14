package com.boot.config;

import com.boot.intercepter.ParamInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by bst on 2016/12/20.
 */
@Configuration
@EnableWebMvc
public class MyWebConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ParamInterceptor());
        super.addInterceptors(registry);
    }
}
