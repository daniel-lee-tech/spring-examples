package com.example.mysqlexample.controllers;

import com.example.mysqlexample.dto.UserDTO;
import com.example.mysqlexample.entities.UserEntity;
import com.example.mysqlexample.repositories.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class UserController {
    // this bean will default to UserRepositoryCustomImpl
    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterable<UserEntity> allUsers = userRepository.findAll();
        model.addAttribute("allUsers", allUsers);
        return "users.html";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable("id") long userId, Model model) {
        Optional<UserEntity> possibleUser = userRepository.findById(userId);

        if (possibleUser.isPresent()) {
            model.addAttribute("userPresent", true);
            model.addAttribute("user", possibleUser.get());
        } else {
            model.addAttribute("userPresent", false);
            model.addAttribute("notFoundId", userId);
        }
        return "showUser.html";
    }

    @GetMapping("/users/add")
    public String showNewUserForm(Model model) {
        model.addAttribute("userDto", new UserDTO());
        return "newUserForm.html";
    }

    @PostMapping("/users/add")
    public String addNewUser(@ModelAttribute("userDto") UserDTO userDTO) {
        UserEntity newUser = new UserEntity(userDTO);
        try {
            userRepository.save(newUser);
            return "redirect:/users";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/users/add";
        }
    }
}
