package com.example.l13.command.auth;

import com.example.l13.command.CommandResult;
import com.example.l13.command.Command;
import com.example.l13.db.UserDAO;
import com.example.l13.model.User;
import com.example.l13.sesion.SessionAttribute;
import com.example.l13.util.pages.Page;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.logging.Logger;

import static com.example.l13.command.auth.constatns.AuthConstants.*;
import static java.util.Objects.nonNull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class.getName());

    private void setAttributesToSession(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.NAME, name);
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        if (!nonNull(login) || !nonNull(password)) {
            return forwardLoginWithError(request, ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        }
        String hashPassword = DigestUtils.md5Hex(password);
        boolean isUserFind = initializeUserIfExist(login, hashPassword, request);
        if (!isUserFind) {
            LOGGER.info("user with such login and password doesn't exist");
            return forwardLoginWithError(request, ERROR_MESSAGE, AUTHENTICATION_ERROR_TEXT);
        } else {
            LOGGER.info("user has been authorized: login:" + login + " password:" + password);
            return new CommandResult(COMMAND_WELCOME, false);
        }
    }

    public boolean initializeUserIfExist(String login, String password, HttpServletRequest request) throws Exception {
        UserDAO userDAO = (UserDAO) request.getServletContext().getAttribute("userDAO");
        User user = userDAO.getAll()
                .stream()
                .filter(u -> u.getLogin().equals(login) &&
                        u.getPassword().equals(password))
                .findFirst().orElse(null);

        boolean userExist = false;
        if (user != null) {
            setAttributesToSession(user.getLogin(), request);
            userExist = true;
        }
        return userExist;
    }

    private CommandResult forwardLoginWithError(HttpServletRequest request, final String ERROR, final String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(Page.LOGIN_PAGE.getPage());
    }
}