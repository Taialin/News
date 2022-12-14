package com.example.news.controllers;


import com.example.news.dob.*;
import com.example.news.repository.SubscriptionsRepository;
import com.example.news.repository.UserChoiceRepository;
import com.example.news.services.PriceService;
import com.example.news.services.SubscriptionsServices;
import com.example.news.services.UserChoiceService;
import com.example.news.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class UserChoiceController {

    @Autowired
    private UserChoiceRepository userChoiceRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private SubscriptionsServices subscriptionsServices;

    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    @Autowired
    private UserChoiceService userChoiceService;

    @RequestMapping(value="/profile",method = RequestMethod.GET)
    public String showProfilePage(Model model, @AuthenticationPrincipal User user, Subscriptions subscriptions, Price price) {
        user = userService.findUserById(user.getId());
        List<Price> prices = priceService.findAllById(subscriptions.getId());
        List<UserChoice> userChoices = userChoiceRepository.findUserChoicesByUserIdAndSubIdNotNull(Math.toIntExact(user.getId()));
        List<Long> subscriptionIds = userChoices.stream().map(userChoice -> Long.valueOf(userChoice.getSubId())).collect(Collectors.toList());
        List<Long> priceId = userChoices.stream().map(userChoice -> Long.valueOf(userChoice.getSubId())).collect(Collectors.toList());
        model.addAttribute("profile", userChoices);
        model.addAttribute("user", user);
        model.addAttribute("sub", subscriptionsRepository.findAllById(subscriptionIds));
        model.addAttribute("cost",  prices);
        return "userSubChoicePage";
    }

    @RequestMapping(value = "/userSub", method = RequestMethod.POST)
    public String UserNewsForm(@RequestParam("user_id") int userId, Model model) {
        model.addAttribute("userNewsChoice", userChoiceRepository.findUserChoicesByUserIdAndSubIdNotNull(userId));
        return "userSubChoicePage";

    }

    @GetMapping("/unsubscribe/{id}")
    public String  deleteSubscriptions(@PathVariable("id") Long choiceId, RedirectAttributes redirectAttributes) {
        try {
            userChoiceService.deleteSubscription(choiceId);
            redirectAttributes.addFlashAttribute("message","Unsubscribe " + id );
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/profile";

    }
}
