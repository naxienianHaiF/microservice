package com.wjh.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author wjh
 * @date 2020/4/11 13:47
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get method...");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            String value = req.getParameter(element);
            System.out.println("[request] name = " + element + ", value = " + value);
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(Thread.currentThread().getName() + "<br />");
        resp.getWriter().println("<h1>login success</h1>");
    }
}
