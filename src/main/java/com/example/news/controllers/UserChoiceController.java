package com.example.news.controllers;


import com.example.news.dob.MyNews;
import com.example.news.dob.Price;
import com.example.news.dob.Subscriptions;
import com.example.news.dob.User;
import com.example.news.repository.SubscriptionsRepository;
import com.example.news.repository.UserChoiceRepository;
import com.example.news.services.PriceService;
import com.example.news.services.SubscriptionsServices;
import com.example.news.services.impl.UserService;
import com.example.news.services.impl.userChoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class UserChoiceController {

    @Autowired
    private UserChoiceRepository userChoiceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private SubscriptionsServices subscriptionsServices;


    @Autowired
    private SubscriptionsRepository subscriptionsRepository;



 /*   @RequestMapping(value="/profile",method = RequestMethod.GET)
    public String showProfilePage(Model model) {
        model.addAttribute("profile", userChoiceRepository.findAll()) ;
        return "userSubChoicePage";
    }*/

    @RequestMapping(value="/profile",method = RequestMethod.GET)
    public String showProfilePage(Model model, @AuthenticationPrincipal User user) {
        user = userService.findUserById(user.getId());
        List<Subscriptions> sub = subscriptionsRepository.findAllById(user.getId());
        List<Price> price = priceService.findAllById(user.getId());
        model.addAttribute("profile", userChoiceRepository.findUserChoicesByUserIdAndNewsIdNotNull(Math.toIntExact(user.getId())));
        model.addAttribute("user", user);
        model.addAttribute("sub", sub);
        model.addAttribute("price", price);
        return "userSubChoicePage";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String UserSubForm(Model model, User user, Price price, Subscriptions subscriptions) {
        List<User> prof = userService.findAll();
        model.addAttribute("profile", userChoiceRepository.findUserChoicesByUserIdAndNewsIdNotNull(Math.toIntExact(user.getId())));
        model.addAttribute("profile", priceService.findAllById(user.getId()));
        model.addAttribute("profile", prof);
        return "userSubChoicePage";

    }

    @RequestMapping(value = "/userSub", method = RequestMethod.POST)
    public String UserNewsForm(@RequestParam("user_id") int userId, Model model) {
        model.addAttribute("userNewsChoice", userChoiceRepository.findUserChoicesByUserIdAndSubIdNotNull(userId));
        return "userSubChoicePage";

    }

    @GetMapping("/unsubscribe/{id}")
    public String  deleteNews(@PathVariable("id") Long subId, RedirectAttributes redirectAttributes) {
        try {
            subscriptionsServices.unsubscribe(subId);
            redirectAttributes.addFlashAttribute("message","Unsubscribe " + id );
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/profile";

    }
}
