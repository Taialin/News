package com.example.news.controllers;

import com.example.news.dob.MyNews;
import com.example.news.dob.Subscriptions;
import com.example.news.repository.PriceRepository;
import com.example.news.repository.UserRepository;
import com.example.news.services.*;
import com.example.news.services.impl.RssFeedView;
import com.example.news.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private NewsServices newsServices;
    @Autowired
    private NewsLinksServices newsLinksServices;
    @Autowired
    private RssFeedView rssFeedView;
    @Autowired
    private SubscriptionsServices subscriptionsServices;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PriceService priceService;
    @Autowired
    private NewsCategoryServices newsCategoryServices;

    @RequestMapping(value = "/newsAdmin", method = RequestMethod.POST)
    public String newsAdminForm(Model model,
                           @Param("keyword") String keyword) {
        model.addAttribute("newsAdmin", newsServices.getAllNews(keyword));
        return "adminPage";
    }

    @GetMapping("/newsViewAdmin")
    public String adminPage(Model model) {
        model.addAttribute("newsAdmin", newsServices.getAllNews());
        return "adminPage";
    }

    @GetMapping("/upDateNewsFrom")
    @CrossOrigin(origins = "*")
    public String AddNews() throws Exception {
        rssFeedView.persistAllNews(newsLinksServices.getLink(1L).getLinkRSS());
        return "redirect:/newsViewAdmin";
    }

    @RequestMapping(value = "/subscriptionAdmin", method = RequestMethod.POST)
    public String subForm(Model model, Subscriptions subscriptions ) {
        model.addAttribute("subscription", subscriptionsServices.findAll());
        return "subscriptionAdminPage";
    }
    @GetMapping("/subscriptionAdminView")
    public String supPage( Model model, Subscriptions subscriptions ) {
        model.addAttribute("subscription", subscriptionsServices.findAll());
        model.addAttribute("cost",  priceService.findAllById(subscriptions.getId()));
        return "subscriptionAdminPage";
    }

    @GetMapping("/update/{id}")
    public String changeCost(@PathVariable("id" ) Long sibId, @Param("keyword" ) String keyword , Model model ) {
        model.addAttribute("changeCost",priceRepository.updateCardBalance(Integer.valueOf(keyword), sibId));
        return "redirect:/subscriptionAdminView";
    }


}

