package com.example.lab9.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "GetHeader", value = "/getHeader")
public class GetHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Enumeration<String> headerNames = request.getHeaderNames();

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        // body
        out.println("<body>\n" +
                "<table border=1\n" +
                "<tr><th>Header Name<th>Header Value");
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<tr><td>" + headerName);
            out.println("    <td>" + request.getHeader(headerName));
        }
        out.println("</table>");
        out.println("<a href='/lab9-1.0-SNAPSHOT'>Back</a>");
        out.println("</body></html>");
    }
}
