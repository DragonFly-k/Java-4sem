package com.example.l9_10;

import com.example.l9_10.DB.ConnectorDb;
import com.example.l9_10.DB.RequestManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int group = Integer.parseInt(req.getParameter("group"));
        int ID = Integer.parseInt(req.getParameter("ID"));
        String name = req.getParameter("name");
        int course = Integer.parseInt(req.getParameter("course"));
        ConnectorDb connectorDb = new ConnectorDb();
        try {
            RequestManager requestManager = new RequestManager(connectorDb.getConnection("Users"));
            requestManager.addSubject(group, ID, name, course);
            getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);
            requestManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }

    }

}
