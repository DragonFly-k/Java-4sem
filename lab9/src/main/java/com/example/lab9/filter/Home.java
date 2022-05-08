package com.example.lab9.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {//параметры запроса,загруж инф для передачи клиенту
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println(new Date() + " <br>" + "Hello World!");

        HttpSession httpSession = request.getSession(true);
        long time = httpSession.getCreationTime();

        long a = new Date().getTime();
        printWriter.println("<a href='/lab9-1.0-SNAPSHOT'>Back</a>");
        printWriter.println("</html>");
        printWriter.close();
    }
}