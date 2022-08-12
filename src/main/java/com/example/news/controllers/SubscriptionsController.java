package com.example.news.controllers;

import com.example.news.dob.Price;
import com.example.news.dob.Subscriptions;
import com.example.news.services.PriceService;
import com.example.news.services.SubscriptionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
public class SubscriptionsController {

    @Autowired
    SubscriptionsServices subscriptionsServices;

    @Autowired
    PriceService priceService;

    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    public String subForm(Model model, Subscriptions subscriptions ) {
        model.addAttribute("subscription", subscriptionsServices.findAll());
        return "subscriptionPage";
    }

    @GetMapping("/subscriptionView")
    public String supPage(Model model, Subscriptions subscriptions ) {
        model.addAttribute("subscription", subscriptionsServices.findAll());
        model.addAttribute("cost",  priceService.findAllById(subscriptions.getId()));
        return "subscriptionPage";
    }


}
