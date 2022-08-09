package com.example.news.controllers;

import com.example.news.dob.MyNews;
import com.example.news.repository.UserRepository;
import com.example.news.services.NewsLinksServices;
import com.example.news.services.NewsServices;
import com.example.news.services.impl.RssFeedView;
import com.example.news.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String AddNews(@Param("key") int key) throws Exception {
        rssFeedView.persistAllNews(newsLinksServices.getLink((long) key).getLinkRSS());
        return "done";
    }


    @GetMapping("/deleteUser/{id}")
    public String  deleteUser(@PathVariable("id") Long userId, RedirectAttributes redirectAttributes) {
        try {
            newsServices.deleteNews(userId);
            redirectAttributes.addFlashAttribute("message","User with id " + id + "has ben deleted");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin";
    }


}

