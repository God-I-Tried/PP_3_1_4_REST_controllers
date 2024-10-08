package ru.kata.spring.rest_controller.demo.service;

import ru.kata.spring.rest_controller.demo.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Long id);
    Role saveRole(Role role);
    Role updateRole(Role role);
    void deleteRole(Long id);
    List<Role> findAllById(List<Long> asList);
}
