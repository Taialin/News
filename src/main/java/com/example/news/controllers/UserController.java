package com.example.news.controllers;

import com.example.news.dob.User;
import com.example.news.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@Controller
@RequestMapping(value = "/login")

public class UserController {
    @Autowired

    private UserService userService;

    @GetMapping("/login")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "redirect:/news.html";
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/login")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.delete(userId);
        }
        return "redirect:/news.html";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  getUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "redirect:/news";
    }

}
