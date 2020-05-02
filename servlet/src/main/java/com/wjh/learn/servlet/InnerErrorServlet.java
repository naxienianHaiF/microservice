package com.wjh.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

/**
 * @author wjh
 * @date 2020/5/1 22:16
 */
public class InnerErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = res.getWriter();
        writer.println("<title>request inner error</title>");
        writer.println("<h1>request inner error...<h1>");
        writer.println("time is " + Instant.now());
    }
}
