package ru.kata.spring.rest_controller.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kata.spring.rest_controller.demo.entity.Role;
import ru.kata.spring.rest_controller.demo.entity.User;
import ru.kata.spring.rest_controller.demo.repository.RoleRepository;
import ru.kata.spring.rest_controller.demo.service.UserServiceImpl;

import java.util.HashSet;

@Configuration
public class InitializedData {
    @Bean
    public CommandLineRunner initData(UserServiceImpl userServiceImpl, RoleRepository roleRepository) {
        return args -> {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);

            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);

            HashSet userRoleSet = new HashSet();
            userRoleSet.add(userRole);

            HashSet adminRoleSet = new HashSet();
            adminRoleSet.add(userRole);
            adminRoleSet.add(adminRole);

            User user1 = new User();
            user1.setAge(54);
            user1.setPassword("1");
            user1.setFirstName("first name 1");
            user1.setLastName("last name 1");
            user1.setEmail("1@1");
            user1.setRoles(userRoleSet);
            userServiceImpl.addUser(user1);

            User user2 = new User();
            user2.setAge(17);
            user2.setPassword("123");
            user2.setFirstName("first name 2");
            user2.setLastName("last name 2");
            user2.setEmail("email2@gmail.com");
            user2.setRoles(userRoleSet);
            userServiceImpl.addUser(user2);

            User admin = new User();
            admin.setPassword("123");
            admin.setFirstName("admin");
            admin.setLastName("admin");
            admin.setAge(33);
            admin.setEmail("admin@gmail.com");
            admin.setRoles(adminRoleSet);
            userServiceImpl.addUser(admin);

            User admin1 = new User();
            admin1.setAge(29);
            admin1.setPassword("2");
            admin1.setFirstName("admin");
            admin1.setLastName("admin");
            admin1.setEmail("2@2");
            admin1.setRoles(adminRoleSet);
            userServiceImpl.addUser(admin1);
        };
    }
}
