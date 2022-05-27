package com.example.l12;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DemoServlet", value = "/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("fghjkl");
        strings.add("qwerty");
        strings.add("asdfgh");
        strings.add("zxcvbn");
        strings.add("yuiop");
        strings.add("poiuyt");
        strings.add("hgfdsa");
        request.setAttribute("items", strings);

        getServletContext().getRequestDispatcher("/demo.jsp").forward(request, response);
    }
}