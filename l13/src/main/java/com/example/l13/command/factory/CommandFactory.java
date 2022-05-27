package com.example.l13.command.factory;

import com.example.l13.command.Command;
import com.example.l13.command.LoginPageCommand;
import com.example.l13.command.RegisterPageCommand;
import com.example.l13.command.auth.LoginCommand;
import com.example.l13.command.auth.RegisterNewUserCommand;
import com.example.l13.command.auth.SignOutCommand;
import com.example.l13.grouppersons.WelcomeCommand;

public class CommandFactory {
    public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand;

        switch (commandEnum) {
            case LOGIN: {
                resultCommand = new LoginCommand(); break;
            }
            case REGISTER_NEW_USER: {
                resultCommand = new RegisterNewUserCommand(); break;
            }
            case SIGN_OUT: {
                resultCommand = new SignOutCommand(); break;
            }
            case LOGIN_PAGE:{
                resultCommand = new LoginPageCommand(); break;
            }
            case WELCOME:{
                resultCommand = new WelcomeCommand(); break;
            }
            case REGISTRATION_PAGE:{
                resultCommand = new RegisterPageCommand(); break;
            }
            default: {
                throw new IllegalArgumentException("Invalid command" + commandEnum);
            }
        }
        return resultCommand;
    }
}