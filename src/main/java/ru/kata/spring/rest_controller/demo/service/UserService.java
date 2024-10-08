package ru.kata.spring.rest_controller.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.rest_controller.demo.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAll();

    void addUser(User user);

    void editUser(Long id, User user);

    void deleteUser(long id);

    User showUser(long id);

    User findByEmail(String email);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
