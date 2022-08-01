package com.example.news.services.impl;

import com.example.news.dob.NewsCategory;
import com.example.news.repository.NewsCategoryRepository;
import com.example.news.services.NewsCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsCategoryServiceImpl implements NewsCategoryServices {
    @Autowired
    NewsCategoryRepository newsCategoryRepository;

    @Override
    public NewsCategory save(NewsCategory newsCategory) {
        return  newsCategoryRepository.save(newsCategory);

    }
    public List<NewsCategory> findAll() {
        return (List<NewsCategory>) newsCategoryRepository.findAll();
    }

    @Override
    public List<NewsCategory> findAllByIds(List<Long> ids) {
        return findAll().stream().filter(place -> ids.contains(place.getId())).collect(Collectors.toList());
    }

}
