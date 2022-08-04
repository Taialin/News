package com.example.news.controllers;

import com.example.news.components.RssFeedView;
import com.example.news.dob.MyNews;
import com.example.news.repository.NewsRepository;
import com.example.news.services.NewsCategoryServices;
import com.example.news.services.NewsLinksServices;
import com.example.news.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/value")
    public List<MyNews> getAllNews() {
        return newsServices.getAllNewss();

    }


    @GetMapping("/save")
    @CrossOrigin(origins = "*")
    public String all() throws Exception {
        List<MyNews> list = new RssFeedView(newsLinksServices.getLink(2L).getLinkRSS(),newsCategoryServices).getAll();
        for (MyNews item : list) {
            newsServices.save(item);
        }
        return "done";
    }


    @RequestMapping("/v")
    @ResponseBody
    public List<MyNews> getFeed() throws Exception {
        return new RssFeedView("https://s13.ru/rss",newsCategoryServices).getAll();
    }

    @RequestMapping(value="/news", method=RequestMethod.POST)
    public String newsForm(Model model,
                           @Param("keyword") String keyword) {
        List<MyNews> news = newsServices.getAllNews(keyword);
        List<MyNews> newsList = new ArrayList<>(newsRepository.findAll());
       // List<MyNews> newsAll = newsServices.getAllNewss();
        model.addAttribute("news",newsList);
       // model.addAttribute("keyword",keyword);
        return "news.html";
    }

    @RequestMapping(value="/news",method=RequestMethod.POST)
    public ModelAndView getAllNewsV() {
        ModelAndView mav = new ModelAndView("news.html");
        mav.addObject("news",newsRepository.findAll());
        return mav;
    }



 /*   @RequestMapping(value="/seeByTitles", method= RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public List<News> FNews(@RequestBody List<News> title) {

        return newsServices.findByTitle("Август");
    }*/

    @RequestMapping(value="/seeByTitle", method= RequestMethod.GET)
    public List<MyNews> getAllNews(String title) {
        return newsServices.findByTitle(title);
    }

    @RequestMapping(value="/seeAllByCategory", method= RequestMethod.POST)
    public List<MyNews> getAllNews(@RequestBody List<String> category) {
        return newsServices.findAllByCategory(category);
    }


}
