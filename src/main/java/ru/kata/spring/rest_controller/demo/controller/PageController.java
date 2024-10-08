package ru.kata.spring.rest_controller.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/user")
    public String userPage() {
        return "user";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping(value={"/login", "/logout"})
    public String login() {
        return "login";
    }

}