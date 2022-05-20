package com.example.l9_10;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@WebServlet(name = "firstServlet", value = "/firstServlet")
public class FirstServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Time: "+ DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) + "</h1>");
        out.println(getRequestInfo(request, response));
        out.println("<p><b>"+"Information from header:"+"</b></p>");
        out.println(getHeaderInfo(request));
        out.println("</body></html>");
    }

    public String getRequestInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String res = "";
        res+= "<p>"+"Method:    " +  request.getMethod()+"</p>";
        res+= "<p>"+"URL:    "+  request.getRequestURL()+"</p>";
        res+= "<p>"+"Protocol:    "+  request.getProtocol()+"</p>";
        res+= "<p>"+"IP client: "  +  request.getRemoteAddr()+"</p>";
        res += "<p>"+"Name client: " +  request.getRemoteHost() + "   " +  request.getRemoteUser()+"</p>";
        res+="<p>"+"Port number: " +  request.getRemotePort()+"</p>";
        res+="<p>"+"String HTTP-request:  " + request.getQueryString()+"</p>";
        res+="<p>"+"Server name and port:  " +  request.getServerName() +"  " +  request.getServerPort()+"</p>";
        res += "<p>"+"Path:    " +  request.getContextPath()+"</p>";
        return res;
    }

    public String getHeaderInfo(HttpServletRequest request) {
        String result = "";
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getHeader(name);
            result+="<p>"+name+" = "+value+"</p>";
        }
        return result;
    }
    public void destroy() {
    }
}