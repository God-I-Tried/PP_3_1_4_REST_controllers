package ru.kata.spring.rest_controller.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/user")
    public String getUserPage() {
        return "user";
    }

    @RequestMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @RequestMapping(value={"/login", "/logout"})
    public String getLoginPage() {
        return "login";
    }

}