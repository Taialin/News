package com.example.news.controllers;

import com.example.news.dob.Price;
import com.example.news.dob.Subscriptions;
import com.example.news.dob.User;
import com.example.news.dob.UserChoice;
import com.example.news.repository.PriceRepository;
import com.example.news.repository.UserChoiceRepository;
import com.example.news.services.PriceService;
import com.example.news.services.SubscriptionsServices;
import com.example.news.services.UserChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
public class SubscriptionsController {

    @Autowired
    private SubscriptionsServices subscriptionsServices;

    @Autowired
    private PriceService priceService;

    @Autowired
    private UserChoiceService userChoiceService;

    @Autowired
    private UserChoiceRepository userChoiceRepository;

    @Autowired
    private PriceRepository priceRepository;

    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    public String subForm(Model model, Subscriptions subscriptions ) {
        model.addAttribute("subscription", subscriptionsServices.findAll());
        return "subscriptionPage";
    }

    @GetMapping("/subscriptionView")
    public String supPage( Model model, Subscriptions subscriptions ) {
        model.addAttribute("subscription", subscriptionsServices.findAll());
        model.addAttribute("cost",  priceService.findAllById(subscriptions.getId()));
        return "subscriptionPage";
    }
    @GetMapping(value = "/save/{id}")
    public String  save(@PathVariable("id") int sibId, UserChoice userChoice, @AuthenticationPrincipal User user, Subscriptions subscriptions) {
        userChoice.setUserId(Math.toIntExact(user.getId()));
        userChoice.setSubId(sibId);
        userChoiceService.save(userChoice);
        return "redirect:/subscriptionView";
    }

    @GetMapping("/update/{id}")
    public String changeCost(@PathVariable(name = "id") int costId, @RequestParam(value = "keyword", defaultValue= "10") Integer keyword  , Model model, Subscriptions subscriptions ) {
        model.addAttribute("changeCost",priceRepository.updateCardBalance(keyword,costId));
        return "redirect:/subscriptionView";
    }

}
