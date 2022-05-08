package com.example.lab9.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCookies", value = "/cookies")
public class GetCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter pw = response.getWriter();
        pw.println("<html>");

        for (Cookie cookie :
                cookies) {
            pw.println("<p>" + cookie.getName() + " : " + cookie.getValue() + "</p>");
        }
        pw.println("<a href='/lab9-1.0-SNAPSHOT'>Back</a>");
        pw.println("</html>");
    }
}
