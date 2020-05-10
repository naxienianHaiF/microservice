package com.wjh.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wjh
 * @date 2020/5/10 15:19
 */
public class MakeExceptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(1/0);

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = res.getWriter();
        writer.println("test error-page when happen exception..");
    }
}
