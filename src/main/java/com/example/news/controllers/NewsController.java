package com.example.news.controllers;

import com.example.news.dob.MyNews;
import com.example.news.services.NewsLinksServices;
import com.example.news.services.NewsServices;
import com.example.news.services.impl.RssFeedView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    @RequestMapping(value = "/yourNews", method = RequestMethod.POST)
    public String newsAddForm(Model model) {
        model.addAttribute("news", new MyNews());
        return "saveYourNewsPage";
    }

    @PostMapping("/saveYourNews")
    public String registrationProcess(MyNews news) {
        newsServices.save(news);
        return "redirect:/newsPage";
    }

    @GetMapping("/delete/{id}")
    public String  deleteNews(@PathVariable("id") Long newsId, RedirectAttributes redirectAttributes) {
        try {
            newsServices.deleteNews(newsId);
            redirectAttributes.addFlashAttribute("message","News number" + id + "has ben deleted");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/newsView";
    }

}
