package com.example.news.controllers;

import com.example.news.dob.MyNews;
import com.example.news.services.NewsCategoryServices;
import com.example.news.services.NewsLinksServices;
import com.example.news.services.NewsServices;
import com.example.news.services.impl.RssFeedView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    @Autowired
    private NewsCategoryServices newsCategoryServices;


    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public String newsForm(Model model,
                           @Param("keyword") String keyword) {
        model.addAttribute("news", newsServices.getAllNews(keyword));
        return "newsPage";
    }

    @GetMapping("/newsUserView")
    public String newsPage(Model model) {
        model.addAttribute("news", newsServices.getAllNews());
        return "newsPage";
    }

    @GetMapping(value = "/yourNews")
    public String yourNews(Model model) {
        model.addAttribute("allCategories", newsCategoryServices.findAll());
        model.addAttribute("news", new MyNews());
        return "saveYourNewsPage";
    }

    @RequestMapping(value = "/saveYourNews", method = RequestMethod.POST)
    public String savingProcess(MyNews news) {
        newsServices.save(news);
        return "redirect:/newsViewAdmin";
    }


    @GetMapping("/deleteNews/{id}")
    public String  deleteNews(@PathVariable("id") Long newsId, RedirectAttributes redirectAttributes) {
        try {
            newsServices.deleteNews(newsId);
            redirectAttributes.addFlashAttribute("message","News number" + id + "has ben deleted");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/newsViewAdmin";

    }


}
