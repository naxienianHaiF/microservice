package com.wjh.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Clock;
import java.time.Instant;

/**
 * @author wjh
 * @date 2020/5/2 14:06
 */
public class ExceptionServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = res.getWriter();
        writer.println("inner error");
        writer.println("time is " + Instant.now(Clock.systemDefaultZone()));
        super.service(req, res);
    }
}
