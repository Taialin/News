package com.example.demo.controllers;

import com.example.demo.services.impl.RssFeedView;
import com.example.demo.dob.MyNews;
import com.example.demo.services.NewsLinksServices;
import com.example.demo.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsServices newsServices;

    @Autowired
    private NewsLinksServices newsLinksServices;
    @Autowired
    private RssFeedView rssFeedView;


    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public String newsForm(Model model,
                           @Param("keyword") String keyword) {
        model.addAttribute("news", newsServices.getAllNews(keyword));
        return "newsPage";
    }

    @GetMapping("/newsView")
    public String newsPage(Model model) {
        model.addAttribute("news", newsServices.getAllNews());
        return "newsPage";
    }

    @GetMapping("/save")
    @CrossOrigin(origins = "*")
    public String fetchAllNews() throws Exception {
        rssFeedView.persistAllNews(newsLinksServices.getLink(2L).getLinkRSS());
        return "done";
    }

    @RequestMapping(value = "/seeByTitle", method = RequestMethod.GET)
    public List<MyNews> getAllNews(String title) {
        return newsServices.findByTitle(title);
    }

    @RequestMapping(value = "/seeAllByCategory", method = RequestMethod.POST)
    public List<MyNews> getAllNews(@RequestBody List<String> category) {
        return newsServices.findAllByCategory(category);
    }
}
