package com.example.news.controllers;


import com.example.news.repository.UserChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserChoiceController {

    @Autowired
    UserChoiceRepository userChoiceRepository;

    @RequestMapping(value = "/userSub/{id}", method = RequestMethod.POST)
    public String UserSubForm(@PathVariable("id") int userId, Model model) {
        model.addAttribute("userSubChoice", userChoiceRepository.findUserChoiceByUserIdAndNewsIdNotNull(userId));
        return "userSubChoicePage";

    }

    @RequestMapping(value = "/userNews/{id}", method = RequestMethod.POST)
    public String UserNewsForm(@PathVariable("id") int userId, Model model) {
        model.addAttribute("userNewsChoice", userChoiceRepository.findUserChoiceByUserIdAndSubIdNotNull(userId));
        return "userSubChoicePage";

    }
}
