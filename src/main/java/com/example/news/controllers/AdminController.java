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

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsServices newsServices;

    @Autowired
    private NewsLinksServices newsLinksServices;
    @Autowired
    private RssFeedView rssFeedView;

    @RequestMapping( value = "/admin", method = RequestMethod.POST)
    public String UserSubForm(Model model){
        model.addAttribute("userSubChoice", userService.allUsers());
        return "adminPage";

    }

    @GetMapping("/news")
    public String newsPage(Model model) {
        model.addAttribute("news", newsServices.getAllNews());
        return "newsPage";
    }

    @GetMapping("/upDateNewsFrom")
    @CrossOrigin(origins = "*")
    public String AddNews(@Param("key") int key) throws Exception {
        rssFeedView.persistAllNews(newsLinksServices.getLink((long) key).getLinkRSS());
        return "done";
    }

    @GetMapping("/addOwnNews")
    @CrossOrigin(origins = "*")
    public MyNews news(@RequestBody MyNews news){
        return newsServices.save(news);
    }

    @PostMapping("/adminn")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/adminPage";
    }

    @GetMapping("/adminn/gt/{userId}")
    public String  getUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "adminPage";
    }

}

