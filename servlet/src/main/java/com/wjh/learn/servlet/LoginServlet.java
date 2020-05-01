package com.wjh.learn.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 每次请求都会执行
 * {@link javax.servlet.Servlet#service(ServletRequest, ServletResponse)}方法。
 * 每次都是同一个实例，每次请求都会新启一个线程
 * @author wjh
 * @date 2020/4/11 13:47
 */
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        System.out.println("Login Servlet is constructing...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Login Servlet finish...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Login Servlet init...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName() + " get method...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            String value = req.getParameter(element);
            System.out.println("[request] name = " + element + ", value = " + value);
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("thread name is " +
                Thread.currentThread().getName() + "<br />");
        writer.println("this object is " + "<strong>" + this  + "</strong><br/>");
        writer.println("this bean hash is " + this.hashCode() + "<br />");
        writer.println("<h1>login success</h1>");
    }
}
