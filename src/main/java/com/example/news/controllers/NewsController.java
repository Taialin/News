package com.example.news.controllers;

import com.example.news.components.RssFeedView;
import com.example.news.dob.News;
import com.example.news.services.NewsCategoryServices;
import com.example.news.services.NewsLinksServices;
import com.example.news.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    NewsServices newsServices;
    @Autowired
    NewsLinksServices newsLinksServices;
    @Autowired
    NewsCategoryServices newsCategoryServices;

    @GetMapping("/value")
    public List<News> getAllNews() {
        return newsServices.getAllNewss();

    }


    @GetMapping("/save")
    @CrossOrigin(origins = "*")
    public String all() throws Exception {
        List<News> list = new RssFeedView(newsLinksServices.getLink(2L).getLinkRSS(),newsCategoryServices).getAll();
        for (News item : list) {
            newsServices.save(item);
        }
        return "done";
    }


    @RequestMapping("/v")
    @ResponseBody
    public List<News> getFeed() throws Exception {
        return new RssFeedView("https://s13.ru/rss",newsCategoryServices).getAll();
    }

    @RequestMapping(value="/allNews", method=RequestMethod.POST)
    public String newsForm(Model model,
                           @Param("keyword") String keyword) {
        List<News> news = newsServices.getAllNews(keyword);
        model.addAttribute("news",news);
        model.addAttribute("keyword",keyword);
        return "news";
    }


 /*   @RequestMapping(value="/seeByTitles", method= RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public List<News> FNews(@RequestBody List<News> title) {

        return newsServices.findByTitle("Август");
    }*/

    @RequestMapping(value="/seeByTitle", method= RequestMethod.GET)
    public List<News> getAllNews(String title) {
        return newsServices.findByTitle(title);
    }

    @RequestMapping(value="/seeAllByCategory", method= RequestMethod.POST)
    public List<News> getAllNews(@RequestBody List<String> category) {
        return newsServices.findAllByCategory(category);
    }


}
