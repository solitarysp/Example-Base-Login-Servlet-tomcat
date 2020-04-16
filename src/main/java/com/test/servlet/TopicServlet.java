package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/topic")
@ServletSecurity(
        //config role
        value = @HttpConstraint(
                rolesAllowed = {
                        "user", "admin"
                }),
        httpMethodConstraints = {
                //config object base,
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "user", "admin"
                }),
                @HttpMethodConstraint(value = "POST", rolesAllowed = {
                        "admin"
                })
        })
public class TopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Get topic</h2>\n" +
                "\n" +
                "<div>Add topic</div>\n" +
                "<form method=\"post\" action=\"/topic\" >\n" +
                "<input id=\"s\">\n" +
                "    <button type=\"submit\" >Submit</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Done");
    }
}
