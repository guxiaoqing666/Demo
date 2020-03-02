package com.example.springbootfilter.mvc;

import com.example.springbootfilter.aspect.DemoAspectLog;
import com.example.springbootfilter.filter.DemoFilter;
import com.example.springbootfilter.intercept.DemoInterceptor;
import com.example.springbootfilter.servlet.DemoServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletRegistration;

@Configuration
public class DemoConfig implements WebMvcConfigurer {

    @Autowired
    private DemoInterceptor demoInterceptor;

    /**
     * 注册过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<DemoFilter> DemoFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DemoFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor).addPathPatterns("/*").excludePathPatterns("/index.html", "/");
    }

    /**
     * 注册servlet
     */
    @Bean
    public ServletRegistrationBean<DemoServlet> DemoServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new DemoServlet(), "/demoServlet");
        return servletRegistrationBean;
    }

    @Bean
    public DemoAspectLog demoAspectLog() {
        return new DemoAspectLog();
    }

}
