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

@WebServlet(name = "Register", value = "/register")
public class RegisterServlet extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        try {
            ConnectorDb connectorDb = new ConnectorDb();
            var kek = connectorDb.getConnection("Users");
            RequestManager requestManager = new RequestManager(kek);
            requestManager.addUser(username, password, role);
            getServletContext().getRequestDispatcher("/LoginPass.jsp").forward(request, response);

            requestManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}