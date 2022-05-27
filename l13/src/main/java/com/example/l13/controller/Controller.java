package com.example.l13.controller;

import com.example.l13.command.Command;
import com.example.l13.command.CommandResult;
import com.example.l13.command.factory.CommandFactory;
import com.example.l13.util.pages.Page;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class Controller  extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String ERROR_MESSAGE = "error_message";
    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response); }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response); }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);
        LOGGER.info(COMMAND + "= " + command);
        Command action = CommandFactory.create(command);
        CommandResult commandResult;
        try {
            commandResult = action.execute(request, response);
        } catch (Exception e) {
            //LOGGER.error(e.getMessage(), e);
            request.setAttribute(ERROR_MESSAGE, e.getMessage());
            commandResult = new CommandResult(Page.ERROR_PAGE.getPage(), false);
        }
        String page = commandResult.getPage();
        if (commandResult.isRedirect()) { sendRedirect(response, page);
        } else { dispatch(request, response, page); }
    }
    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }
    private void sendRedirect(HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(page);
    }
}