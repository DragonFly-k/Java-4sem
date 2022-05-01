package com.example.l9;

import com.example.l9.db.User;
import com.example.l9.db.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;

@WebServlet(name = "Registration", value = "/Registration")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String hashPassword = DigestUtils.md5Hex(password);

        if(login == null || password == null) {
            request.setAttribute("info", "Поля не заполнены");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        } else {
            UserDAO userDAO = (UserDAO) request.getServletContext().getAttribute("userDAO");
            if (userDAO.getAll()
                    .stream()
                    .filter(u -> u.getLogin().equals(login))
                    .findFirst().orElse(null) != null) {
                request.setAttribute("info", "Пользователь с таким логином уже существует");
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            } else {
                User user = new User();
                user.setLogin(login);
                user.setPassword(hashPassword);
                user.setRole(User.ROLE.USER);
                userDAO.insert(user);
                request.setAttribute("info", "Пользователь зарегистрирован");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
