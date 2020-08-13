package com.ljb.springbootcrud.config;

import com.ljb.springbootcrud.filter.Myfilter;
import com.ljb.springbootcrud.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import java.util.Arrays;

@Configuration
public class MyServerConfig {
    //自定义servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myservlet");
        return registrationBean;
    }
    //自定义过滤器
    @Bean
    public FilterRegistrationBean myfilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Myfilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
        return registrationBean;
    }
}
