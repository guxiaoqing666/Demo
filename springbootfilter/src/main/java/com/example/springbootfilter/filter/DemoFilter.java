package com.example.springbootfilter.filter;

import javax.servlet.*;
import java.io.IOException;

public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("springboot demoFilter init方法调用");
        String filterName = filterConfig.getFilterName();
        System.out.println("fileName:" + filterName);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("springboot demoFilter diFilter调用");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("springboot demoFilter destroy");
    }
}
