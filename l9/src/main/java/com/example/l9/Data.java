package com.example.l9;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.time.LocalTime;

@WebServlet(name = "Date", value = "/Date")
public class Data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalTime date = LocalTime.now();
        InetAddress adr = InetAddress.getLocalHost();
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // getData
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println("<body>\n" +
                "<p>Time: " + date.toString() + "</p>\n" +
                "<p> Protocol: " + request.getProtocol() + "</p>\n" +
                "<p> IP client: " + request.getRemoteAddr() + "</p>\n" +
                "<p> IP server: " + adr.getHostAddress() + "</p>\n" +
                "<p> IP local name: " + request.getLocalName() + "</p>\n" +
                "<p> Port name: " + request.getLocalPort() + "</p>\n" +
                "<p> Method name: " + request.getMethod() + "</p>\n");
        out.println("<a href='/l9-1.0-SNAPSHOT'>Назад</a>");
        out.println("</body></html>");
    }
}
