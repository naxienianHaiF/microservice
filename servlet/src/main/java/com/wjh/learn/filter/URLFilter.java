package com.wjh.learn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filter demo...
 * @author wjh
 * @date 2020/5/1 20:59
 */
public class URLFilter implements Filter {

    public URLFilter() {
        System.out.println("URL Filter construct...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("URL Filter init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String uri = servletRequest.getRequestURI();
        System.out.println("the uri is " + uri);

        StringBuffer requestURL = servletRequest.getRequestURL();
        System.out.println("the request url is " + requestURL);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("URI Filter  destroy...");
    }
}
