package com.example.recipe751.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("logout-success")
    public String logoutSuccess() {
        return "logout-success";
    }
}
