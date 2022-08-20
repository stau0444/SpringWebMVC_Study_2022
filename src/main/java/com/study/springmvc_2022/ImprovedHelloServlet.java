package com.study.springmvc_2022;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/improved-hello"})
public class ImprovedHelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String servletName = getServletConfig().getServletName();
        req.setAttribute("userName",name);
        req.setAttribute("servletName",servletName);
        RequestDispatcher requestDispatcher =req.getRequestDispatcher("/webapp/improved-hello.jsp");
        requestDispatcher.forward(req,resp);



    }
}
