package ru.anikanov.tmweb.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.anikanov.tmweb.Service.UserService;
import ru.anikanov.tmweb.entity.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named("login")
@NoArgsConstructor
@SessionScoped
public class LoginBean implements Serializable {
    private String head = "HEAD";
    private String test;
    private String login;
    private String password;
    private User user;
    @Inject
    private UserService userService;

    public String doLogin1() {
        try {
            user = userService.findByLogin(login);
            if (user.getPassword().equals(password)) {
                test = "LOGEDIN";
                return "projectlist";
            } else return "login";
        } catch (Exception e) {
            System.out.println("exception:" + e.getMessage());
            user = null;
            return "login";
        }
    }

    public String doRegister() {
        try {
            final User user = new User(login, password);
            userService.persist(user);
            return "login";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "register";
        }
    }

}
