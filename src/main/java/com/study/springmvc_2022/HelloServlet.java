package com.study.springmvc_2022;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqName = req.getParameter("name");
        String servletName = getServletConfig().getServletName();
        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<head>");
        html.append("<title>간단 서블릿 개발</title>");
        html.append("</head>");
        html.append("<body>");
        html.append("<h1>안녕하세요 "+reqName+"</h1>");
        html.append("<h1>저는 "+servletName+"입니다.</h1>");
        html.append("</body>");
        html.append("</html>");

        resp.setStatus(200);
        resp.setContentType("text/html; charset=UTF-8");

        resp.getWriter().write(html.toString());

    }
}
