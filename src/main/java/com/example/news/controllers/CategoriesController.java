package com.example.news.controllers;

import com.example.news.services.NewsCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class CategoriesController {

    @Autowired
    NewsCategoryServices newsCategoryServices;

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public String catForm(Model model) {
        model.addAttribute("categories", newsCategoryServices.findAll());
        return "categoriesPage";
    }

    @GetMapping("/categoryView")
    public String catPage(Model model) {
        model.addAttribute("categories", newsCategoryServices.findAll());
        return "categoriesPage";
    }
}
