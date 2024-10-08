package ru.kata.spring.rest_controller.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.rest_controller.demo.entity.User;
import ru.kata.spring.rest_controller.demo.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<User> getCurrentUser(Principal principal) {
        User user = userService.findByEmail(principal.getName());
        return ResponseEntity.ok(user);
    }
}