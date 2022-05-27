package com.example.l13.command.auth;

import com.example.l13.command.CommandResult;
import com.example.l13.command.Command;
import com.example.l13.sesion.SessionAttribute;
import com.example.l13.util.pages.Page;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;

public class SignOutCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(SignOutCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute(SessionAttribute.NAME);
        LOGGER.info("user was above: name:" + username);
        session.removeAttribute(SessionAttribute.NAME);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);

    }
}