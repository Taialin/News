package com.example.demo.controllers;

import com.example.demo.services.SubscriptionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SubscriptionsController {

    @Autowired
    SubscriptionsServices subscriptionsServices;

    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    public String subForm(Model model) {
        model.addAttribute("subscription", subscriptionsServices.findAll());
        return "subscriptionPage";
    }

    @GetMapping("/subscription")
    public String supPage(Model model) {
        model.addAttribute("subscription", subscriptionsServices.findAll());
        return "subscriptionPage";
    }
}
