package com.example.demo.filter;

import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Around("org.springframework.web.servlet.DispatcherServlet.service()")
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Long startTime = System.currentTimeMillis();

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        chain.doFilter(request, response);

        Long endTime = System.currentTimeMillis();
        Long executionTime=(endTime - startTime);
        res.addHeader("response-time", executionTime.toString()+"ms");
//        chain.doFilter(req, res);

    }

    @Override
    public void destroy() {

    }
}