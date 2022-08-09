package com.example.news.controllers;


import com.example.news.repository.UserChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserChoiceController {

 /*   @Autowired
    UserChoiceRepository userChoiceRepository;

    @RequestMapping( value = "/userSub", method = RequestMethod.POST)
    public String UserSubForm(Model model){
        model.addAttribute("userSubChoice", userChoiceRepository.findAllByUser_idAndSub_idNotNull());
        return "userSubChoicePage";

    }

    @RequestMapping( value = "/userNews", method = RequestMethod.POST)
    public String UserNewsForm(Model model){
        model.addAttribute("userNewsChoice", userChoiceRepository.findAllByUser_idAndNews_idNotNull());
        return "userSubChoicePage";

    }*/
}
