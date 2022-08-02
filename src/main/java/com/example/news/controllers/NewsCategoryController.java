package com.example.news.controllers;

import com.example.news.components.RssFeedView;
import com.example.news.dob.NewsCategory;
import com.example.news.services.NewsCategoryServices;
import com.example.news.services.NewsLinksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cat")
public class NewsCategoryController {

    @Autowired
    NewsCategoryServices newsCategoryServices;

    @Autowired
    NewsLinksServices newsLinksServices;



    @GetMapping("/save")
    @CrossOrigin(origins = "*")
    public String all() throws Exception {
        List<NewsCategory> list = new RssFeedView(newsLinksServices.getLink(2L).getLinkRSS(),newsCategoryServices).getCategory();
        for (NewsCategory item : list) {
            newsCategoryServices.save(item);
        }
        return "done";
    }

}
