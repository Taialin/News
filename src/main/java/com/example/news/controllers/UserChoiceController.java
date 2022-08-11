package com.example.news.controllers;


import com.example.news.dob.Subscriptions;
import com.example.news.dob.User;
import com.example.news.repository.UserChoiceRepository;
import com.example.news.services.impl.UserService;
import com.example.news.services.impl.userChoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserChoiceController {

    @Autowired
    private UserChoiceRepository userChoiceRepository;

    @Autowired
    private UserService userService;

 /*   @RequestMapping(value="/profile",method = RequestMethod.GET)
    public String showProfilePage(Model model) {
        model.addAttribute("profile", userChoiceRepository.findAll()) ;
        return "userSubChoicePage";
    }*/

    @RequestMapping(value="/profile",method = RequestMethod.GET)
    public String showProfilePage(Model model) {
        model.addAttribute("profile", userChoiceRepository.findUserChoicesByUserIdAndNewsIdNotNull(1));
        model.
        return "userSubChoicePage";
    }

    @RequestMapping(value = "/userNews", method = RequestMethod.POST)
    public String UserSubForm(Model model) {
        model.addAttribute("userSubChoice", userChoiceRepository.findUserChoicesByUserIdAndNewsIdNotNull(1));
        return "userSubChoicePage";

    }

    @RequestMapping(value = "/userSub", method = RequestMethod.POST)
    public String UserNewsForm(@RequestParam("user_id") int userId, Model model) {
        model.addAttribute("userNewsChoice", userChoiceRepository.findUserChoicesByUserIdAndSubIdNotNull(userId));
        return "userSubChoicePage";

    }
}
