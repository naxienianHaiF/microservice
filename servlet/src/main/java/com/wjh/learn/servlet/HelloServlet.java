package com.wjh.learn.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author wjh
 * @date 2020/4/6 20:16
 */
public class HelloServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("hello servlet");
    }

    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig()");
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            System.out.println(key + ", " + servletRequest.getAttribute(key));
        }

        Enumeration<String> parameterNames = servletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println("getParameterNames() " + name + ", " + servletRequest.getParameter(name));
        }

        Map<String, String[]> map = servletRequest.getParameterMap();
        map.forEach((k,v) -> System.out.println("getParameterMap() k = " + k + ", value = "
                + v));

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println("method is " + method);
        System.out.println("thread name is " + Thread.currentThread().getName());

        servletResponse.getWriter().println("thread name is " +
                Thread.currentThread().getName());
        servletResponse.getWriter().println("hello servlet");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("Hello Servlet destroy...");
    }
}
