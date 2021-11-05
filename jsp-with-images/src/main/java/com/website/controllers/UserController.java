package com.website.controllers;

import com.website.entities.User;
import com.website.mockDatabase.MockDatabase;
import com.website.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    MockDatabase mockDatabase;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        ArrayList<User> allUsers = mockDatabase.findAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "allUsers";
    }

    @GetMapping("/users/{userId}")
    public String showOneUser(Model model, @PathVariable int userId) {
        model.addAttribute("user", mockDatabase.findUserById(userId));
        return "user";
    }

    @GetMapping("/users/add")
    public String showAddUserForm() {
        return "addUser";
    }

    @PostMapping("/users/add")
    public String addUser(
            Model model,
            @RequestParam("name") String name,
            @RequestParam("phoneNumber") Long phoneNumber,
            @RequestParam("email") String email,
            @RequestParam(value = "image", required = false) MultipartFile imageFile
    ) {
        String imageName = userService.validateImageNameUniqueness(imageFile);

        try {
            userService.handleImageUpload(imageName, imageFile);
            User user = new User(name, email, phoneNumber, "/images/" + imageName);
            mockDatabase.addUserToMockDatabase(user);

            model.addAttribute("allUsers", mockDatabase.findAllUsers());
            return "allUsers";

        } catch (Exception e) {
            System.out.println("Image could not be saved");
            return "addUser";
        }

    }
}
