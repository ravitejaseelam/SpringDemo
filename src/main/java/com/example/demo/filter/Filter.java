package com.example.demo.filter;

import com.example.demo.UserControllerAdvice.UserNotFoundException;
import com.example.demo.controller.UserController;
import com.example.demo.service.UserServiceImpl;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Filter implements javax.servlet.Filter {
    @Autowired
    UserServiceImpl userService;

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
        chain.doFilter(req, res);

    }
}