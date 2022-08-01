package com.example.news.Controllers;

import com.example.news.Com.RssFeedView;
import com.example.news.dob.News;
import com.example.news.services.NewsCategoryServices;
import com.example.news.services.NewsLinksServices;
import com.example.news.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return newsServices.getAllNews();

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

    @RequestMapping(value="/see", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("news", new News());
        return "news";
    }
    @RequestMapping(value="/see", method= RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute News news, Model model) {
        model.addAttribute("news", news);
        return "result";
    }


}
