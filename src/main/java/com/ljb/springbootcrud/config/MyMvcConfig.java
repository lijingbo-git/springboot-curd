package com.ljb.springbootcrud.config;

import com.ljb.springbootcrud.component.LoginHandlerInterceptor;
import com.ljb.springbootcrud.component.MyLocalResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ljb").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    //注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/","/user/login");//拦截所有请求除了这三个
//    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
