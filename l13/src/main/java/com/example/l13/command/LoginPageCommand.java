package com.example.l13.command;

import com.example.l13.util.pages.Page;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginPageCommand implements Command{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("LOGIN PAGE");
        return new CommandResult(Page.LOGIN_PAGE.getPage(),false);
    }
}