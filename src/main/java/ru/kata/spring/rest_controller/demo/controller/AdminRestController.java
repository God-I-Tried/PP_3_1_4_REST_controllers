package ru.kata.spring.rest_controller.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.rest_controller.demo.entity.Role;
import ru.kata.spring.rest_controller.demo.entity.User;
import ru.kata.spring.rest_controller.demo.service.RoleService;
import ru.kata.spring.rest_controller.demo.service.UserService;

import java.util.LinkedList;
import java.util.List;
import java.security.Principal;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(Principal principal) {
        LinkedList<User> users = new LinkedList<>(userService.getAll());
        users.addFirst(userService.findByEmail(principal.getName()));
        return ResponseEntity.ok(users);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.editUser(id, user);
        return ResponseEntity.ok(user);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.showUser(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAll(); // Метод в вашем сервисе для получения всех ролей
        return ResponseEntity.ok(roles);
    }
}