package com.example.l13;

import com.example.l13.db.UserDAO;
import com.example.l13.db.StudentDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class ContextListener implements ServletContextListener {
    private UserDAO userDAO;
    private StudentDAO studentDAO;

    @Override
   public void contextInitialized(ServletContextEvent servletContextEvent) {
        Сonnection connection=null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-M01CN9D;database=Users;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false"
                    , "sa", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userDAO = new UserDAO(connection);
       // studentDAO = new StudentDAO(connection);

        final ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("userDAO", userDAO);
       // servletContext.setAttribute("studentDAO", studentDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            userDAO.closeConnection();
            //yachtClubDAO.closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}