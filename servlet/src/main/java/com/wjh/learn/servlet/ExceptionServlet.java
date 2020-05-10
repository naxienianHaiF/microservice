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
        // 分析 Servlet 异常
        Throwable throwable = (Throwable)
                req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer)
                req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String)
                req.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null){
            servletName = "Unknown";
        }
        String requestUri = (String)
                req.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null){
            requestUri = "Unknown";
        }


        res.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = res.getWriter();
        writer.println("<title>error-page -- error-code</title>");
        writer.println("<h2>inner error </h2>");
        writer.println("url is " + requestUri + "<br />");
        writer.println("exception is " + throwable + " <br/>");
        writer.println("http code is " + statusCode + " <br/>");
        writer.println("time is " + Instant.now(Clock.systemDefaultZone()));
    }
}
