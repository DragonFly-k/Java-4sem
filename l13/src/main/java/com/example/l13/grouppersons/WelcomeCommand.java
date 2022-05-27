package com.example.l13.grouppersons;

import com.example.l13.command.Command;
import com.example.l13.command.CommandResult;
import com.example.l13.util.pages.Page;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
/*        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }*/
        return new CommandResult(Page.WELCOME_PAGE.getPage());
    }
}