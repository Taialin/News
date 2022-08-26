package com.example.news.controllers;

import com.example.news.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserListController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/userList", method = RequestMethod.POST)
    public String userListForm(Model model) {
        model.addAttribute("user", userService.findAll());
        return "userListPage";
    }

    @GetMapping("/userListView")
    public String userListPage(Model model) {
        model.addAttribute("user", userService.findAll());
        return "userListPage";
    }


}
